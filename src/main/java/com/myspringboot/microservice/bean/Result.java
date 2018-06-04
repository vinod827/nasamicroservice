/**
 * 
 */
package com.myspringboot.microservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 30069
 *
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
	
	private String name;
	private String alpha1_code;
	private String alpha2_code;
	
	public Result() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlpha1_code() {
		return alpha1_code;
	}
	public void setAlpha1_code(String alpha1_code) {
		this.alpha1_code = alpha1_code;
	}
	public String getAlpha2_code() {
		return alpha2_code;
	}
	public void setAlpha2_code(String alpha2_code) {
		this.alpha2_code = alpha2_code;
	}
	public Result(String name, String alpha1_code, String alpha2_code) {
		super();
		this.name = name;
		this.alpha1_code = alpha1_code;
		this.alpha2_code = alpha2_code;
	}
	@Override
	public String toString() {
		return "Result [name=" + name + ", alpha1_code=" + alpha1_code + ", alpha2_code=" + alpha2_code + "]";
	}

}
