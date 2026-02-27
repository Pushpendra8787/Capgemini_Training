package com.capgi.repository;
import java.util.*;
import java.sql.*;
public class playerRepo {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test",
            "root",
                 "Gopalji@2844"   );
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
