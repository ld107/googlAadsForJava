package com.google.ads.googleads.examples.AboutProjectForPlay;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.ads.googleads.examples.AboutProjectForPlay.data.ConversionData;
import com.google.ads.googleads.examples.utils.LocalJSONFileUtil;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

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
    public static void main(String... args) throws IOException, GeneralSecurityException, SQLException, ClassNotFoundException, ParseException {
        Connection conn = init();
        Statement stmt = conn.createStatement(); //创建Statement对象
        System.out.println("成功连接到数据库！");

        String textJOSN = LocalJSONFileUtil.getFileText("/date.json");
        JSONArray jsonArray = LocalJSONFileUtil.parseArray(textJOSN);
        System.out.println(textJOSN);

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
        /*暂存数据表*/
        List<List<Object>> cacheValues = new ArrayList<>();
        cacheValues.add(Arrays.asList("事件id","地区","日期","事件uuid","事件出现次数","点击次数","btime",
                "小时","分钟","包版本","包名称","转化后日期","天","转化小时","转化分钟"));

        List<ConversionData> conversionDataList = new ArrayList<>();
        while (rs.next()){
            int anInt = rs.getInt(7);
            String stInt = String.valueOf(anInt);
            String houBJ;
            String minuteBJ;
            if(anInt<100){
                houBJ="00";
                minuteBJ=String.valueOf(anInt);
            }else if(anInt<1000){
             houBJ = "0"+stInt.charAt(0);
             minuteBJ = stInt.substring(1);

            }else{
                houBJ =stInt.substring(0,2);
                minuteBJ = stInt.substring(2);
            }
            String region = rs.getString(11);
            String dateStr = rs.getInt(3)+" "+houBJ+":"+minuteBJ+":00";
            String converDateGMT = dateStr;
            for(int i=0;i<jsonArray.size();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("region");
                int time_difference = jsonObject.getIntValue("time_difference");
                if(region.equals(name)){
                    if(time_difference>=0){
                        converDateGMT = converDateGMT(dateStr, "GMT+8", "GMT+"+time_difference);
                    }else{
                        converDateGMT = converDateGMT(dateStr, "GMT+8", "GMT"+time_difference);
                    }
                     break;
                }
            }
            String day = getDay(converDateGMT);
            String hour = getHour(converDateGMT);
            String minute = getMinute(converDateGMT);
            List<Object> objList = Arrays.asList(rs.getString(1),rs.getString(11),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                    rs.getInt(7),houBJ,minuteBJ,rs.getString(2), rs.getString(8),converDateGMT,day,hour,minute);
            cacheValues.add(objList);
            conversionDataList.add(new ConversionData(rs.getString(11),day,rs.getString(5)));
        }

        rs.close();
        stmt.close();
        conn.close();
        //仪表盘1
        List<List<Object>> values = new ArrayList<>();
        values.add(Arrays.asList("日期","地区","点击次数","消耗","安装次数","安装成本","打开次数","打开成本"));

        Set<String> sex = new HashSet<>(conversionDataList.stream().map(ConversionData::getDate).collect(Collectors.toList()));
        Set<String> grade = new HashSet<>(conversionDataList.stream().map(ConversionData::getRegion).collect(Collectors.toList()));
        //循环分组
        Map<String, List<ConversionData>> map = new HashMap<>();
        for (String string : sex) {
            for (String str : grade) {
                if (string == null || str == null) {
                    continue;
                }
                List<ConversionData> sl = new ArrayList<>();
                for (ConversionData data : conversionDataList) {
                    if (string.equals(data.getDate()) && str.equals(data.getRegion())) {
                        sl.add(data);
                    }
                }
                map.put(string+"/"+ str, sl);
            }
        }
        //查看测试结果
        for (Map.Entry<String, List<ConversionData>> listsList1 : map.entrySet()) {
            System.out.println("key:"+listsList1.getKey());
            int totalnum = 0;
            for (ConversionData st : listsList1.getValue()) {
//                System.out.println(st.getDate() + " name:" + st.getRegion() + "  " + st.getNum());
                totalnum += Integer.parseInt(st.getNum());
            }
            System.out.println("totalnum:"+totalnum);
            System.out.println("--------------------------");
            String[] split = listsList1.getKey().split("/");
            values.add(Arrays.asList(split[0],split[1],String.valueOf(totalnum),"","","","",""));
        }
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1bZDCy8Es-C1PutahR3GoKH3AaJcLYg-Weu0q7f2fw5Q";
        final String rangeCache = "数据暂存";
        final String range = "仪表盘-1";

        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();

        try {
            // Updates the values in the specified range.
            ValueRange bodyCache = new ValueRange().setValues(cacheValues);
            UpdateValuesResponse resultCache = service.spreadsheets().values().update(spreadsheetId, rangeCache, bodyCache)
                    .setValueInputOption("USER_ENTERED")
                    .execute();
            System.out.printf("%d cells updated.", resultCache.getUpdatedCells());

            ValueRange body = new ValueRange().setValues(values);
            UpdateValuesResponse result = service.spreadsheets().values().update(spreadsheetId, range, body)
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



    }

    /**
     * 转换时间时区
     *
     * @param dateStr        需要转的时间字符串
     * @param sourceTimeZone 源时间时区 GMT+8
     * @param targetTimeZone 目标时间时区 GMT+6
     * @return
     * @throws ParseException
     */
    public static String converDateGMT(String dateStr, String sourceTimeZone, String targetTimeZone) throws ParseException {
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        bjSdf.setTimeZone(TimeZone.getTimeZone(sourceTimeZone));
        Date date = bjSdf.parse(dateStr);  // 将字符串时间按北京时间解析成Date对象

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        tokyoSdf.setTimeZone(TimeZone.getTimeZone(targetTimeZone));  // 设置时区
//        System.out.println("北京时间: " + dateStr +"对应的时间为:"  + tokyoSdf.format(date));
        return tokyoSdf.format(date);
    }
    public static String getDay(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateStr);
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }
    public static String getHour(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateStr);
        return new SimpleDateFormat("HH").format(date);
    }
    public static String getMinute(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateStr);
        return new SimpleDateFormat("mm").format(date);
    }

}
// [END sheets_quickstart]

