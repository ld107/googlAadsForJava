package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.google.ads.googleads.examples.AboutProjectForPlay.mysql.MySqlConnt;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.common.Metrics;
import com.google.ads.googleads.v12.resources.Campaign;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamRequest;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamResponse;
import com.google.api.gax.rpc.ServerStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetADsConversion {
    public static void main(String[] args) {
        //连接数据库  查询数据
        Connection connection = null;
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
            connection = MySqlConnt.init();
            // 创建对象用来执行sql查询语句
            Statement statement = connection.createStatement();
            String sql = "select * from google_ads_data.customer where google_ads_data.customer.manager=0";      // sql 语句
            ResultSet rs = statement.executeQuery(sql);   // 执行 sql
            String insertStr= "insert into google_ads_data.campaign_conversion " +
                    "values(?,?,?,?,?,?,?,?,?,?,?);";;
            // 创建对象用来执行sql插入语句
            PreparedStatement psql =
                    connection.prepareStatement(insertStr);    // sql插入语句
            while(rs.next()) {
                String customerId = String.valueOf(rs.getBigDecimal("id"));
                System.out.printf("customerId ==== %s .%n",customerId);
                if(!customerId.equals("")){
                    String query = "SELECT campaign.id, " +
                            "campaign.name, campaign.campaign_budget, " +
                            "campaign.status, campaign.start_date,campaign.campaign_group, " +
                            "metrics.absolute_top_impression_percentage," +
                            " metrics.all_conversions, " +
                            "customer.id, customer.manager, " +
                            "customer.descriptive_name " +
                            "FROM campaign WHERE segments.date = '2022-12-25'";

                    try (GoogleAdsServiceClient googleAdsServiceClient =
                                 googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {
                        // Constructs the SearchGoogleAdsStreamRequest.
                        SearchGoogleAdsStreamRequest request =
                                SearchGoogleAdsStreamRequest.newBuilder()
                                        .setCustomerId(customerId)
                                        .setQuery(query)
                                        .build();

                        // Creates and issues a search Google Ads stream request that will retrieve all campaigns.
                        ServerStream<SearchGoogleAdsStreamResponse> stream =
                                googleAdsServiceClient.searchStreamCallable().call(request);

                        // Iterates through and prints all of the results in the stream response.
                        for (SearchGoogleAdsStreamResponse response : stream) {
                            for (GoogleAdsRow googleAdsRow : response.getResultsList()) {
                                Campaign campaign = googleAdsRow.getCampaign();
                                Customer customer = googleAdsRow.getCustomer();
                                Metrics metrics = googleAdsRow.getMetrics();
                                System.out.printf(
                                        "Campaign with ID %d and name '%s' was found.%n",
                                        campaign.getId(), campaign.getName());
//                                 insertStr= "insert into google_ads_data.campaign_conversion " +
//                                        "values("+0+","+customerId+",'"+customer.getDescriptiveName()+"',"+campaign.getId()
//                                        +",'"+campaign.getName()+"','"+campaign.getCampaignGroup()+"',"+metrics.getAllConversions()
//                                        +","+metrics.getAbsoluteTopImpressionPercentage()+",'"
//                                        +campaign.getStartDate()+"','"+campaign.getCampaignBudget()+"','"+campaign.getStatus() +"');";
                                psql.setInt(1,0);
                                psql.setString(2, customerId);
                                psql.setString(3, customer.getDescriptiveName());
                                psql.setString(4, String.valueOf(campaign.getId()));
                                psql.setString(5,campaign.getName());
                                psql.setString(6,campaign.getCampaignGroup());
                                psql.setDouble(7,metrics.getAllConversions());
                                psql.setDouble(8,metrics.getAbsoluteTopImpressionPercentage());
                                psql.setString(9,campaign.getStartDate());
                                psql.setString(10,campaign.getCampaignBudget());
                                psql.setString(11, String.valueOf(campaign.getStatus()));
                                psql.executeUpdate();
                                // 插入结束
                            }
                        }
                    }
                }
            }
            psql.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
