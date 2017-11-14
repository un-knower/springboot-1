package com.telit.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
public class DateUtil {

	//时间格式（yyyy-MM-dd HH:mm:ss）
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

	//时间格式（yyyyMMddHHmmss）
	public static final String DATE_HOUR_MINUTE = "HH:mm";

	//时间格式（yyyy-MM-dd）
	public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";
	
	//时间格式（yyyy-MM）
	public static final String DATE_FORMAT_MONTH = "yyyy-MM";
	
	//时间格式（yyyy）
	public static final String DATE_FORMAT_YEAR = "yyyy";
	
	//时间格式（yyyyMMddHHmmss）
	public static final String DATE_FORMAT_FULL_NUMBER = "yyyyMMddHHmmss";
	
	//时间格式（yyyyMMddHHmmss）
	public static final String DATE_FORMAT_SHORTYEAR_NUMBER = "yyMMddHHmmss";


	/**
	 * 获取特定格式的当前时间
	 * @param formatter
	 * @return
	 */
	public static String getCurrentDate(String formatter) {
		SimpleDateFormat df = new SimpleDateFormat(formatter);
		return df.format(new Date());
	}

	public static Date today() {
		return new Date();
	}


	public static Date parse(String dateStr) {
		try {
			return DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static int parseInterval(String startDate, String endDate){
		try {
			return (int)(DateUtils.parseDate(endDate, "yyyy-MM-dd hh:mm:ss","yyyy-MM-dd","yyyy-MM","yyyy").getTime()-DateUtils.parseDate(startDate, "yyyy-MM-dd hh:mm:ss","yyyy-MM-dd","yyyy-MM","yyyy").getTime());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static Date parse(String dateStr,String formatStr){
		try {
			return DateUtils.parseDate(dateStr, formatStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String date2Str(Date date, String format) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date date2Date(Date date, String format) {
		return 	parse(date2Str(date,format),format);
	}

	public static int daysBetween(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		startCal.setTime(startDate);
		endCal.setTime(endDate);
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		return (((int) (endCal.getTime().getTime() / 1000) - (int) (startCal.getTime().getTime() / 1000)) / (3600 * 24))+1;
	}
	
	public static int monthsBetween(String startDate, String endDate){
		return (parse(endDate, "yyyy-MM-dd").getYear()-parse(startDate, "yyyy-MM-dd").getYear())*12+parse(endDate, "yyyy-MM-dd").getMonth()-parse(startDate, "yyyy-MM-dd").getMonth()+1;
	}
	
	public static int monthsBetween2(String startDate, String endDate){
		Date sDate=parse(startDate, DateUtil.DATE_FORMAT_MONTH);	
		Date eDate=parse(endDate, DateUtil.DATE_FORMAT_MONTH);
      return (eDate.getYear()-sDate.getYear())*12+eDate.getMonth()-sDate.getMonth();
	}
	
	public static Date truncToZero(String shortDate, String type) {
		Calendar cal = Calendar.getInstance();
		Map<String, String> dtaeFormat = new HashMap<String, String>();
		dtaeFormat.put("0", DATE_FORMAT_SHORT);
		dtaeFormat.put("1", DATE_FORMAT_MONTH);
		dtaeFormat.put("2", DATE_FORMAT_YEAR);
		cal.setTime(DateUtil.parse(shortDate, dtaeFormat.get(type)));
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	public static Date truncToTwentyFour(String shortDate, String type) {
		Calendar cal = Calendar.getInstance();
		Map<String, String> dtaeFormat = new HashMap<String, String>();
		dtaeFormat.put("0", DATE_FORMAT_SHORT);
		dtaeFormat.put("1", DATE_FORMAT_MONTH);
		dtaeFormat.put("2", DATE_FORMAT_YEAR);
		cal.setTime(DateUtil.parse(shortDate, dtaeFormat.get(type)));
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date timeToZero(String shortDate, String type) {
		StringBuffer newDate = new StringBuffer(shortDate);
		Integer strLength = shortDate.length();
		Calendar cal = Calendar.getInstance();
		if(strLength == 7){//日期 ：2016-03-05
			newDate.append("-01");
		}else if((strLength == 4)){
			newDate.append("-01-01");
		}
		newDate.append(" 00:00:00");
		cal.setTime(DateUtil.parse(newDate.toString(), DATE_FORMAT_FULL));
		System.out.println(date2Str(cal.getTime() ,DATE_FORMAT_FULL));
		return cal.getTime();
	}
	
	public static Date timeToZero(String shortDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.parse(shortDate, DATE_FORMAT_SHORT));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	public static Date timeToTwentyFour(String shortDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.parse(shortDate, DATE_FORMAT_SHORT));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	public static Date getEndDate(String endDate, String type){
		Calendar ca = Calendar.getInstance();
		Date startDate = null;
		if(type.equals("0")){
			return DateUtil.truncToTwentyFour(endDate, type);
		}else if (type.equals("1")) {
			startDate = DateUtil.truncToZero(endDate, type);
			ca.setTime(startDate);
			ca.add(Calendar.MONTH, 1);
			ca.add(Calendar.SECOND, -1);
			return ca.getTime();
		}else {
			startDate = DateUtil.truncToZero(endDate, type);
			ca.setTime(startDate);
			ca.add(Calendar.YEAR, 1);
			ca.add(Calendar.SECOND, -1);
			return ca.getTime();
		}
	}

	
	public List<String> getBetweenMonth(String startDate, String endDate) throws Exception{
		List<String> reMonths = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date d1 = sdf.parse(startDate);//定义起始日期

		Date d2 = sdf.parse(endDate);//定义结束日期

		Calendar dd = Calendar.getInstance();//定义日期实例

		dd.setTime(d1);//设置日期起始时间
		
		while(dd.getTime().before(d2)){//判断是否到结束日期
			reMonths.add(sdf.format(dd.getTime()));
			dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
		}
		reMonths.add(sdf.format(dd.getTime()));
		
		return reMonths;
	}
	
	public List<String> getBetweenDay(String startDate, String endDate) throws Exception{
		List<String> reMonths = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(startDate);//定义起始日期

		Date d2 = sdf.parse(endDate);//定义结束日期

		Calendar dd = Calendar.getInstance();//定义日期实例

		dd.setTime(d1);//设置日期起始时间
		
		while(dd.getTime().before(d2)){//判断是否到结束日期
			reMonths.add(sdf.format(dd.getTime()));
			dd.add(Calendar.DATE, 1);//进行当前日期月份加1
		}
		reMonths.add(sdf.format(dd.getTime()));
		
		return reMonths;
	}
	
	public List<String> getBetweenYear(String startDate, String endDate) throws Exception{
		List<String> reMonths = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date d1 = sdf.parse(startDate);//定义起始日期

		Date d2 = sdf.parse(endDate);//定义结束日期

		Calendar dd = Calendar.getInstance();//定义日期实例

		dd.setTime(d1);//设置日期起始时间
		
		while(dd.getTime().before(d2)){//判断是否到结束日期
			reMonths.add(sdf.format(dd.getTime()));
			dd.add(Calendar.YEAR, 1);//进行当前日期年份加1
		}
		reMonths.add(sdf.format(dd.getTime()));
		
		return reMonths;
	}

	
	public static boolean compareDate(Date startDate, Date endDate){
		Calendar startc = Calendar.getInstance();    
	    Calendar endc = Calendar.getInstance();    
	    startc.setTime(startDate);    
	    endc.setTime(endDate);    
	    
	    int result = endc.compareTo(startc);    
	    if (result >= 0)    
	        return true;    
	    else    
	        return false;
	}

	/**
	 * 比较某个时间是否在给定时间段内
	 * @param testDate
	 * @param startDate
	 * @param endDate
	 * @param formatter
	 * @return
	 */
	public static boolean isBetweenDate(String testDate,String startDate,String endDate,String formatter){
		Date date = parse(testDate,formatter);
		Date date1 = parse(startDate,formatter);
		Date date2 = parse(endDate,formatter);
		Calendar startc = Calendar.getInstance();
		Calendar endc = Calendar.getInstance();
		Calendar testc = Calendar.getInstance();

		startc.setTime(date1);
		endc.setTime(date2);
		testc.setTime(date);
		if(testc.compareTo(startc)>=0&&endc.compareTo(testc)>=0){
			return true;
		}else{
			return false;
		}

	}

	/**
	 * 获取当年第一天
	 * @return
	 */
	public static String getStartTime(){
		 Calendar cal = Calendar.getInstance();
		 return cal.get(Calendar.YEAR)+"-01-01";
	}
	
}
