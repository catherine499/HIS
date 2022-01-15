package com.example.HIS.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {

    /**
     * 获取未来第i天的j点(整点)
     *
     * @param i,j
     * @return
     */
    public static Date getFutureDate(int i,int j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + i);
        calendar.set(Calendar.HOUR_OF_DAY, j);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date today = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String result = format.format(today);
        return today;
    }

    /**
     * 获取过去第i天的j点(整点)
     *
     * @param i,j
     * @return
     */
    public static Date getPastDate(int i,int j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
        calendar.set(Calendar.HOUR_OF_DAY, j);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date today = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String result = format.format(today);
        return today;
    }


}
