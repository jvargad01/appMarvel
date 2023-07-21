package com.jv.api.albo.marvel.api.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiProperties {

	@Value("${marvel.config.host}")
	private String host; 
	
	@Value("${marvel.url-retrivecharacters}")
    private String resourcecharacters;
	
	@Value("${marvel.url-retrivecomics}")
    private String resourcecomics;
	
	@Value("${marvel.url-retrivecreator}")
    private String resourcecreator;

	@Value("${marvel.url-retriveevents}")
    private String resourceevents;

	@Value("${marvel.url-retriveseries}")
    private String resourceseries;

	@Value("${marvel.url-retrivestories}")
    private String resourcestories;

	@Value("${marvel.apikey}")
    private String apikey;

	@Value("${marvel.apiprikey}")
    private String apiprikey;

	@Value("${marvel.times}")
    private String times;
	
	@Value("${marvel.times}")
    private String namesearch;

	@Value("${marvel.search.ironman}")
    private String searchironman;

	@Value("${marvel.search.capamerica}")
    private String searchcapamerica;

	@Value("${header.config.agent.method}")
    private String method;
	
	@Value("${header.config.agent.name}")
    private String headerName;
			
    @Value("${header.config.agent.value}")
    private String headerValue;
	
}
