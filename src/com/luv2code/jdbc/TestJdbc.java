package com.luv2code.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/hb_student_tracker";
        String user = "root";
        String password = "password";

        try {
            System.out.println("Connecting to Database " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection successfull!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
