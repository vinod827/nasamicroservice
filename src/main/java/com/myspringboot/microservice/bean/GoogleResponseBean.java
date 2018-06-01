/**
 * 
 */
package com.myspringboot.microservice.bean;

/**
 * @author 30069
 *
 */
public class GoogleResponseBean {

	private String results;
	private String longName;
	private String shortName;
	
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
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
	public GoogleResponseBean(String results, String longName, String shortName) {
		super();
		this.results = results;
		this.longName = longName;
		this.shortName = shortName;
	}
	
	
}
