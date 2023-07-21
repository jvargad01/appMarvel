package com.jv.api.albo.marvel.mongo.service;

import java.util.List;

import com.jv.api.albo.marvel.mongo.model.RequestRegister;
import com.jv.api.albo.marvel.mongo.model.ResponseRegiste;
import com.jv.api.albo.marvel.mongo.model.ResponseSuper;
import com.jv.api.albo.marvel.mongo.model.RespoonseLogs;

public interface CallServiceMongo {

	ResponseRegiste saveMove(RequestRegister request);
	
	
	ResponseSuper retriveSuperHeroe();
	
	List<RespoonseLogs> retriveLogs();
	
	 
}
