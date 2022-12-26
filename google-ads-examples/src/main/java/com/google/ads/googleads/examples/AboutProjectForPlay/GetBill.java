package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.google.ads.googleads.examples.AboutProjectForPlay.mysql.MySqlConnt;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.enums.MonthOfYearEnum;
import com.google.ads.googleads.v12.errors.GoogleAdsError;
import com.google.ads.googleads.v12.errors.GoogleAdsException;
import com.google.ads.googleads.v12.resources.AccountBudget;
import com.google.ads.googleads.v12.resources.BillingSetup;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.resources.Invoice;
import com.google.ads.googleads.v12.services.CustomerServiceClient;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v12.services.InvoiceServiceClient;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersRequest;
import com.google.ads.googleads.v12.services.ListAccessibleCustomersResponse;
import com.google.ads.googleads.v12.services.ListInvoicesResponse;
import com.google.ads.googleads.v12.utils.ResourceNames;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class GetBill {

    public Connection connection;
    private static final int PAGE_SIZE = 1_000;
    public static void main(String[] args) {

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
            new GetBill().runExample(googleAdsClient);
        } catch (GoogleAdsException gae) {
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

        String searchQuery =
                "SELECT billing_setup.id, "
                        + "  billing_setup.status, "
                        + "  billing_setup.payments_account, "
                        + "  billing_setup.payments_account_info.payments_account_id, "
                        + "  billing_setup.payments_account_info.payments_account_name, "
                        + "  billing_setup.payments_account_info.payments_profile_id, "
                        + "  billing_setup.payments_account_info.payments_profile_name, "
                        + "  billing_setup.payments_account_info.secondary_payments_profile_id "
                        + "FROM billing_setup";
//        SearchGoogleAdsRequest request =
//                SearchGoogleAdsRequest.newBuilder()
//                        .setCustomerId(String.valueOf(customerId))
//                        .setPageSize(PAGE_SIZE)
//                        .setQuery(searchQuery)
//                        .build();
        try (GoogleAdsServiceClient googleAdsServiceClient =
                     googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
            GoogleAdsServiceClient.SearchPagedResponse searchPagedResponse;
            // Constructs a query to retrieve the customer.
            //连接数据库  查询数据
            Connection connection = MySqlConnt.init();
            // 创建对象用来执行sql查询语句
            Statement statement = connection.createStatement();
            String sql = "select * from google_ads_data.customer";      // sql 语句
            ResultSet rs = statement.executeQuery(sql);   // 执行 sql
            while(rs.next()){
                String customerId = rs.getString("id");    // 获取字段id的值
                searchPagedResponse = googleAdsServiceClient.search(customerId, searchQuery);
                for (GoogleAdsRow googleAdsRow : searchPagedResponse.iterateAll()) {
                    BillingSetup billingSetup = googleAdsRow.getBillingSetup();
                    System.out.printf(
                            "Billing setup with ID '%d', "
                                    + "status '%s', "
                                    + "payments_account '%s', "
                                    + "payments_account_id '%s', "
                                    + "payments_account_name '%s', "
                                    + "payments_profile_id '%s', "
                                    + "payments_profile_name '%s', "
                                    + "secondary_payments_profile_id '%s'.%n",
                            billingSetup.getId(),
                            billingSetup.getStatus(),
                            billingSetup.getPaymentsAccount(),
                            billingSetup.getPaymentsAccountInfo().getPaymentsAccountId(),
                            billingSetup.getPaymentsAccountInfo().getPaymentsAccountName(),
                            billingSetup.getPaymentsAccountInfo().getPaymentsProfileId(),
                            billingSetup.getPaymentsAccountInfo().getPaymentsProfileName(),
                            billingSetup.getPaymentsAccountInfo().getSecondaryPaymentsProfileId());

                    try (InvoiceServiceClient invoiceServiceClient =
                                 googleAdsClient.getLatestVersion().createInvoiceServiceClient()) {

                        ZonedDateTime oneMonthAgo = ZonedDateTime.now().minusMonths(1);

                        // Issues the request.
                        ListInvoicesResponse response =
                                invoiceServiceClient.listInvoices(
                                        String.valueOf(customerId),
                                        ResourceNames.billingSetup(Long.parseLong(customerId), billingSetup.getId()),
                                        String.valueOf(oneMonthAgo.getYear()),
                                        MonthOfYearEnum.MonthOfYear.valueOf(oneMonthAgo.getMonth().toString()));

                        // Iterates over all invoices retrieved and prints their information.
                        for (Invoice invoice : response.getInvoicesList()) {
                            System.out.printf(
                                    "- Found the invoice '%s':\n"
                                            + "  ID (also known as Invoice Number): '%s'\n"
                                            + "  Type: %s\n"
                                            + "  Billing setup ID: '%s'\n"
                                            + "  Payments account ID (also known as Billing Account Number): '%s'\n"
                                            + "  Payments profile ID (also known as Billing ID): '%s'\n"
                                            + "  Issue date (also known as Invoice Date): %s\n"
                                            + "  Due date: %s\n"
                                            + "  Currency code: %s\n"
                                            + "  Service date range (inclusive): from %s to %s\n"
                                            + "  Adjustments: subtotal '%.2f', tax '%.2f', total '%.2f'\n"
                                            + "  Regulatory costs: subtotal '%.2f', tax '%.2f', total '%.2f'\n"
                                            + "  Replaced invoices: '%s'\n"
                                            + "  Amounts: subtotal '%.2f', tax '%.2f', total '%.2f'\n"
                                            + "  Corrected invoice: '%s'\n"
                                            + "  PDF URL: '%s'\n"
                                            + "  Account budgets: ",
                                    invoice.getResourceName(),
                                    invoice.getId(),
                                    invoice.getType(),
                                    invoice.getBillingSetup(),
                                    invoice.getPaymentsAccountId(),
                                    invoice.getPaymentsProfileId(),
                                    invoice.getIssueDate(),
                                    invoice.getDueDate(),
                                    invoice.getCurrencyCode(),
                                    invoice.getServiceDateRange().getStartDate(),
                                    invoice.getServiceDateRange().getEndDate(),
                                    convertMicrosToCurrency(invoice.getAdjustmentsSubtotalAmountMicros()),
                                    convertMicrosToCurrency(invoice.getAdjustmentsTaxAmountMicros()),
                                    convertMicrosToCurrency(invoice.getAdjustmentsTotalAmountMicros()),
                                    convertMicrosToCurrency(invoice.getRegulatoryCostsSubtotalAmountMicros()),
                                    convertMicrosToCurrency(invoice.getRegulatoryCostsTaxAmountMicros()),
                                    convertMicrosToCurrency(invoice.getRegulatoryCostsTotalAmountMicros()),
                                    invoice.getReplacedInvoicesList(),
                                    convertMicrosToCurrency(invoice.getSubtotalAmountMicros()),
                                    convertMicrosToCurrency(invoice.getTaxAmountMicros()),
                                    convertMicrosToCurrency(invoice.getTotalAmountMicros()),
                                    invoice.getCorrectedInvoice(),
                                    invoice.getPdfUrl());
                            for (Invoice.AccountBudgetSummary accountBudgetSummary : invoice.getAccountBudgetSummariesList()) {
                                System.out.printf(
                                        "  - Account budget '%s':\n"
                                                + "      Name (also known as Account Budget): '%s'\n"
                                                + "      Customer (also known as Account ID): '%s'\n"
                                                + "      Customer descriptive name (also known as Account): '%s'\n"
                                                + "      Purchase order number (also known as Purchase Order): '%s'\n"
                                                + "      Billing activity date range (inclusive): from %s to %s\n"
                                                + "      Amounts: subtotal '%.2f', tax '%.2f', total '%.2f'\n",
                                        accountBudgetSummary.getAccountBudget(),
                                        accountBudgetSummary.getAccountBudgetName(),
                                        accountBudgetSummary.getCustomer(),
                                        accountBudgetSummary.getCustomerDescriptiveName(),
                                        accountBudgetSummary.getPurchaseOrderNumber(),
                                        accountBudgetSummary.getBillableActivityDateRange().getStartDate(),
                                        accountBudgetSummary.getBillableActivityDateRange().getEndDate(),
                                        convertMicrosToCurrency(accountBudgetSummary.getSubtotalAmountMicros()),
                                        convertMicrosToCurrency(accountBudgetSummary.getTaxAmountMicros()),
                                        convertMicrosToCurrency(accountBudgetSummary.getTotalAmountMicros()));
                            }
                        }
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static double convertMicrosToCurrency(long amountMicros) {
        return amountMicros / 1_000_000.0;
    }
}
