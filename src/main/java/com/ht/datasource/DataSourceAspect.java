package com.ht.datasource;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DataSourceAspect implements MethodBeforeAdvice,AfterReturningAdvice   
{

	 @Override  
	    public void afterReturning(Object returnValue, Method method,  
	            Object[] args, Object target) throws Throwable {  
	        // TODO Auto-generated method stub  
	        DataSourceContextHolder.clearDataSourceType();  
	    }  
	  
	    @Override  
	    public void before(Method method, Object[] args, Object target)  
	            throws Throwable {  
	    	Annotation[]  array=method.getAnnotations();
	        if (method.isAnnotationPresent(DataSource.class))   
	        {  
	            DataSource datasource = method.getAnnotation(DataSource.class);  
	            DataSourceContextHolder.setDataSourceType(datasource.value());  
	        }  
	        else  
	        {  
	  
	        }  
	          
	    }  
}
