package com.ht.platform.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AccessOutInterceptor extends AbstractPhaseInterceptor<Message> {
	final Logger logger = LoggerFactory.getLogger(AccessOutInterceptor.class);
	
	public AccessOutInterceptor(){
		super(Phase.WRITE);
	}
	public AccessOutInterceptor(String phase) {
		super(phase);
	}

	public void handleMessage(Message arg0) throws Fault {
		Map<String, List<String>> headers = Headers.getSetProtocolHeaders(arg0);
		
		headers.put("Access-Control-Allow-Origin", Arrays.asList("*"));
		headers.put("Access-Control-Allow-Headers", Arrays.asList("Origin, X-Requested-With, Content-Type, Accept, Set-Cookie"));
        headers.put("Access-Control-Allow-Methods", Arrays.asList("POST", "GET", "PUT"));
        
	}

}
