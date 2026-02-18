package com.hms.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hospital_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "ayush@2105";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ DB Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
