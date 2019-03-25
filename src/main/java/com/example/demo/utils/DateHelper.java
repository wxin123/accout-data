package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangxin on 2019/3/22.
 */
public class DateHelper {

    public static Date parse(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
        //必须捕获异常
        try {
            Date date = format.parse(str);
            return date;
        } catch (ParseException px) {
            px.printStackTrace();
        }
        return null;
    }
}
