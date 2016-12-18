package com.ht.webservice.impl;

import com.ht.webservice.IHelloRestful;

public class HelloRestfulImpl implements IHelloRestful {

	public String say(String username) {
		return "[\""+ username +"\"]";
	}

}
