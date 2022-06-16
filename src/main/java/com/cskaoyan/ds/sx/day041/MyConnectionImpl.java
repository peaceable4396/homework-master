package com.cskaoyan.ds.sx.day041;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;


/**
 * @author sx
 * @since 2022/06/05 20:06
 */

public class MyConnectionImpl extends ConnectionImpl {

    private Connection connection;
    public MyConnectionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void close() throws SQLException {
        MyDataSourse.returnConnection(this);
    }

}
