package com.ht.util;

import com.ht.model.filters.Pagination;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;

public class CommonUtils {
	public static String getRealPath(HttpServletRequest request, String arg0){
		return request.getSession().getServletContext().getRealPath(arg0);

	}
	public static List<Long> getTimeMillisInbeds(int index){
		List<Long> list = new ArrayList<Long>();
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.add(Calendar.DAY_OF_MONTH,-index*10);
		for (int i=0;i<10;i++){
			c.add(Calendar.DAY_OF_MONTH,1);
			list.add(c.getTimeInMillis());
		}
		return list;
	}

	public static List<Long> getTimeMillisInTends(String grain){
		List<Long> list = new ArrayList<Long>();

		Calendar when = Calendar.getInstance();
		when.setFirstDayOfWeek(Calendar.SUNDAY);

		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SUNDAY);

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		if(grain.equals(Constants.ACTION_GRAIN_DAY)){
			c.add(Calendar.DAY_OF_YEAR, -7);
			for(int i = 7; i > 0; i--){
				c.add(Calendar.DAY_OF_YEAR, 1);

				list.add(c.getTimeInMillis());
			}

		} else if(grain.equals(Constants.ACTION_GRAIN_WEEK)){
			c.add(Calendar.MONTH, -2);
			while(true){
				c.add(Calendar.WEEK_OF_YEAR, 1);
				c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

				if(c.before(when)){
					list.add(c.getTimeInMillis());

				} else {

					break;
				}

			}

		} else if(grain.equals(Constants.ACTION_GRAIN_MONTH)){
			c.add(Calendar.MONTH, -12);
			while(true){
				c.add(Calendar.MONTH, 1);
				c.set(Calendar.DAY_OF_MONTH, 1);

				if(c.before(when)){
					list.add(c.getTimeInMillis());

				} else {
					break;
				}
			}

		}

		return list;
	}

	public static Map<String, Object> gCommonResponse(Boolean status, String message){
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("status", status);
		map.put("message", message);

		return map;
	}

	public  static  boolean isEmpty(String s){
		return  (s==null||s=="")?true:false;
	}

	public static Pagination constructParams(Object object, Pagination page) throws Exception {
		Map<String,Object> params=page.getParams();
		Class objectclass=(Class)object.getClass();
		Field[] fs = objectclass.getDeclaredFields();
		for(int i = 0 ; i < fs.length; i++){
			Field f = fs[i];
			f.setAccessible(true); //设置些属性是可以访问的
			Object val = f.get(object);//得到此属性的值

			String type = f.getType().toString();//得到此属性的类型
			if (type.endsWith("String")&&val!=null) {
				params.put(f.getName(),val.toString());

			}else if(type.endsWith("int") || type.endsWith("Integer")){
				if(Integer.parseInt(String.valueOf(val))!=0){
					params.put(f.getName(),Integer.parseInt(String.valueOf(val)));
				}
			}else{
				System.out.println(f.getType()+"\t");
			}

		}
		page.setParams(params);

       /*
        * 得到类中的方法
        */
		Method[] methods = objectclass.getMethods();
		for(int i = 0; i < methods.length; i++){
			Method method = methods[i];
			if(method.getName().startsWith("get")){
				System.out.print("methodName:"+method.getName()+"\t");
				System.out.println("value:"+method.invoke(object));//得到get 方法的值
			}
		}
		return page;

}

	public static int getRecordCount(String sql, SessionFactory sessionFactory) {
		String countsql="SELECT COUNT(*) FROM("+sql.toString()+")t";
		SQLQuery countquery=sessionFactory.getCurrentSession().createSQLQuery(countsql.toString());
		return ((BigInteger) countquery.list().get(0)).intValue();
	}
}
