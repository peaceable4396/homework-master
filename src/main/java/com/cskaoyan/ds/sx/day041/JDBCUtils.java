package com.cskaoyan.ds.sx.day041;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author sx
 * @since 2022/06/02 11:05
 */

public class JDBCUtils {

    static String url;
    static String username;
    static String password;
    static String driver;

    static {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            InputStream stream = classLoader.getResourceAsStream("jdbc.properties");
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
    public static void closeAll(AutoCloseable...autoCloseables){
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable != null){
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void closeThree(Statement statement, Connection connection, ResultSet resultSet) {
        try {
            if (resultSet != null)resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
