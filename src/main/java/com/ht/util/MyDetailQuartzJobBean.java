package com.ht.util;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyDetailQuartzJobBean extends QuartzJobBean {
	protected final Log logger = LogFactory.getLog(getClass());
	private String targetObject;
	private String targetMethod;
	private ApplicationContext ctx;
	private static boolean isRun = false;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			logger.info("execute [" + targetObject + "] at once>>>>>>");
			Object otargetObject = ctx.getBean(targetObject);
			Method m = null;

			try {
				if("notifyService".equals(targetObject)){
					if(isRun){
						logger.info("target [" + targetObject + "] is running,is not execute.");
						return;
					}
					isRun=true;
					m = otargetObject.getClass().getMethod(targetMethod, new Class[] {JobExecutionContext.class});
					m.invoke(otargetObject, new Object[] {context});
					isRun=false;
				}else {
					m = otargetObject.getClass().getMethod(targetMethod, new Class[] {JobExecutionContext.class});
					m.invoke(otargetObject, new Object[] {context});
				}

			} catch (SecurityException e) {
				logger.error(e);
			} catch (NoSuchMethodException e) {
				logger.error(e);
			}
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}
	}
	

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.ctx = applicationContext;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}


}