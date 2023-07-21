package com.jv.api.albo.marvel.mongo.dao;

import java.util.List;

import com.jv.api.albo.marvel.mongo.model.RequestRegister;
import com.jv.api.albo.marvel.mongo.model.ResponseRegiste;
import com.jv.api.albo.marvel.mongo.model.ResponseSuperHeroe;
import com.jv.api.albo.marvel.mongo.model.RespoonseLogs;

public interface OperationsDao {

	ResponseRegiste insertRegistro(RequestRegister request);
	
	List<ResponseSuperHeroe> retriveSuperHereo();
	
	 List<RespoonseLogs> retirveLRegister();
	 
}
