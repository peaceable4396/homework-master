package com.cskaoyan.ds.sx.day041;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author sx
 * @since 2022/06/05 21:20
 */

public class DBCPUtils {

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {

            ClassLoader classLoader = DBCPUtils.class.getClassLoader();
            InputStream stream = classLoader.getResourceAsStream("dbcp.properties");
            properties.load(stream);

            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
