package com.cskaoyan.ds.sx.day041;


import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.logging.Logger;

/**
 * @author sx
 * @since 2022/06/05 19:39
 */

public class MyDataSourse implements DataSource {

    static LinkedList<MyConnectionImpl> linkedList;
    static Timer timer = new Timer();
    static int INIT_SIZE = 10;
    static int MIN_SIZE = 3;
    static int MAX_SIZE = 50;
    static int INCREMENT = 5;

    static {
        linkedList = new LinkedList<MyConnectionImpl>();
        addCapacity(INIT_SIZE);
        timer.schedule(new MyTask(),0,30000);
    }

    public static void addCapacity(int capacity){
        if (capacity <= 0)
            return;
        for (int i = 0; i < capacity; i++) {
            MyConnectionImpl myConnection = new MyConnectionImpl(JDBCUtils.getConnection());
            linkedList.addFirst(myConnection);
        }
    }

    public MyConnectionImpl getConnection(){
        timer.cancel();
        if (linkedList.size() <= MIN_SIZE){
            addCapacity(INCREMENT);
        }
        timer = new Timer();
        timer.schedule(new MyTask(),0,30000);
        return linkedList.removeLast();
    }

    public static void returnConnection(MyConnectionImpl connection){
        linkedList.addFirst(connection);
        if (linkedList.size() >= MAX_SIZE){
            linkedList.removeLast();
        }
    }

    public static void removeConnection(){
        if (linkedList.size() >= INIT_SIZE){
            linkedList.removeLast();
        }
    }


    public MyDataSourse() {
    }

    @Override
    public MyConnectionImpl getConnection(String username, String password) throws SQLException {
        return null;
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

}

