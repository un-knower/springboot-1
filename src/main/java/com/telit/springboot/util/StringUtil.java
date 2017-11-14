package com.telit.springboot.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {
    /**
     * 判断非空
     */
    public static boolean isEmpty(Object obj){
        if(obj instanceof String){
            if(!StringUtils.isEmpty(obj)){
                obj = ((String)obj).trim();
                return StringUtils.isEmpty(obj);
            }
        }
        return StringUtils.isEmpty(obj);
    }

    /**
     * 判断非空
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    /**
     * 1-5转换成周一到周五
     * @param str
     * @return
     */
    public static  String formatter(String str) {
        if("1".equals(str)){
            return "one";
        }else if("2".equals(str)){
            return "two";
        }else if("3".equals(str)){
            return "three";
        }else if("4".equals(str)){
            return "four";
        }else if("5".equals(str)) {
            return "five";
        }else if("6".equals(str)) {
            return "six";
        }else if("7".equals(str)) {
            return "seven";
        }else {
            return "eight";
        }
    }
}
