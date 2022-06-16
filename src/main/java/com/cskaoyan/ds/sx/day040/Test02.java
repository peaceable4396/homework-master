package com.cskaoyan.ds.sx.day040;

import java.sql.*;

/**
 * @author sx
 * @since 2022/06/02 20:42
 */

public class Test02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into userinfo values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1,"pre" + i);
            preparedStatement.setString(2,"aaa");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        Statement statement = connection.createStatement();
        long t1_start = System.currentTimeMillis();
        String s1 = "select * from  userinfo where id = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(s1);
        preparedStatement1.setString(1,"5000");
        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String nickname = resultSet.getString("nickname");
            System.out.println(id+name+nickname);
        }
        long t1_end = System.currentTimeMillis();
        System.out.println(t1_end - t1_start);


        long t2_start = System.currentTimeMillis();
        String s2 = "select * from  userinfo where `name` = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(s2);
        preparedStatement2.setString(1,"pre5000");
        ResultSet resultSet1 = preparedStatement2.executeQuery();
        while (resultSet1.next()){
            String id = resultSet1.getString("id");
            String name = resultSet1.getString("name");
            String nickname = resultSet1.getString("nickname");
            System.out.println(id+name+nickname);
        }
        long t2_end = System.currentTimeMillis();
        System.out.println(t2_end - t2_start);

    }
}
