package com.albo.test.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/index")
public class MainController {
	
	@RequestMapping(method=RequestMethod.GET)
	public Object index() throws IOException {
		List<Object> list = new ArrayList<Object>();
		String url = "https://gateway.marvel.com:443/v1/public/characters/1009368/comics?ts=1&apikey=1760c45ca4cabd6e9d4010e56df45bbd&hash=1addd69871606a85cb522d8bd34b6933";
		 URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Default es GET
        con.setRequestMethod("GET");
      /*  //Se agrega Header Request parametros client_id y client secret fijos para tres ambientes
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("client_id", "afbab4eddfe546759b562e2b6cb8cefa");  
        con.setRequestProperty("client_secret", "d38CEAD3Be7246B89143E5e3328E72e9");
        con.setRequestProperty("Authorization", "\"Bearer "+token.getAccessToken()+"\"");
       
        
        System.out.println("\"Bearer "+token.getAccessToken()+"\"");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));  
        
 */
        
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        	System.out.println(inputLine);
        }
        in.close();
        
        ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj;
		Object one = new Object();
		try {
			
			//Se convierte a JSON la respuesta
			actualObj = mapper.readTree(response.toString());
			
			int count = 0;
			//Si el objeto tiene employee se asigna a la entidad de OneSource
		  if(actualObj!=null) {	
			  if(actualObj.get("data")!=null) {	
				  if(actualObj.get("data").get("results")!=null) {
					  while(count<actualObj.get("data").get("results").size()) {
						 
						  
						  if(actualObj.get("data").get("results").get(count).get("creators")!=null) {
							  if(actualObj.get("data").get("results").get(count).get("creators").get("items")!=null) {
								  int items = 0;
								  
								  while(items<actualObj.get("data").get("results").get(count).get("creators").get("items").size()) {
									  	if(actualObj.get("data").get("results").get(count).get("creators").get("items").get(items).get("role").toString().contains("editor")) {
										  one = actualObj.get("data").get("results").get(count).get("creators").get("items").get(items).get("role");
										  list.add(one);
								  		}
									  items++;
								  }
							  }
						  }
						  count++;
					  }
				  }
			  }
			
		  }
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		
		}
		
        
        //print in String
        System.out.println(response.toString());
        
     
        
        return list;
	}

}
