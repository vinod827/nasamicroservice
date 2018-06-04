/**
 * 
 */
package com.myspringboot.microservice.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 30069
 *
 */
public class ResponseBean {

	@JsonProperty
	private RestResponse restResponse;

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	public ResponseBean(RestResponse restResponse) {
		super();
		this.restResponse = restResponse;
	}

	@Override
	public String toString() {
		return "ResponseBean [restResponse=" + restResponse + "]";
	}
	
	public ResponseBean() {
		
	}
}
