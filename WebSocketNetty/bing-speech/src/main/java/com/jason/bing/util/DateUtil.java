package com.jason.bing.util;

/**
 * @param
 * @Author: zhuangjiesen
 * @Description: 把秒转成 xx:xx:xx格式
 * @Date: Created in 2018/5/14
 */
public class DateUtil {


    // a integer to xx:xx:xx
    public static String secToTime(long time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00:00";
        else {
            minute = (int) (time / 60);
            if (minute < 60) {
                second = (int) (time % 60);
                timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = (int) (time - hour * 3600 - minute * 60);
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
