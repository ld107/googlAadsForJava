package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.AboutProjectForPlay.mysql.MySqlConnt;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.errors.GoogleAdsError;
import com.google.ads.googleads.v12.errors.GoogleAdsException;
import com.google.ads.googleads.v12.resources.AccountBudget;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAccountBudgetsAndCustomer {

    @Parameter(names = ArgumentNames.CUSTOMER_ID, required = true)
    private static Long customerId;

    public static void main(String[] args) {

        GoogleAdsClient googleAdsClient = null;
        try {
            googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
//            customerId = googleAdsClient.getLoginCustomerId();
        } catch (FileNotFoundException fnfe) {
            System.err.printf(
                    "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
            System.exit(1);
        } catch (IOException ioe) {
            System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
            System.exit(1);
        }

        try {
            new GetAccountBudgetsAndCustomer().runExample(googleAdsClient);
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

        String query =
                "SELECT "
                        + "account_budget.status, "
                        + "account_budget.billing_setup, "
                        + "account_budget.approved_spending_limit_micros, "
                        + "account_budget.approved_spending_limit_type, "
                        + "account_budget.proposed_spending_limit_micros, "
                        + "account_budget.proposed_spending_limit_type, "
                        + "account_budget.approved_start_date_time, "
                        + "account_budget.proposed_start_date_time, "
                        + "account_budget.approved_end_date_time, "
                        + "account_budget.approved_end_time_type,"
                        + "account_budget.proposed_end_date_time, "
                        + "account_budget.proposed_end_time_type "
                        + "FROM account_budget";
        query =
                "SELECT " +
                        "  account_budget.adjusted_spending_limit_micros, " +
                        "  account_budget.adjusted_spending_limit_type, " +
                        "  account_budget.approved_end_time_type, " +
                        "  account_budget.approved_end_date_time, " +
                        "  account_budget.amount_served_micros, " +
                        "  account_budget.approved_spending_limit_micros, " +
                        "  account_budget.approved_spending_limit_type, " +
                        "  account_budget.approved_start_date_time, " +
                        "  account_budget.billing_setup, " +
                        "  account_budget.id, " +
                        "  account_budget.name, " +
                        "  account_budget.notes, " +
                        "  account_budget.pending_proposal.account_budget_proposal, " +
                        "  account_budget.pending_proposal.creation_date_time, " +
                        "  account_budget.pending_proposal.end_date_time, " +
                        "  account_budget.pending_proposal.end_time_type, " +
                        "  account_budget.pending_proposal.name, " +
                        "  account_budget.pending_proposal.notes, " +
                        "  account_budget.pending_proposal.proposal_type, " +
                        "  account_budget.pending_proposal.purchase_order_number, " +
                        "  account_budget.pending_proposal.spending_limit_micros, " +
                        "  account_budget.pending_proposal.spending_limit_type, " +
                        "  account_budget.pending_proposal.start_date_time, " +
                        "  account_budget.proposed_end_date_time, " +
                        "  account_budget.proposed_end_time_type, " +
                        "  account_budget.proposed_spending_limit_micros, " +
                        "  account_budget.proposed_spending_limit_type, " +
                        "  account_budget.proposed_start_date_time, " +
                        "  account_budget.purchase_order_number, " +
                        "  account_budget.resource_name, " +
                        "  account_budget.status, " +
                        "  account_budget.total_adjustments_micros" +
                        "  FROM account_budget";
        try (GoogleAdsServiceClient googleAdsServiceClient =
                     googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
            GoogleAdsServiceClient.SearchPagedResponse searchPagedResponse;

            Connection connection = MySqlConnt.init();
            // 创建对象用来执行sql查询语句
            Statement statement = connection.createStatement();
            String sql = "select * from google_ads_data.customer";      // sql 语句
            ResultSet rs = statement.executeQuery(sql);   // 执行 sql
            while(rs.next()){
                String customerId = rs.getString("id");    // 获取字段id的值
                searchPagedResponse = googleAdsServiceClient.search(customerId, query);
                // Iterates over all rows in all pages and prints the requested field values for the account
                // budget in each row.
                for (GoogleAdsRow googleAdsRow : searchPagedResponse.iterateAll()) {
                    AccountBudget accountBudget = googleAdsRow.getAccountBudget();

                    System.out.printf(
                            "Account budget '%s' with "
                                    + "status '%s' "
                                    + "billing setup '%s' "
                                    + "amount served %.2f "
                                    + "total adjustments %.2f "
                                    + "approved spending limit '%s' "
                                    + "(proposed '%s') "
                                    + "approved start time '%s' "
                                    + "(proposed '%s') "
                                    + "approved end time '%s' "
                                    + "(proposed '%s')"
                                    + ".%n",
                            accountBudget.getResourceName(),
                            accountBudget.getStatus(),
                            accountBudget.getBillingSetup(),
                            accountBudget.getAmountServedMicros() / 1_000_000.0,
                            accountBudget.getTotalAdjustmentsMicros() / 1_000_000.0,
                            accountBudget.getApprovedSpendingLimitCase()
                                    == AccountBudget.ApprovedSpendingLimitCase.APPROVED_SPENDING_LIMIT_MICROS
                                    ? String.format(
                                    "%.2f", accountBudget.getApprovedSpendingLimitMicros() / 1_000_000.0)
                                    : accountBudget.getApprovedSpendingLimitType().name(),
                            accountBudget.getProposedSpendingLimitCase()
                                    == AccountBudget.ProposedSpendingLimitCase.PROPOSED_SPENDING_LIMIT_MICROS
                                    ? String.format(
                                    "%.2f", accountBudget.getProposedSpendingLimitMicros() / 1_000_000.0)
                                    : accountBudget.getProposedSpendingLimitType().name(),
                            accountBudget.getApprovedStartDateTime(),
                            accountBudget.getProposedStartDateTime(),
                            accountBudget.getApprovedEndTimeCase() == AccountBudget.ApprovedEndTimeCase.APPROVED_END_DATE_TIME
                                    ? accountBudget.getApprovedEndDateTime()
                                    : accountBudget.getApprovedEndTimeType(),
                            accountBudget.getProposedEndTimeCase() == AccountBudget.ProposedEndTimeCase.PROPOSED_END_DATE_TIME
                                    ? accountBudget.getProposedEndDateTime()
                                    : accountBudget.getProposedEndTimeType());
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
