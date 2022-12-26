package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.MyExcelUtilTest;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.errors.GoogleAdsError;
import com.google.ads.googleads.v12.errors.GoogleAdsException;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.services.CustomerServiceClient;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersRequest;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GetCustomerInfo {
    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private static Long customerId;

    public static void main(String[] args) {

        GoogleAdsClient googleAdsClient = null;
        try {
            googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
            customerId = googleAdsClient.getLoginCustomerId();
        } catch (FileNotFoundException fnfe) {
            System.err.printf(
                    "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
            System.exit(1);
        } catch (IOException ioe) {
            System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
            System.exit(1);
        }

        try {
            new GetCustomerInfo().runExample(googleAdsClient);
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
        }
    }

    /**
     * Runs the example.
     *
     * @param googleAdsClient the Google Ads API client.
     * @throws GoogleAdsException if an API request failed with one or more service errors.
     */
    void runExample(GoogleAdsClient googleAdsClient) {

        try (CustomerServiceClient customerService =
                     googleAdsClient.getLatestVersion().createCustomerServiceClient()) {
            //获取可访问的账号
            ListAccessibleCustomersResponse response =
                    customerService.listAccessibleCustomers(
                            ListAccessibleCustomersRequest.newBuilder().build());
            int rowNum= response.getResourceNamesCount();
            System.out.printf("Total results: %d%n", rowNum);

            try (GoogleAdsServiceClient googleAdsServiceClient =
                         googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
                // Constructs a query to retrieve the customer.
                String query =
                        "SELECT customer.id, "
                                + "customer.descriptive_name, "
                                + "customer.currency_code, "
                                + "customer.time_zone, "
                                + "customer.tracking_url_template, "
                                + "customer.auto_tagging_enabled "
                                + "FROM customer ";
                ArrayList<Customer> customerList = new ArrayList<Customer>();
                //遍历查询可访问账号的信息
                for (String customerResourceName : response.getResourceNamesList()) {
                    System.out.printf("Customer resource name: %s%n", customerResourceName);
                    long customerId = Long.parseLong(customerResourceName.split("/")[1]);
                    // Executes the query and gets the Customer object from the single row of the response.
                    GoogleAdsServiceClient.SearchPagedResponse responseSearch =
                            googleAdsServiceClient.search(Long.toString(customerId), query);
                    GoogleAdsRow googleAdsRow = responseSearch.iterateAll().iterator().next();
                    Customer customer = googleAdsRow.getCustomer();
//             Prints account information
                    System.out.printf(
                            "Customer with ID %d, descriptive name '%s', currency code '%s', timezone '%s', "
                                    + "tracking URL template '%s' and auto tagging enabled '%s' was retrieved.%n",
                            customer.getId(),
                            customer.getDescriptiveName(),
                            customer.getCurrencyCode(),
                            customer.getTimeZone(),
                            customer.getTrackingUrlTemplate(),
                            customer.getAutoTaggingEnabled());
                    customerList.add(customer);

                }
                //保存execl表格
                new MyExcelUtilTest().createNewExcelWriteContentTest(customerList,rowNum);

            }

        }

    }

}