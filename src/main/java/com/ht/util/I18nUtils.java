package com.ht.util;

import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * International tool
 * @author de
 *
 */
public class I18nUtils {
	
	/**
	 * Access to international language
	 * @param request HttpServletRequest
	 * @param code String
	 * @return message String
	 */
	public static String getMessage(HttpServletRequest request, String code){
		return new RequestContext(request).getMessage(code);
	}

}
