package com.telit.springboot.util;

import java.net.URLDecoder;

/**
 * 中文乱码处理
 * @author zz
 *
 */
public class GarbledUtil {

	/*
	 * @string 待转换的字符串(前台经过两次encodeURI()方法处理的字符串）
	 */
	public static String convert(String string){
		try {
			return URLDecoder.decode(StringUtil.isEmpty(string) ? "" : string, "UTF-8");
		} catch (Exception e) {
			return string;
		} 	
	}
}
