package com.ht.webservice.impl;

import com.ht.webservice.IHelloSoap;


public class HelloSoapImpl implements IHelloSoap {
	
	public String say(String username) {
		return String.format("Hello %s !", username);
	}

}
