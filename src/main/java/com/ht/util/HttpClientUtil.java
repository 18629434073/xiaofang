package com.ht.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {
	
	public static String crossServerAction(String address, HttpEntity entry, String token, String method){
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader reader = null;
		InputStreamReader inputStr = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpParams params = httpClient.getParams();
		    HttpConnectionParams.setConnectionTimeout(params, 30000);
		    HttpConnectionParams.setSoTimeout(params, 30000);
		    HttpUriRequest requestMethod = null;
		    if("Get".equalsIgnoreCase(method)){
		    	requestMethod = new HttpGet(address);
		    }else{
		    	HttpPost hp = new HttpPost(address);
		    	hp.setEntity(entry);
		    	requestMethod = hp;
		    }
		    requestMethod.setHeader("Accept", "text/plain,application/json");
		    requestMethod.setHeader("Content-Type", "application/xml");
		    requestMethod.setHeader("Cookie", token);	
			HttpResponse response = httpClient.execute(requestMethod);
			StatusLine sl = response.getStatusLine();
			if(sl.getStatusCode()!=200){
              System.out.println("error!!!");
			}
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				inputStr = new InputStreamReader(entity.getContent(), "UTF-8");
				reader = new BufferedReader(inputStr);
				String line = null;
				while ((line = reader.readLine()) != null) {
					stringBuffer.append(line);
				}
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		} finally{
			if(reader!=null){
				try{
					reader.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			if(inputStr!=null){
				try{
					inputStr.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			httpClient.getConnectionManager().shutdown();
		}
		return stringBuffer.toString();
	}
	
	
	public String doPost(String url, Map<String, String> map, String charset) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// ���ò���
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<?> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				@SuppressWarnings("unchecked")
				Entry<String, String> elem = (Entry<String, String>) iterator
						.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,
						charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
