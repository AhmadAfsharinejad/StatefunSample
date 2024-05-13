package org.example.Common;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeProvider {
    static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static String getCurrentTime(){
        return SIMPLEDATEFORMAT.format(new Date());
    }
}
