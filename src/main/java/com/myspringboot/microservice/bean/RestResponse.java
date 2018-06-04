/**
 * 
 */
package com.myspringboot.microservice.bean;

import java.util.Arrays;

/**
 * @author 30069
 *
 */
public class RestResponse {
	
	private String[] messages;
	private Result result;
	
	public RestResponse() {
		
	}
	public String[] getMessages() {
		return messages;
	}
	public void setMessages(String[] messages) {
		this.messages = messages;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public RestResponse(String[] messages, Result result) {
		super();
		this.messages = messages;
		this.result = result;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rest Response [messages="+Arrays.toString(messages)+", result="+result;
	}

	
}
