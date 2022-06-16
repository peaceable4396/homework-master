package com.cskaoyan.ds.sx.day041;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sx
 * @since 2022/06/05 21:32
 */

public class C3p0Utils {
    static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource("mymysql");
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection  = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
