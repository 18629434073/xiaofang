package com.ht.util;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.message.Message;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public abstract class InitParamUtil{
	private static Properties prop;
	private static Properties enprop;
	private static Properties zhprop;
	private static Properties deprop;
	private static Properties nlprop;
	
	
	static{
		prop =  new  Properties();    
		
		enprop =  new  Properties();
		zhprop =  new  Properties();
		deprop =  new  Properties();
		nlprop =  new  Properties();
		
         try  {    
        	String path=InitParamUtil.class.getResource("/").toURI().getPath().replace("//","/").replace("classes/", "config.properties");
        	System.out.println("InitParamUtilPath:"+path);
            prop.load(new FileInputStream(path));   
            
            String enPath=InitParamUtil.class.getResource("/").toURI().getPath().replace("//","/")+"com/ht/i18n/messages_en.properties";
            enprop.load(new FileInputStream(enPath));
            
            String zhPath=InitParamUtil.class.getResource("/").toURI().getPath().replace("//","/")+"com/ht/i18n/messages_zh_CN.properties";
            zhprop.load(new FileInputStream(zhPath));
            
            String dePath=InitParamUtil.class.getResource("/").toURI().getPath().replace("//","/")+"com/ht/i18n/messages_de.properties";
            deprop.load(new FileInputStream(dePath));
            
            String nlPath=InitParamUtil.class.getResource("/").toURI().getPath().replace("//","/")+"com/ht/i18n/messages_nl.properties";
            nlprop.load(new FileInputStream(nlPath));
            
        }  catch  (Exception e) {    
            e.printStackTrace();    
        }
	}
	
	public static String getProperty(String key){
		return prop.getProperty(key).trim();
	}
	
	public static String getProperty(String lang,String key){
		String result="";
		if("zh".equals(lang)){
			result=zhprop.getProperty(key);
		}else if("de".equals(lang)){
			result=deprop.getProperty(key);
		}else if("nl".equals(lang)){
			result=nlprop.getProperty(key);
		}else{
			result=enprop.getProperty(key);
		}
		
		if(result==null||result.isEmpty()){
			result=enprop.getProperty(key).trim();
		}
		
		return result;
	}
	
	public static String getLangType(MessageContext context){
		String lang="en";
		
		if(context!=null){
			Map proHeader= (Map)context.get(Message.PROTOCOL_HEADERS);
			String acceptLanguage="";
			if(proHeader!=null&&proHeader.get("accept-language")!=null){
				acceptLanguage=proHeader.get("accept-language").toString();
			}
			System.out.println("********************acceptLanguage:"+acceptLanguage);
			
			if(acceptLanguage.startsWith("[zh")){
				lang="zh";
			}else if(acceptLanguage.startsWith("[de")){
				lang="de";
			}else if(acceptLanguage.startsWith("[nl")){
				lang="nl";
			}
		}
		return lang;
	}
	
	public static void main(String[] args) {
		System.out.println(InitParamUtil.getProperty("nl","global.message"));
	}
}
