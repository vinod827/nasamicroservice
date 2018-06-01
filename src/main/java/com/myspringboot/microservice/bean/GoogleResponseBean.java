/**
 * 
 */
package com.myspringboot.microservice.bean;

import java.util.List;

/**
 * @author 30069
 *
 */
public class GoogleResponseBean {

	private List results;
	private String longName;
	private String shortName;
	
	
	
	public GoogleResponseBean(List results, String longName, String shortName) {
		super();
		this.results = results;
		this.longName = longName;
		this.shortName = shortName;
	}



	public GoogleResponseBean() {
		
	}
	

	
	public List getResults() {
		return results;
	}



	public void setResults(List results) {
		this.results = results;
	}



	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	
}
