package com.cskaoyan.ds.sx.day041;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sx
 * @since 2022/06/05 21:24
 */

public class Test002 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DBCPUtils.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from fruit");

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String nickname = resultSet.getString("nickname");
            System.out.println(id + name + nickname);
        }

        connection.close();

    }

}
