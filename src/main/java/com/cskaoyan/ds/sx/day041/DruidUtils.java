package com.cskaoyan.ds.sx.day041;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author sx
 * @since 2022/06/05 21:43
 */

public class DruidUtils {
    static DataSource dataSource;
    static {
        Properties properties = new Properties();
        try {

            ClassLoader classLoader = DruidUtils.class.getClassLoader();
            InputStream stream = classLoader.getResourceAsStream("druid.properties");
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
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

    public static DataSource getDataSource() {
        return dataSource;
    }
}
