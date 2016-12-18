package com.ht.platform.provider;

import javax.ws.rs.core.Response.Status;

public class InvokeFault extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7217532212620096919L;
	
	public InvokeFault(){
		super("Server exception, please contact the administrator.");
		this.status = Status.INTERNAL_SERVER_ERROR;
	}
	public InvokeFault(Status status, String message){
		super(message);	
		this.status = status;
	}
	
	private Status status;

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

}
