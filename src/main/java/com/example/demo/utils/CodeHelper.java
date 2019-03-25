package com.example.demo.utils;

import java.security.MessageDigest;
import java.util.Date;

/**
 * @author: WangMeng
 * @date:2017/7/21
 * @description:TODO
 */
public class CodeHelper {

    public static String MD5(String key) {
        Date date = new Date();
        Long time = date.getTime();
        key = key + time.toString() + Math.random();

        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).substring(0, 8);
        } catch (Exception e) {
            return null;
        }
    }
}
