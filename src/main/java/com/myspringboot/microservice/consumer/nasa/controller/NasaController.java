/**
 * 
 */
package com.myspringboot.microservice.consumer.nasa.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myspringboot.microservice.bean.GoogleResponseBean;
import com.myspringboot.microservice.bean.NasaResponseBean;

/**
 * @author daddy
 *
 */
@RestController
public class NasaController {
	
	private Logger logger = LoggerFactory.getLogger(NasaController.class);

	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String defaultRoute() {
		return "Hello NASA Microservices";
	}

	@GetMapping("/get-news/country/{country}/apiKey/{apiKey}")
	public NasaResponseBean getNewsFromNasa(@PathVariable String country, @PathVariable String apiKey) {
		logger.info("Entering getNewsFromNasa@NasaController");
		String nasaServiceUrl = "https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+apiKey;
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("country", country);
		uriVariables.put("apiKey", apiKey);
		
		System.out.println("nasa service url: "+nasaServiceUrl);
		System.out.println("country: "+country);
		System.out.println("apiKey: "+apiKey);
		
		ResponseEntity<NasaResponseBean> responseEntity = new RestTemplate().getForEntity(nasaServiceUrl, NasaResponseBean.class, uriVariables);
		NasaResponseBean response = responseEntity.getBody();
		
		System.out.println("response: "+response);
		
		logger.info("Exiting getNewsFromNasa@NasaController");
		return new NasaResponseBean(response.getAuthor(), response.getTitle(), response.getDescription(), response.getUrl());
	}
	

	@GetMapping("/googleapi/search/address/{address}/apiKey/{apiKey}")
	public GoogleResponseBean getAddressfromGoogle(@PathVariable String address, @PathVariable String apiKey) {
		logger.info("Entering getAddressfromGoogle@NasaController");
		String googleUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+apiKey;
		
				//String googleUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=Vatika%20Tower&key=AIzaSyDO19jHY9aqcMVHR0SAp3JWDY_gFEXo74E
				
				
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("address", address);
		uriVariables.put("apiKey", apiKey);
		
		System.out.println("googleUrl service url: "+googleUrl);
		System.out.println("address: "+address);
		System.out.println("apiKey: "+apiKey);
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<GoogleResponseBean> responseEntity = restTemplate.getForEntity(googleUrl, GoogleResponseBean.class, uriVariables);
		System.out.println("Google responseEntity->>>>>>>>: "+responseEntity);
		
		GoogleResponseBean response = responseEntity.getBody();
		
		
		System.out.println("Google response: "+response);
		
		logger.info("Exiting getAddressfromGoogle@NasaController");
		return new GoogleResponseBean(response.getResults(), null, null);
	}
}
