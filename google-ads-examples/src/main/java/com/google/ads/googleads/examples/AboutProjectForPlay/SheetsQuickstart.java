package com.google.ads.googleads.examples.AboutProjectForPlay;

// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// [START sheets_quickstart]

import com.google.ads.googleads.examples.AboutProjectForPlay.data.ClickObject;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SheetsQuickstart {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/client_secret.json";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://db-01-cmsdata-dev1.czw7olp7vldl.ap-southeast-1.rds.amazonaws.com:3306?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码
    static final String USER = "read";
    static final String PASS = "ed384f58875d01e242293142eed75a7a";

    static Connection conn = null;
    public static  Connection init() throws ClassNotFoundException, SQLException {
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 打开链接
        System.out.println("connection DB...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        return  conn;
    }

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException, SQLException, ClassNotFoundException {
        Connection conn = init();
        Statement stmt = conn.createStatement(); //创建Statement对象
        System.out.println("成功连接到数据库！");

        String sql="SELECT " +
                "01_cmsdata_dev1.click.id," +
                "01_cmsdata_dev1.click.app_id," +
                "01_cmsdata_dev1.click.datetime, " +
                "01_cmsdata_dev1.click.uuid," +
                "count(DISTINCT(01_cmsdata_dev1.click.uuid))as count_uuid," +
                "count(01_cmsdata_dev1.click.num)as click_num," +
                "01_cmsdata_dev1.click.btime," +
                "01_cmsdata_dev1.app.`name`as app_name," +
                "01_cmsdata_dev1.app.region," +
                "01_cmsdata_dev1.app.region_id," +
                "01_cmsdata_dev1.tag.`name`as tag_name  " +
                "from 01_cmsdata_dev1.click,01_cmsdata_dev1.app,01_cmsdata_dev1.tag " +
                "WHERE `datetime` >= date_sub(curdate(), interval 7 day) " +
                "AND 01_cmsdata_dev1.click.app_id=01_cmsdata_dev1.app.id " +
                "AND 01_cmsdata_dev1.app.region_id=01_cmsdata_dev1.tag.id  " +
                "GROUP BY 01_cmsdata_dev1.click.app_id,01_cmsdata_dev1.click.datetime,01_cmsdata_dev1.click.btime  " +
                "ORDER BY btime desc";
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
//
        System.out.println("id"+"\t"+"包版本"+"\t"+"datetime"+"\t"+"uuid"+"\t"+"count_uuid"+"\t"+"click_num"+"\t"+"btime"+"\t"+"包名称"+"\t"+"region"+"\t"+"region_id"+"\t"+"tag_name");
        List<ClickObject> clickList = new ArrayList<>();
        List<List<Object>> values = new ArrayList<>();
        values.add(Arrays.asList("事件id","地区","日期","事件uuid","事件出现次数","点击次数","btime","包版本","包名称"));
        while (rs.next()){
            System.out.print(rs.getString(1) + "\t");
            System.out.print(rs.getString(2) + "\t");
            System.out.print(rs.getInt(3) + "\t");
            System.out.print(rs.getString(4) + "\t");
            System.out.print(rs.getString(5) + "\t");
            System.out.print(rs.getInt(6) + "\t");
            System.out.print(rs.getInt(7) + "\t");
            System.out.print(rs.getString(8) + "\t");
            System.out.print(rs.getString(9) + "\t");
            System.out.print(rs.getString(10) + "\t");
            System.out.print(rs.getString(11) + "\t");
            System.out.println();
            clickList.add(new ClickObject(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),
                    rs.getInt(6) ,rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11) ));
            List<Object> serializables = Arrays.asList(rs.getString(1),rs.getString(11),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                    rs.getInt(7),rs.getString(2), rs.getString(8));
            values.add(serializables);
        }


        sql = "SELECT * from 01_cmsdata_dev1.tag ";

        rs.close();
        stmt.close();
        conn.close();
//        SELECT id,app_id,datetime,count(DISTINCT(uuid))as count_uuid,btime from click WHERE `datetime` >= date_sub(curdate(), interval 7 day)  GROUP BY app_id,datetime,btime ORDER BY btime desc

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1bZDCy8Es-C1PutahR3GoKH3AaJcLYg-Weu0q7f2fw5Q";
        final String range = "数据暂存";

        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();

        UpdateValuesResponse result = null;
        try {
            // Updates the values in the specified range.
            ValueRange body = new ValueRange()
                    .setValues(values);
            result = service.spreadsheets().values().update(spreadsheetId, range, body)
                    .setValueInputOption("USER_ENTERED")
                    .execute();
            System.out.printf("%d cells updated.", result.getUpdatedCells());
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 404) {
                System.out.printf("Spreadsheet not found with id '%s'.\n", spreadsheetId);
            } else {
                throw e;
            }
        }

//        ValueRange response = service.spreadsheets().values()
//                .get(spreadsheetId, range)
//                .execute();
//        List<List<Object>> values = response.getValues();
//
//
//        if (values == null || values.isEmpty()) {
//            System.out.println("No data found.");
//        } else {
//            System.out.println("Name, Major");
//
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s\n", row.get(0), row.get(1));
//            }
//        }


    }
}
// [END sheets_quickstart]

