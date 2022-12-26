package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.MyExcelAds;
import com.google.ads.googleads.examples.AboutProjectForPlay.mysql.MySqlConnt;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.errors.GoogleAdsError;
import com.google.ads.googleads.v12.errors.GoogleAdsException;
import com.google.ads.googleads.v12.resources.Campaign;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.resources.CustomerClient;
import com.google.ads.googleads.v12.resources.CustomerName;
import com.google.ads.googleads.v12.services.CustomerServiceClient;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient.SearchPagedResponse;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersRequest;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersResponse;
import com.google.ads.googleads.v12.services.SearchGoogleAdsRequest;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamRequest;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamResponse;
import com.google.api.gax.rpc.ServerStream;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Gets the account hierarchy of the specified manager account and login customer ID. If you don't
 * specify manager ID and login customer ID, the example will instead print the hierarchies of all
 * accessible customer accounts for your authenticated Google account. Note that if the list of
 * accessible customers for your authenticated Google account includes accounts within the same
 * hierarchy, this example will retrieve and print the overlapping portions of the hierarchy for
 * each accessible customer.
 * 先获取账号层次结构 并保存
 */
public class GeAllAccountAds {

    private static class GetAccountHierarchyParams extends CodeSampleParams {

        @Parameter(names = ArgumentNames.MANAGER_CUSTOMER_ID)
        private Long managerId;

        @Parameter(names = ArgumentNames.LOGIN_CUSTOMER_ID)
        private Long loginCustomerId;
    }
    public  Connection connection;

    public static void main(String[] args) {
        GetAccountHierarchyParams params = new GetAccountHierarchyParams();

        if (params.managerId != null && params.loginCustomerId == null) {
            System.err.println("loginCustomerId must be provided if managerId is provided.");
            return;
        } else if (params.managerId == null && params.loginCustomerId != null) {
            System.err.println("loginCustomerId may not be provided if managerId is not provided.");
            return;
        }

        GoogleAdsClient googleAdsClient = null;
        try {
            googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
        } catch (FileNotFoundException fnfe) {
            System.err.printf(
                    "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
            System.exit(1);
        } catch (IOException ioe) {
            System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
            System.exit(1);
        }

        try {
            new GeAllAccountAds()
                    .runExample(googleAdsClient, params.managerId, params.loginCustomerId);
        } catch (GoogleAdsException gae) {
            // GoogleAdsException is the base class for most exceptions thrown by an API request.
            // Instances of this exception have a message and a GoogleAdsFailure that contains a
            // collection of GoogleAdsErrors that indicate the underlying causes of the
            // GoogleAdsException.
            System.err.printf(
                    "Request ID %s failed due to GoogleAdsException. Underlying errors:%n",
                    gae.getRequestId());
            int i = 0;
            for (GoogleAdsError googleAdsError : gae.getGoogleAdsFailure().getErrorsList()) {
                System.err.printf("  Error %d: %s%n", i++, googleAdsError);
            }
            System.exit(1);
        } catch (IOException ioe) {
            System.err.printf("Request failed. Exception: %s%n", ioe);
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the example.
     *
     * @param googleAdsClient the Google Ads API client.
     * @param managerId the root customer ID from which to begin the search.
     * @param loginCustomerId the loginCustomerId used to create the GoogleAdsClient.
     * @throws IOException if a Google Ads Client is not successfully created.
     */
    private void runExample(GoogleAdsClient googleAdsClient, Long managerId, Long loginCustomerId)
            throws IOException, SQLException, ClassNotFoundException {
        connection  = MySqlConnt.init();
        List<Long> seedCustomerIds = new ArrayList<>();
        if (managerId == null) {
            // Gets the account hierarchies for all accessible customers.
            seedCustomerIds = getAccessibleCustomers(googleAdsClient);
        } else {
            // Only gets the hierarchy for the provided manager ID if provided.
            seedCustomerIds.add(managerId);
        }

        Map<CustomerClient, Multimap<Long, CustomerClient>> allHierarchies = new HashMap<>();
        List<Long> accountsWithNoInfo = new ArrayList<>();
        // Constructs a map of account hierarchies.
        for (Long seedCustomerId : seedCustomerIds) {
            Map<CustomerClient, Multimap<Long, CustomerClient>> customerClientToHierarchy =
                    createCustomerClientToHierarchy(loginCustomerId, seedCustomerId);

            if (customerClientToHierarchy == null) {
                accountsWithNoInfo.add(seedCustomerId);
            } else {
                allHierarchies.putAll(customerClientToHierarchy);
            }
        }

        // Prints the IDs of any accounts that did not produce hierarchy information.
        if (!accountsWithNoInfo.isEmpty()) {
            System.out.println(
                    "Unable to retrieve information for the following accounts which are likely either test "
                            + "accounts or accounts with setup issues. Please check the logs for details.");
            for (long accountId : accountsWithNoInfo) {
                System.out.println(accountId);
            }
            System.out.println();
        }

        int depth = 0;
        // Prints the hierarchy information for all accounts for which there is hierarchy information
        // available.

        for (CustomerClient rootCustomerClient : allHierarchies.keySet()) {
            System.out.printf("Hierarchy of customer ID %d:%n", rootCustomerClient.getId());
            printAccountHierarchy(rootCustomerClient, allHierarchies.get(rootCustomerClient), depth,googleAdsClient);
            System.out.println();
        }
        connection.close();
    }

    /**
     * Creates a map between a CustomerClient and each of its managers' mappings.
     *
     * @param loginCustomerId the loginCustomerId used to create the GoogleAdsClient.
     * @param seedCustomerId the ID of the customer at the root of the tree.
     * @return a map between a CustomerClient and each of its managers' mappings if the account
     *     hierarchy can be retrieved. If the account hierarchy cannot be retrieved, returns null.
     * @throws IOException if a Google Ads Client is not successfully created.
     */
    private Map<CustomerClient, Multimap<Long, CustomerClient>> createCustomerClientToHierarchy(
            Long loginCustomerId, long seedCustomerId) throws IOException {
        Queue<Long> managerAccountsToSearch = new LinkedList<>();
        CustomerClient rootCustomerClient = null;

        // Creates a GoogleAdsClient with the specified loginCustomerId. See
        // https://developers.google.com/google-ads/api/docs/concepts/call-structure#cid for more
        // information.
        GoogleAdsClient googleAdsClient =
                GoogleAdsClient.newBuilder()
                        .fromPropertiesFile()
                        .setLoginCustomerId(loginCustomerId == null ? seedCustomerId : loginCustomerId)
                        .build();

        // Creates the Google Ads Service client.
        try (GoogleAdsServiceClient googleAdsServiceClient =
                     googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
            // Creates a query that retrieves all child accounts of the manager specified in search
            // calls below.
            String query =
                    "SELECT customer_client.client_customer, customer_client.level, "
                            + "customer_client.manager, customer_client.descriptive_name, "
                            + "customer_client.currency_code, customer_client.time_zone, "
                            + "customer_client.id "
                            + "FROM customer_client "
                            + "WHERE customer_client.level <= 1";

            // Adds the seed customer ID to the list of IDs to be processed.
            managerAccountsToSearch.add(seedCustomerId);
            // Performs a breadth-first search algorithm to build a mapping of managers to their
            // child accounts.
            Multimap<Long, CustomerClient> customerIdsToChildAccounts = ArrayListMultimap.create();
            while (!managerAccountsToSearch.isEmpty()) {
                long customerIdToSearchFrom = managerAccountsToSearch.poll();
                SearchPagedResponse response;
                try {
                    // Issues a search request.
                    response =
                            googleAdsServiceClient.search(
                                    SearchGoogleAdsRequest.newBuilder()
                                            .setQuery(query)
                                            .setCustomerId(Long.toString(customerIdToSearchFrom))
                                            .build());

                    // Iterates over all rows in all pages to get all customer clients under the specified
                    // customer's hierarchy.
                    for (GoogleAdsRow googleAdsRow : response.iterateAll()) {
                        CustomerClient customerClient = googleAdsRow.getCustomerClient();

                        // Gets the CustomerClient object for the root customer in the tree.
                        if (customerClient.getId() == seedCustomerId) {
                            rootCustomerClient = customerClient;
                        }

                        // The steps below map parent and children accounts. Continue here so that manager
                        // accounts exclude themselves from the list of their children accounts.
                        if (customerClient.getId() == customerIdToSearchFrom) {
                            continue;
                        }

                        // For all level-1 (direct child) accounts that are manager accounts, the above
                        // query will be run against them to create a map of managers to their
                        // child accounts for printing the hierarchy afterwards.
                        customerIdsToChildAccounts.put(customerIdToSearchFrom, customerClient);
                        // Checks if the child account is a manager itself so that it can later be processed
                        // and added to the map if it hasn't been already.
                        if (customerClient.getManager()) {
                            // A customer can be managed by multiple managers, so to prevent visiting the same
                            // customer multiple times, we need to check if it's already in the map.
                            boolean alreadyVisited =
                                    customerIdsToChildAccounts.containsKey(customerClient.getId());
                            if (!alreadyVisited && customerClient.getLevel() == 1) {
                                managerAccountsToSearch.add(customerClient.getId());
                            }
                        }
                    }
                } catch (GoogleAdsException gae) {
                    System.out.printf(
                            "Unable to retrieve hierarchy for customer ID %d: %s%n",
                            customerIdToSearchFrom, gae.getGoogleAdsFailure().getErrors(0).getMessage());
                    return null;
                }
            }

            // The rootCustomerClient will be null if the account hierarchy was unable to be retrieved
            // (e.g. the account is a test account or a client account with an incomplete billing setup).
            // This method returns null in these cases to add the seedCustomerId to the list of
            // customer IDs for which the account hierarchy could not be retrieved.
            if (rootCustomerClient == null) {
                return null;
            }

            Map<CustomerClient, Multimap<Long, CustomerClient>> customerClientToHierarchy =
                    new HashMap<>();
            customerClientToHierarchy.put(rootCustomerClient, customerIdsToChildAccounts);
            return customerClientToHierarchy;
        }
    }

    /**
     * Retrieves a list of accessible customers with the provided set up credentials.
     *
     * @param googleAdsClient the Google Ads API client.
     * @return a list of customer IDs.
     */
    private List<Long> getAccessibleCustomers(GoogleAdsClient googleAdsClient) {
        List<Long> seedCustomerIds = new ArrayList<>();
        // Issues a request for listing all accessible customers by this authenticated Google account.
        try (CustomerServiceClient customerServiceClient =
                     googleAdsClient.getLatestVersion().createCustomerServiceClient()) {
            ListAccessibleCustomersResponse accessibleCustomers =
                    customerServiceClient.listAccessibleCustomers(
                            ListAccessibleCustomersRequest.newBuilder().build());
            System.out.println(
                    "No manager customer ID is specified. The example will print the "
                            + "hierarchies of all accessible customer IDs:");

            for (String customerResourceName : accessibleCustomers.getResourceNamesList()) {
                Long customer = Long.parseLong(CustomerName.parse(customerResourceName).getCustomerId());
                System.out.println(customer);
                seedCustomerIds.add(customer);
            }
        }
        return seedCustomerIds;
    }

    /**
     * Prints the specified account's hierarchy using recursion.
     *
     * @param customerClient the customer client whose info will be printed and its child accounts
     *     will be processed if it's a manager.
     * @param customerIdsToChildAccounts a map containing the account hierarchy information.
     * @param depth the current depth we are printing from in the account hierarchy.
     */
    private void printAccountHierarchy(
            CustomerClient customerClient,
            Multimap<Long, CustomerClient> customerIdsToChildAccounts,
            int depth,
            GoogleAdsClient googleAdsClient) throws SQLException {
        String leadingSpace = " ";
        if (depth == 0) {
            System.out.println("Customer ID (Descriptive Name, Currency Code, Time Zone");
            leadingSpace = "";
        } else {
            System.out.println("|");
        }
        System.out.print(Strings.repeat("-", depth * 2));
        long customerId = customerClient.getId();
        System.out.printf(
                leadingSpace + "%d ('%s', '%s', '%s')%n",
                customerId,
                customerClient.getDescriptiveName(),
                customerClient.getCurrencyCode(),
                customerClient.getTimeZone());
        System.out.printf(
                leadingSpace + "%d ('%s', '%s', '%s')%n",
                customerId,
                customerClient.getDescriptiveName(),
                customerClient.getCurrencyCode(),
                customerClient.getTimeZone());
//        // 创建对象用来执行sql插入语句
//        PreparedStatement psql =
//                connection.prepareStatement(
//                        "insert into google_ads_data.customer " +
//                                "values("+customerId+",'"+customerClient.getDescriptiveName()+"','"+
//                                customerClient.getCurrencyCode()+"','"+customerClient.getTimeZone()+"');");    // sql插入语句
//        psql.executeUpdate();
//        // 插入结束

        String qurey =
                "SELECT customer.id, " +
                        "customer.status, " +
                        "customer.descriptive_name, " +
                        "customer.time_zone, " +
                        "metrics.all_conversions, " +
                        "metrics.all_conversions_by_conversion_date, " +
                        "metrics.all_conversions_value, " +
                        "metrics.all_conversions_from_interactions_rate, " +
                        "metrics.all_conversions_value_by_conversion_date, " +
                        "metrics.conversions_by_conversion_date," +
                        " metrics.conversions_value_by_conversion_date" +
                        " FROM customer";
//        if(String.valueOf(customerId).equals("3679389997")||String.valueOf(customerId).equals("5877229176")){
//            return;
//        }
//        try (GoogleAdsServiceClient googleAdsServiceClient =
//                     googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
//            String query = "SELECT campaign.id, campaign.name FROM campaign ORDER BY campaign.id";
//            // Constructs the SearchGoogleAdsStreamRequest.
//            SearchGoogleAdsStreamRequest request =
//                    SearchGoogleAdsStreamRequest.newBuilder()
//                            .setCustomerId(Long.toString(customerId))
//                            .setQuery(query)
//                            .build();
//
//            // Creates and issues a search Google Ads stream request that will retrieve all campaigns.
//            ServerStream<SearchGoogleAdsStreamResponse> stream =
//                    googleAdsServiceClient.searchStreamCallable().call(request);
//
//            // Iterates through and prints all of the results in the stream response.
//            for (SearchGoogleAdsStreamResponse response : stream) {
//                for (GoogleAdsRow googleAdsRow : response.getResultsList()) {
////                    hashMap.put(customerClient,googleAdsRow.getCampaign());
//                    System.out.printf(
//                            "Campaign with ID %d and name '%s' was found.%n",
//                            googleAdsRow.getCampaign().getId(), googleAdsRow.getCampaign().getName());
//                }
//            }
//
//        }


        // Recursively calls this function for all child accounts of customerClient if the current
        // customer is a manager account.
        for (CustomerClient childCustomer : customerIdsToChildAccounts.get(customerId)) {
            printAccountHierarchy(childCustomer, customerIdsToChildAccounts, depth + 1,googleAdsClient);
        }
    }
}
