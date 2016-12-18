package com.ht.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class DateUtil {

	/**
	 * 
	 * ��������������ʱ��ĺ�������ʽ��Ϊʱ�����ʽ���ַ���
	 * ����ʱ��:2014-7-17
	 * ����ʱ��:2014-7-17
	 * @param millsecond
	 * @return
	 */
	public static String formatTime(long millsecond) {
		long ms = millsecond % 1000;
		long second = millsecond / 1000 % 60;
		long minute = millsecond / 1000 / 60 % 60;
		long hour = millsecond / 1000 / 60 / 60;
//		return "" + hour + "ʱ" + minute + "��" + second + "��" + ms + "����";
		return "["+minute + "��" + second + "��" + ms + "����]";
	}

	public static String getDateBefore90Days() {
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DATE, -90);
		calendar.add(Calendar.DATE, -360);
		return format(calendar.getTime(), "yyyy-MM-dd 00:00:00");
	}
	
	public static Date getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}

	public static Date aweekBefore(long time) {
		return new Date(time-86400000*7);
	}
	public static Date aweekBefore() {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, -7);
		return calendar.getTime();
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String format(Long date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date*1000);
	}

	public static String formatEnDate(Long date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern,Locale.ENGLISH);
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date*1000);
	}
	
	public static Date parse(String dateStr) throws ParseException {
		return parse(dateStr, "yyyyMMdd HH:mm:ss");
	}
	
	public static long getGmtTime(Date date) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}
	public static Date parse(String dateStr, String pattern) throws ParseException {
		dateStr = dateStr.replaceAll("[\\.|-]", "");
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}

	/**
	 * +-N����
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date month(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 
	 * +-N����
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date day(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * ��ǰ����+-month����,+-day��
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date monthDay(Date date, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	public static String getWeek(Long date){
		try {
			  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  Date d = format.parse(format.format(date));
			  Calendar calendar = Calendar.getInstance();
			  calendar.setFirstDayOfWeek(Calendar.MONDAY);
			  calendar.setTime(d);
			  return Integer.toString(calendar.get(Calendar.YEAR))+calendar.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
		
	}

	/**
	 * �Ƚ��������ڴ�С����ȥ��ʱ������Ϣ
	 */
	public static int compareTo(Date date1,Date date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date1=sdf.parse(sdf.format(date1));
			date2=sdf.parse(sdf.format(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1.compareTo(date2);
	}
	
	
	public static void main(String[] args) throws ParseException {
//		Date end=DateUtil.parse("20150902 12:20:30");
//		Date now=DateUtil.parse("20150903 8:20:30");
//		
//		System.out.println(compareTo(end,now));
//		System.out.println(formatTime(31881000));
//		System.out.println(getGmtTime(parse("20150806","yyyyMMdd")));
		
		System.out.println(format(1438825440l,"yyyyMMdd"));
		System.out.println(getWeek(1450207200000l));
		
	}

}
