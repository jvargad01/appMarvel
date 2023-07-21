package com.jv.api.albo.marvel.service;

import com.jv.api.albo.marvel.model.ResponseCharacters;
import com.jv.api.albo.marvel.model.ResponseColaborators; 

public interface CallService {
 
	ResponseColaborators getDataMarvel(String name);
	
	ResponseCharacters  getDataCharacters(String name);
  
}
