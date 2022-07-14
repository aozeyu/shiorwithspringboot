package com.heeexy.example.util;

/**
 * @program: example
 * @description: 33
 * @packagename: com.heeexy.example.util
 * @author: 姚泽宇
 * @date: 2022-07-14 18:39
 **/
public class StringTools {
    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}
