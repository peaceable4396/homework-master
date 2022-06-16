package com.cskaoyan.ds.sx.day040;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sx
 * @since 2022/06/02 19:00
 */

public class Test01 {
    static Connection connection = JDBCUtils.getConnection();
    static int count = 10000;

    public static void main(String[] args) throws SQLException {
        long t1_start = System.currentTimeMillis();
        insertForEach(count);
        long t1_end = System.currentTimeMillis();

        long t2_start = System.currentTimeMillis();
        insertStatement(count);
        long t2_end = System.currentTimeMillis();

        long t3_start = System.currentTimeMillis();
        insertPreparedStatement(count);
        long t3_end = System.currentTimeMillis();

        System.out.println(t1_end - t1_start);
        System.out.println(t2_end - t2_start);
        System.out.println(t3_end - t3_start);
    }

    private static void insertPreparedStatement(int count) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo values (null,?,?)");
        for (int i = 0; i < count; i++) {
            preparedStatement.setString(1,"prepare"+i);
            preparedStatement.setString(2,"222");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
    }

    private static void insertStatement(int count) throws SQLException {
        Statement statement = connection.createStatement();
        for (int i = 0; i < count; i++) {
            String username = "statement" + i;
            String sql = "insert into userinfo values (null,'" + username + "','222')";
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
    }

    private static void insertForEach(int count) throws SQLException {
        for (int i = 0; i < count; i++) {
            Statement statement = connection.createStatement();
            String username = "foreach" + i;
            statement.executeUpdate("insert into userinfo values (null,'" + username + "','111')");
            statement.close();
        }
    }
}
