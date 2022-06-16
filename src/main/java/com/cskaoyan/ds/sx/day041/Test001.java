package com.cskaoyan.ds.sx.day041;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sx
 * @since 2022/06/05 20:14
 */

public class Test001 {
    public static void main(String[] args) throws SQLException {

        MyDataSourse myDataSourse = new MyDataSourse();

        MyConnectionImpl connection = myDataSourse.getConnection();

        testClose(connection);

        connection.close();

        testClose(connection);
    }

    private static void testClose(MyConnectionImpl connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from fruit");

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String nickname = resultSet.getString("nickname");
            System.out.println(id + name + nickname);
        }
    }
}
