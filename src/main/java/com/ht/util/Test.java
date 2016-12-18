package com.ht.util;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		method();
	}

	public static void method(){
	}
	
	
	public String logonPACWS(String userName, String password){
		 String logonURL = "https://api-qs.emfit.com/api/v1/monitor/254?remember_token=HgAKwwrQMjhkDQilJxY2h7BAt2Jgb9uC48Oohipza6YjsggxMfFfNIxAzpKX";
//        String logonURL = "https://api-qs.emfit.com/api/v1/presence/latest/254?remember_token=HgAKwwrQMjhkDQilJxY2h7BAt2Jgb9uC48Oohipza6YjsggxMfFfNIxAzpKX";
//        String logonURL = "https://api-qs.emfit.com/api/v1/login?username=00067B&password=Naulatehdas8";
//        String logonURL="https://api-qs.emfit.com/api/v1/trends/254?remember_token=HgAKwwrQMjhkDQilJxY2h7BAt2Jgb9uC48Oohipza6YjsggxMfFfNIxAzpKX";
		String xmlContent = "";		
		String token = "";
		try {
			StringEntity entry = new StringEntity(xmlContent);
//			String responseStr = HttpClientUtil.crossServerAction(logonURL, entry,null,"get"); 
			String responseStr="";
//			JSONObject json = JSONObject.parseObject(responseStr);
			JSONArray json=JSONArray.parseArray(responseStr);
			int length=json.size();//10467
			List dataList1=new ArrayList();
			List dataList2=new ArrayList();
			List dataList3=new ArrayList();
			
			Map dataMap1=new HashMap();
			Map dataMap2=new HashMap();
			Map dataMap3=new HashMap();
			
			List monitor=new ArrayList();
			for (int i = length-1; i > -1; i--) {
				
				Map heartRate=new HashMap();
				Map respirationRate=new HashMap();
				Map activity=new HashMap();
				
				heartRate.put("x", ((JSONArray)json.get(i)).get(0));
				heartRate.put("y", ((JSONArray)json.get(i)).get(1));
				dataList1.add(heartRate);
				
				respirationRate.put("x", ((JSONArray)json.get(i)).get(0));
				respirationRate.put("y", ((JSONArray)json.get(i)).get(2));
				dataList2.add(respirationRate);
				
				activity.put("x", ((JSONArray)json.get(i)).get(0));
				activity.put("y", ((JSONArray)json.get(i)).get(3));
				dataList3.add(activity);
			}
			dataMap1.put("key", "Heart rate");
			dataMap1.put("values", dataList1);
			dataMap1.put("lines", 0);
			
			dataMap2.put("key", "Respiration rate");
			dataMap2.put("values", dataList2);
			dataMap2.put("lines", 1);
			
			dataMap3.put("key", "Activity");
			dataMap3.put("values", dataList3);
			dataMap3.put("lines", 2);
			
			monitor.add(dataMap1);
			monitor.add(dataMap2);
			monitor.add(dataMap3);
			
			System.out.println(monitor);
//			JSONArray jsonArray=json.getJSONArray("sleep_epoch_data");
			
			
//			System.out.println(Float.parseFloat(((JSONArray)jsonArray.get(0)).get(0).toString())*1000);
			
//			JSONArray jsonArray=json.getJSONArray("calc_data");
//			List result=new ArrayList();
//			Map hrMap=new HashMap();
//			Map rrMap=new HashMap();
//			
//			List<Map<String,Float>> hrList=new ArrayList<Map<String,Float>>();
//			List<Map<String,Float>> rrList=new ArrayList<Map<String,Float>>();
//			
//			float hrValue=0;
//			float rrValue=0;
//			for (int i = 0; i < jsonArray.size(); i++) {
//				if((i+1)%300==0){
//					Map<String,Float> hrValueMap=new HashMap<>(); 
//					Map<String,Float> rrValueMap=new HashMap<>();
//					hrValueMap.put("x", (Float.parseFloat(((JSONArray)jsonArray.get(i)).get(0).toString())-150)*1000);
//					hrValueMap.put("y",hrValue/300);
//							
//					rrValueMap.put("x", (Float.parseFloat(((JSONArray)jsonArray.get(i)).get(0).toString())-150)*1000);
//					rrValueMap.put("y",rrValue/300);
//					
//					hrValue=0;
//					rrValue=0;
//					
//					hrList.add(hrValueMap);
//					rrList.add(rrValueMap);
//				}else{
//					hrValue+=((JSONArray)jsonArray.get(i)).get(1)==null?0:Float.parseFloat(((JSONArray)jsonArray.get(i)).get(1).toString());
//					rrValue+=((JSONArray)jsonArray.get(i)).get(2)==null?0:Float.parseFloat(((JSONArray)jsonArray.get(i)).get(2).toString());
//				}
//			}
//			
//			hrMap.put("key", "Heart rate");
//			hrMap.put("values", hrList);
//			result.add(hrMap);
//			
//			rrMap.put("key", "Respiration rate");
//			rrMap.put("bar", true);
//			rrMap.put("values", rrList);
//			result.add(rrMap);
//			
//			json.remove("calc_data");
//			json.put("hrrr_data", result);
//			
//			System.out.println("json::"+jsonArray.size());
			//token = json.getString("token").replace("\"", "#quote#");
			//System.out.println("token::"+token);
			
			String url ="";
//			String httpOrgCreateTest = url + "https://api-qs.emfit.com/api/v1/login";  
//			String httpOrgCreateTest = url + "https://api-qs.emfit.com/api/v1/presence/182160?remember_token=HgAKwwrQMjhkDQilJxY2h7BAt2Jgb9uC48Oohipza6YjsggxMfFfNIxAzpKX";  
//			 Map<String,String> createMap = new HashMap<String,String>();    
////			       createMap.put("username","00067B");  
////			       createMap.put("password","Naulatehdas8");  
//			       String charset = "utf-8";
//			       HttpClientUtil httpClientUtil = new HttpClientUtil(); 
//			       String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
//			        System.out.println("result:"+httpOrgCreateTestRtn);  

		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}
	
//	public String crossServerAction(String address, HttpEntity entry, String token, String method){
//		StringBuffer stringBuffer = new StringBuffer();
//		BufferedReader reader = null;
//		InputStreamReader inputStr = null;
//		HttpClient httpClient = new DefaultHttpClient();
//		try {
//			HttpParams params = httpClient.getParams();
//		    HttpConnectionParams.setConnectionTimeout(params, 30000);
//		    HttpConnectionParams.setSoTimeout(params, 30000);
//		    HttpUriRequest requestMethod = null;
//		    if("Get".equalsIgnoreCase(method)){
//		    	requestMethod = new HttpGet(address);
//		    }else{
//		    	HttpPost hp = new HttpPost(address);
//		    	hp.setEntity(entry);
//		    	requestMethod = hp;
//		    }
//		    requestMethod.setHeader("Accept", "text/plain,application/json");
//		    requestMethod.setHeader("Content-Type", "application/xml");
//		    requestMethod.setHeader("Cookie", token);	
//			HttpResponse response = httpClient.execute(requestMethod);
//			StatusLine sl = response.getStatusLine();
//			if(sl.getStatusCode()!=200){
//              System.out.println("error!!!");
//			}
//			HttpEntity entity = response.getEntity();
//			if(entity!=null){
//				inputStr = new InputStreamReader(entity.getContent(), "UTF-8");
//				reader = new BufferedReader(inputStr);
//				String line = null;
//				while ((line = reader.readLine()) != null) {
//					stringBuffer.append(line);
//				}
//			}
//		} catch(Exception e){
//			System.out.println(e.getMessage());
//		} finally{
//			if(reader!=null){
//				try{
//					reader.close();
//				}catch(Exception e){
//					System.out.println(e.getMessage());
//				}
//			}
//			if(inputStr!=null){
//				try{
//					inputStr.close();
//				}catch(Exception e){
//					System.out.println(e.getMessage());
//				}
//			}
//			httpClient.getConnectionManager().shutdown();
//		}
//		return stringBuffer.toString();
//	}
	
	public static DefaultHttpClient getSecuredHttpClient(HttpClient httpClient) {
		final X509Certificate[] _AcceptedIssuers = new X509Certificate[] {};
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");
			X509TrustManager tm = new X509TrustManager() {
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return _AcceptedIssuers;
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				@Override
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}
			};
			ctx.init(null, new TrustManager[] { tm }, new SecureRandom());
			SSLSocketFactory ssf = new SSLSocketFactory(ctx,
					SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			ClientConnectionManager ccm = httpClient.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
			return new DefaultHttpClient(ccm, httpClient.getParams());
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		return null;
	}
	
	
	
	
	
//	public String crossServerAction(String address, HttpEntity entry, String token, String method){
//		StringBuffer stringBuffer = new StringBuffer();
//		BufferedReader reader = null;
//		InputStreamReader inputStr = null;
//		HttpClient httpClient = new DefaultHttpClient();
//		if(address.startsWith("https")){
//			httpClient = ClusterHelper.getSecuredHttpClient(httpClient);
//		}	
//		try {
//			HttpParams params = httpClient.getParams();
//		    HttpConnectionParams.setConnectionTimeout(params, 30000);
//		    HttpConnectionParams.setSoTimeout(params, 30000);
//		    HttpUriRequest requestMethod = null;
//		    if("Get".equalsIgnoreCase(method)){
//		    	requestMethod = new HttpGet(address);
//		    }else{
//		    	HttpPost hp = new HttpPost(address);
//		    	hp.setEntity(entry);
//		    	requestMethod = hp;
//		    }
//		    requestMethod.setHeader("Accept", "text/plain,application/json");
//		    requestMethod.setHeader("Content-Type", "application/xml");
//		    requestMethod.setHeader("Cookie", token);	
//			HttpResponse response = httpClient.execute(requestMethod);
//			StatusLine sl = response.getStatusLine();
//			if(sl.getStatusCode()!=200){
//				logger.error(sl);
//				logger.error(sl.getReasonPhrase());
//				throw new Exception("Can not connect to remote server");
//			}
//			HttpEntity entity = response.getEntity();
//			if(entity!=null){
//				inputStr = new InputStreamReader(entity.getContent(), "UTF-8");
//				reader = new BufferedReader(inputStr);
//				String line = null;
//				while ((line = reader.readLine()) != null) {
//					stringBuffer.append(line);
//				}
//			}
//		} catch(Exception e){
//			logger.error("Failed to get remote data: " + e.getMessage());
//		} finally{
//			if(reader!=null){
//				try{
//					reader.close();
//				}catch(Exception e){
//					logger.error(e.getMessage());
//				}
//			}
//			if(inputStr!=null){
//				try{
//					inputStr.close();
//				}catch(Exception e){
//					logger.error(e.getMessage());
//				}
//			}
//			httpClient.getConnectionManager().shutdown();
//		}
//		return stringBuffer.toString();
//	}

	
}

