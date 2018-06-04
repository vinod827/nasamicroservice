/**
 * 
 */
package com.myspringboot.microservice.consumer.nasa.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myspringboot.microservice.bean.GoogleResponseBean;
import com.myspringboot.microservice.bean.NasaResponseBean;
import com.myspringboot.microservice.bean.ResponseBean;

/**
 * @author daddy
 *
 */
@RestController
public class NasaController {
	
	private Logger logger = LoggerFactory.getLogger(NasaController.class);
	private final String USER_AGENT = "Mozilla/5.0"; 
	
	@RequestMapping(path="/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String defaultRoute() {
		return "Hello NASA Microservices";
	}

	
	@GetMapping("/get-news-nasa/country/{country}/apiKey/{apiKey}")
	public String getNews(@PathVariable String country, @PathVariable String apiKey) {
		logger.info("Entering getNews@NasaController");
		String nasaServiceUrl = "https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+apiKey;
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("country", country);
		uriVariables.put("apiKey", apiKey);
		
		logger.info("nasa service url: "+nasaServiceUrl+", country: "+country+", apikey: "+apiKey);

		RestTemplate restTemplate = new RestTemplate();
		ResponseBean responseBean = restTemplate.getForObject(nasaServiceUrl, ResponseBean.class);
		
		logger.info("responseBean*************: "+responseBean.toString());
		
		logger.info("Exiting getNews@NasaController");
		return responseBean.toString();
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
	public GoogleResponseBean getAddressfromGoogle(@PathVariable String address, @PathVariable String apiKey) throws JSONException {
		logger.info("Entering getAddressfromGoogle@NasaController");
		String googleUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+apiKey;
		//String googleUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=Vatika%20Tower&key=AIzaSyDO19jHY9aqcMVHR0SAp3JWDY_gFEXo74E
				
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("address", address);
		uriVariables.put("apiKey", apiKey);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GoogleResponseBean> responseEntity = restTemplate.getForEntity(googleUrl, GoogleResponseBean.class, uriVariables);
		GoogleResponseBean response = responseEntity.getBody();
		System.out.println("response ->"+response.getResults());
		
		logger.info("Exiting getAddressfromGoogle@NasaController");
		return new GoogleResponseBean(response.getResults(), null, null);
	}
	
	
	@GetMapping("/locationapi/search/address/{address}/apiKey/{apiKey}")
	public String getLocation(@PathVariable String address, @PathVariable String apiKey) throws Exception{
		logger.info("Entering getAddressfromGoogle@NasaController");
		String googleUrl = "https://demo0954903.mockable.io/location";
				
		String url = "https://demo7704768.mockable.io/orderstatus";
        
		
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
        }
        in.close();
        JSONObject json = new JSONObject(response.toString()); 
        String msg = json.get("location").toString();

       
        return msg;

 }
}
