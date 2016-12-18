package com.ht.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public final static String SESSION_USER = "SESSION_USER";
	public final static String SESSION_TARGET = "SESSION_TARGET";

	public final static String LOGIN_USER="LOGIN_USER";
	
	public final static String ROLE_ADMIN_ID = "admin";
	
	public static final Integer DAY_SECS = 864000;
	public static final Long DAY_MILLIS = 86400000L;
	
	public static final String EVENT_WALKING_SPEED = "speed";
	public static final String EVENT_GOING_OUTSIDE = "outside";
	public static final String EVENT_MEAL = "meal";
	public static final String EVENT_SLEEP = "sleep";
	public static final String EVENT_GENERAL_ACTIVITY = "activity";
	public static final String EVENT_VISITING_BATHROOM = "bathroom";
	
	public static final String BED_HRRR = "hrrr";
	public static final String BED_HRV = "hrv";
	public static final String BED_ANS = "ans";
	public static final String BED_SLEEPCLASS = "sleepclass";
	
	public static final String ACTION_GRAIN_DAY = "day";
	public static final String ACTION_GRAIN_WEEK = "week";
	public static final String ACTION_GRAIN_MONTH = "month";
	
	public static final String CLIENT_ID = "CLIENTID";

	public static final Map<String,String> eventGroupMap = new HashMap<>();

	//����Ա
	public static final String ROLE_ADMIN = "-1";
	//�����û�
	public static final String ROLE_PERSON = "0";
	//����Ժ�û�
	public static final String ROLE_NURSING = "1";
	//ҽ�ƻ����û�
	public static final String ROLE_INSTITUTION = "2";
	//�����û�
	public static final String ROLE_OTHER = "3";
	//����Ժ�����û�
	public static final String ROLE_NURSING_MANAGE = "4";
	//ҽ�ƻ�������Ա
	public static final String ROLE_INSTITUTION_MANAGE = "5";

	public  static  final  String  ADMIN_ROLE="0";

	public  static  final  String  INSTITUTION_ROLE="1";

	public  static  final  String  NORMAL_USER_ROLE="2";

	public  static  final  String  PERISON_USER_ROLE="3";

}
