package com.cskaoyan.ds.sx.day043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sx
 * @since 2022/06/08 14:16
 */

public class DBCPUtilsDemo {
    public static void main(String[] args) {
        Connection connection = DBCPUtils.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            insertMethod(statement);
            updateMethod(statement, "update fruit set name = '222' where id = 1001");
            deletMethod(statement, "delete from fruit where id = 1003");
            ResultSet resultSet = statement.executeQuery("select * from fruit");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nickName = resultSet.getString("nickname");
                System.out.println(id+name+nickName);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void deletMethod(Statement statement, String s) throws SQLException {
        int i = statement.executeUpdate(s);
        System.out.println(i);
    }

    private static void updateMethod(Statement statement, String s) throws SQLException {
        deletMethod(statement, s);
    }

    private static void insertMethod(Statement statement) throws SQLException {
        updateMethod(statement, "insert into fruit values (1006,'西瓜2','watermelon2');");
    }
}
