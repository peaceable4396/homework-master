package com.cskaoyan.ds.sx.day039;

import com.cskaoyan.ds.sx.day040.JDBCUtils;


import java.sql.*;

/**
 * @author sx
 * @since 2022/06/01 14:38
 */

public class SelectStuName {


    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT t.`name` AS teachername,GROUP_CONCAT(s.`name`) AS studentname\n" +
                "FROM teacher AS t INNER JOIN student AS s ON t.id = s.tea_id\n" +
                "GROUP BY s.tea_id;");

        while (resultSet1.next()){
            String teachername = resultSet1.getString("teachername");
            String studentname = resultSet1.getString("studentname");
            System.out.println("teachername:" + teachername + ",studentname:" + studentname);
        }

        System.out.println();

        ResultSet resultSet2 = statement.executeQuery("SELECT t.`name` AS teachername,GROUP_CONCAT(s.`name`) AS studentname\n" +
                "FROM teacher AS t INNER JOIN student AS s ON t.id = s.tea_id\n" +
                "WHERE t.`name` = \"dd\"\n" +
                "GROUP BY s.tea_id;");

        while (resultSet2.next()){
            String teachername = resultSet2.getString("teachername");
            String studentname = resultSet2.getString("studentname");
            System.out.println("teachername:" + teachername + ",studentname:" + studentname);
        }


        System.out.println();

        ResultSet resultSet3 = statement.executeQuery("SELECT t.`name` AS teachername,COUNT(s.`name`) as 学生数量\n" +
                "FROM teacher AS t INNER JOIN student AS s ON t.id = s.tea_id\n" +
                "GROUP BY s.tea_id;");

        while (resultSet3.next()){
            String teachername = resultSet3.getString("teachername");
            String studentnum = resultSet3.getString("学生数量");
            System.out.println("teachername:" + teachername + ",学生数量:" + studentnum);
        }

        System.out.println();

        ResultSet resultSet4 = statement.executeQuery("SELECT t.`name` AS teachername,COUNT(s.`name`) as 男学生数量\n" +
                "FROM teacher AS t INNER JOIN student AS s ON t.id = s.tea_id\n" +
                "WHERE s.gender = \"male\"\n" +
                "GROUP BY s.tea_id;");

        while (resultSet4.next()){
            String teachername = resultSet4.getString("teachername");
            String studentnum = resultSet4.getString("男学生数量");
            System.out.println("teachername:" + teachername + ",男学生数量:" + studentnum);
        }

        System.out.println();

        ResultSet resultSet5 = statement.executeQuery("SELECT research AS 最多的研究方向\n" +
                "FROM teacher\n" +
                "GROUP BY research\n" +
                "ORDER BY COUNT(id) DESC\n" +
                "LIMIT 1;\n");

        while (resultSet5.next()){
            String teachername = resultSet5.getString("最多的研究方向");
            System.out.println("最多的研究方向:" + teachername);
        }

        System.out.println();

        ResultSet resultSet6 = statement.executeQuery("SELECT title,COUNT(id) AS 导师数\n" +
                "FROM teacher\n" +
                "GROUP BY title ;");
        while (resultSet6.next()){
            String title = resultSet6.getString("title");
            String teachernum = resultSet6.getString("导师数");
            System.out.println("title:" + title + ",导师数:" + teachernum);
        }


        JDBCUtils.closeAll(resultSet1,resultSet2,resultSet3,resultSet4,resultSet5,resultSet6,statement,connection);

        // resultSet1.close();
        // resultSet2.close();
        // resultSet3.close();
        // resultSet4.close();
        // resultSet5.close();
        // resultSet6.close();
        // statement.close();
        // connection.close();
    }
}
