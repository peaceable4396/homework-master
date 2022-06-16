package com.cskaoyan.ds.sx.day042;

import com.cskaoyan.ds.sx.day041.DruidUtils;
import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author sx
 * @since 2022/06/06 19:56
 */

public class DBUtils {
    public static void main(String[] args) throws SQLException {
        //查
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        queryUser(queryRunner);
        queryRunner.update("insert into users values (null,'宋旭',22)");
        queryRunner.update("update users set name = 'aa' where id = 1002");
        queryRunner.update("delete from users where id = 1001");
        System.out.println();

        List<User> list = queryRunner.query("select * from users",new BeanListHandler<>(User.class));
        for (User user1 : list) {
            System.out.println(user1);
        }

        System.out.println();

        List<String> list1 = queryRunner.query("select name from users", new ColumnListHandler<>());
        for (String s : list1) {
            System.out.println(s);
        }

        System.out.println();

        String name = queryRunner.query("select name from users where id = ?",new ScalarHandler<>(),1005);
        System.out.println(name);
    }

    private static void queryUser(QueryRunner queryRunner) throws SQLException {
        User user = queryRunner.query("select * from users where id = ?",new BeanHandler<>(User.class),1005);
        System.out.println(user);
    }
}
