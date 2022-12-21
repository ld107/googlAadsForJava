package com.google.ads.googleads.examples.AboutProjectForPlay.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnt {
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
}
