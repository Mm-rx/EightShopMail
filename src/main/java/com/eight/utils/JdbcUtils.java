package com.eight.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    public static Connection getMysqlConnection(){
        String username = "meng"; //MySQL的用户名和密码是自己的
        String password = "617521";//MySQL的用户名和密码是自己的
        Connection conn = null;
        //这里的keke写我们的eightshoppingmail
        String url = "jdbc:mysql://localhost:3306/eightshoppingmail?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static Connection getMysqlConnection(String dabaName){
        String username = "meng";
        String password = "617521";
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/" + dabaName + "?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getOracleConnection(){
        String userName = "meng";
        String passWord = "617521";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@112.74.169.231:1521:orcl",userName,passWord);
            if(null == conn){
                System.out.println("数据库连接失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void commitAndClose() {
    }

    public static void rollbackAndClose() {
    }
}
