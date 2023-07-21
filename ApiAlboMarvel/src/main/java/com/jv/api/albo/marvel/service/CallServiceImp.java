package com.jv.api.albo.marvel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jv.api.albo.marvel.api.client.AbstractClient;
import com.jv.api.albo.marvel.api.conf.ApiProperties;
import com.jv.api.albo.marvel.model.ResponseCharacters;
import com.jv.api.albo.marvel.model.ResponseColaborators;
import com.jv.api.albo.marvel.model.ResponseCreator;
import com.jv.api.albo.marvel.model.ResponseSuperHeroe;
import com.jv.api.albo.marvel.model.dto.LCharactersDTO;
import com.jv.api.albo.marvel.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
public class CallServiceImp extends AbstractClient implements CallService {

	@Autowired
	ApiProperties properties;
	
	static Utils utils;

	private static String TS = "?ts=";
	private static String APIKEY = "&apikey=";
	private static String HASH = "&hash=";
	private static String NAMESEARCH = "&name=";
	
	protected CallServiceImp(RestTemplate restTemplate) {
        super(restTemplate);
	}

	@SuppressWarnings("null")
	@Override
	public ResponseColaborators getDataMarvel(String name) {
		ResponseColaborators responseColaborators = new ResponseColaborators();
		String valuekey = properties.getTimes()+""+properties.getApiprikey()+""+properties.getApikey();
		String hashValue = Utils.getMD5(valuekey); 
		  
		String parameters = TS +""+ properties.getTimes() +""+ 
				APIKEY +""+ properties.getApikey() +""+ 
				HASH +""+ hashValue;
		
		String uri = properties.getHost() + properties.getResourcecharacters();
		String uri1 = uri +""+ parameters +""+
				NAMESEARCH +""+ name +"&limit=50"; 
		
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.buildAuthToken());
        ResponseEntity<ResponseSuperHeroe> response = restTemplate.exchange(
        		uri1, HttpMethod.GET, requestEntity , ResponseSuperHeroe.class);
        	
        if (response.getStatusCode().is2xxSuccessful()) {
        	int idnumSuper = response.getBody().data.results.get(0).id; 
            log.info("Successfully user creation: {}", idnumSuper);
            String url = uri +"/"+ idnumSuper +"/comics"+ parameters +"&limit=50";
            
            ResponseEntity<ResponseCreator> response2 = restTemplate.exchange(
            		url, HttpMethod.GET, requestEntity , ResponseCreator.class);
            if (response2.getStatusCode().is2xxSuccessful()) {
            	
                log.info("Successfully Creator: {}", response2.getBody().data.results.get(0).characters.items);

            	List<String> writers = new ArrayList<>();
            	List<String> editors = new ArrayList<>();
            	List<String> colorists = new ArrayList<>();
                response2.getBody().data.results.forEach(a -> a.creators.items.forEach(ac -> {
                	 
                	if (ac.getRole().equals("writer")) {
	                	writers.add(ac.name);
                	}
                	 
                	if (ac.getRole().equals("editor")) {
	                	editors.add(ac.name);
                	}

                	if (ac.getRole().equals("penciller") || ac.getRole().equals("penciller (cover)") ) {
                		colorists.add(ac.name);
                	}
                }));
 
                responseColaborators.setWriters(Utils.clearDuplicate(writers));
            	responseColaborators.setEditors(Utils.clearDuplicate(editors));
            	responseColaborators.setColorists(Utils.clearDuplicate(colorists));
            	  
            }
            responseColaborators.setLast_sync(Utils.dateDay());
            return responseColaborators;
        }
        log.error("Error in user creation - httpStatus was: {}", response.getStatusCode());
        throw new RuntimeException("Error");
		 
	}
 
	 
	@Override
	public ResponseCharacters getDataCharacters(String name) {
		ResponseCharacters responseCharacters = new ResponseCharacters();
		 
		String valuekey = properties.getTimes()+""+properties.getApiprikey()+""+properties.getApikey();
		String hashValue = Utils.getMD5(valuekey); 
		  
		String parameters = TS +""+ properties.getTimes() +""+ 
				APIKEY +""+ properties.getApikey() +""+ 
				HASH +""+ hashValue;
		
		String uri = properties.getHost() + properties.getResourcecharacters();
		String uri1 = uri +""+ parameters +""+
				NAMESEARCH +""+ name +"&limit=50"; 
		
		HttpEntity<Void> requestEntity = new HttpEntity<>(this.buildAuthToken());
        ResponseEntity<ResponseSuperHeroe> response = restTemplate.exchange(
        		uri1, HttpMethod.GET, requestEntity , ResponseSuperHeroe.class);
        if (response.getStatusCode().is2xxSuccessful()) {
        	int idnumSuper = response.getBody().data.results.get(0).id;
        	String nameSuper = response.getBody().data.results.get(0).name;
            log.info("Successfully user creation: {}", idnumSuper);
            String url = uri +"/"+ idnumSuper +"/comics"+ parameters +"&limit=50";
            
            ResponseEntity<ResponseCreator> response2 = restTemplate.exchange(
            		url, HttpMethod.GET, requestEntity , ResponseCreator.class);
            if (response2.getStatusCode().is2xxSuccessful()) {

                List<LCharactersDTO> characters = new ArrayList<>(); 

              response2.getBody().data.results.forEach(a -> { 
            	  a.characters.items.forEach(ac -> {
            		if (!ac.name.equals(nameSuper)) {
            		  List<String> nameComics = new ArrayList<>(); 
                  	  LCharactersDTO character = new LCharactersDTO(); 
                  	    nameComics.add(a.title);
               	      character.Comics = nameComics; 
               	      character.character= ac.name;
                   	  characters.add(character);
                      responseCharacters.setCharacters(characters);	
            		} 
            	  });
 
              }); 
            }
        }      
        responseCharacters.setLast_sync(Utils.dateDay());
		return responseCharacters;
	}

}
