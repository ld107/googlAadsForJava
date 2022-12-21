package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.beust.jcommander.Parameter;
import com.google.ads.googleads.examples.AboutProjectForPlay.mysql.MySqlConnt;
import com.google.ads.googleads.examples.utils.ArgumentNames;
import com.google.ads.googleads.examples.utils.CodeSampleParams;
import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v12.errors.GoogleAdsError;
import com.google.ads.googleads.v12.errors.GoogleAdsException;
import com.google.ads.googleads.v12.resources.AccountBudget;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.services.GoogleAdsRow;
import com.google.ads.googleads.v12.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamRequest;
import com.google.ads.googleads.v12.services.SearchGoogleAdsStreamResponse;
import com.google.api.gax.rpc.ServerStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetCustomerInfo {

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
    private void runExample(GoogleAdsClient googleAdsClient) {
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
            Long customerId = googleAdsClient.getLoginCustomerId();
            // Executes the query and gets the Customer object from the single row of the response.
            GoogleAdsServiceClient.SearchPagedResponse response =
                    googleAdsServiceClient.search(Long.toString(customerId), query);
            GoogleAdsRow googleAdsRow = response.iterateAll().iterator().next();
            Customer customer = googleAdsRow.getCustomer();
//             Prints account information.
            System.out.printf(
                    "Customer with ID %d, descriptive name '%s', currency code '%s', timezone '%s', "
                            + "tracking URL template '%s' and auto tagging enabled '%s' was retrieved.%n",
                    customer.getId(),
                    customer.getDescriptiveName(),
                    customer.getCurrencyCode(),
                    customer.getTimeZone(),
                    customer.getTrackingUrlTemplate(),
                    customer.getAutoTaggingEnabled());

//            saveDataToFile("jsonName",customer.toString());

//            try {
//                Connection connection = MySqlConnt.init();
//                // 执行查询
//                Statement stmt = null;
//                System.out.println(" create Statement...");
//                stmt = connection.createStatement();
//                String sql;
//                sql = "SELECT * from 01_cmsdata_dev1.admin_role ";
//                ResultSet rs = stmt.executeQuery(sql);
//
//                // 展开结果集数据库
//                while(rs.next()){
//                    // 通过字段检索
//                    int id  = rs.getInt("id");
//                    String name = rs.getString("name");
//
//                    // 输出数据
//                    System.out.print("ID: " + id);
//                    System.out.print(", 站点名称: " + name);
//                    System.out.print("\n");
//                }
//                // 完成后关闭
//                rs.close();
//                stmt.close();
//                connection.close();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                // 处理 JDBC 错误
//                e.printStackTrace();
//            }
//

        }
    }


    private void saveDataToFile(String fileName,String data) {
        BufferedWriter writer = null;
        File file = new File("c://"+ fileName + ".text");
                //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }
}