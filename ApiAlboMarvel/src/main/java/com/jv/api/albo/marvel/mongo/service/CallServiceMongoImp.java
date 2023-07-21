package com.jv.api.albo.marvel.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.api.albo.marvel.mongo.dao.OperationsDao;
import com.jv.api.albo.marvel.mongo.model.RequestRegister;
import com.jv.api.albo.marvel.mongo.model.ResponseRegiste;
import com.jv.api.albo.marvel.mongo.model.ResponseSuper;
import com.jv.api.albo.marvel.mongo.model.ResponseSuperHeroe;
import com.jv.api.albo.marvel.mongo.model.RespoonseLogs;

@Service
public class CallServiceMongoImp implements CallServiceMongo {

	@Autowired
	private OperationsDao dao;
	
	@Override
	public ResponseRegiste saveMove(RequestRegister request) {
		ResponseRegiste response =  dao.insertRegistro(request);
		return response;
	}

	@Override
	public ResponseSuper retriveSuperHeroe() {
		ResponseSuper superheroe = new ResponseSuper();
		List<ResponseSuperHeroe> response = dao.retriveSuperHereo();
		superheroe.setResponse(response);
		
		return superheroe;
	}

	@Override
	public List<RespoonseLogs> retriveLogs() {
		return dao.retirveLRegister();
	}

}
