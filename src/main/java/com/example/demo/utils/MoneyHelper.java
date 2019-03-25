package com.example.demo.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangxin on 2019/3/22.
 */
public class MoneyHelper {

    public static Long y2f(Double price) {
        DecimalFormat df = new DecimalFormat("#.00");
        price = Double.valueOf(df.format(price));
        Integer money = (int)(price*100);
        return Long.valueOf(String.valueOf(money));
    }

    public static String f2y(Long price) {
        return BigDecimal.valueOf(price).divide(new BigDecimal(100)).toString();
    }

}
