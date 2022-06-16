package com.cskaoyan.ds.sx.day041;

import java.util.TimerTask;

/**
 * @author sx
 * @since 2022/06/05 20:54
 */

public class MyTask extends TimerTask {
    @Override
    public void run() {
        MyDataSourse.removeConnection();
    }
}
