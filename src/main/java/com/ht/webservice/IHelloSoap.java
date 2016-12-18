package com.ht.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="/hello")
public interface IHelloSoap {
	@WebMethod(operationName = "say")
	public String say(@WebParam(name = "username") String username);
}
