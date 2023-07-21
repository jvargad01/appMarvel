package com.jv.api.albo.marvel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jv.api.albo.marvel.model.RequestSuperHeroe;
import com.jv.api.albo.marvel.model.ResponseCharacters;
import com.jv.api.albo.marvel.model.ResponseColaborators;
import com.jv.api.albo.marvel.mongo.model.RequestRegister;
import com.jv.api.albo.marvel.mongo.model.ResponseRegiste;
import com.jv.api.albo.marvel.mongo.model.ResponseSuper;
import com.jv.api.albo.marvel.mongo.model.RespoonseLogs;
import com.jv.api.albo.marvel.mongo.service.CallServiceMongo;
import com.jv.api.albo.marvel.service.CallService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/domain/services/marvel")
public class Controller {

	@Autowired
	private CallService callService;

	@Autowired
	private CallServiceMongo serviceMongo;
	
	
	@RequestMapping(value = "/retrive/colaborators", method=RequestMethod.POST)
	public ResponseEntity<?> retriveColaborators(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestSuperHeroe request){
		log.info("request: {}" , request.getName());
		ResponseColaborators json = callService.getDataMarvel(request.getName());
		
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrive/characters", method=RequestMethod.POST)
	public ResponseEntity<?> retriveCharacters(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestSuperHeroe request){
		log.info("request: {}" , request.getName());
		ResponseCharacters json = callService.getDataCharacters(request.getName());
		
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/register/logs", method=RequestMethod.POST)
	public ResponseEntity<?> registerLogs(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestRegister request){
		
		ResponseRegiste response = serviceMongo.saveMove(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrive/logs", method=RequestMethod.POST)
	public ResponseEntity<?> retrivelogs(HttpServletRequest req, 
			@RequestHeader HttpHeaders header){
		
		List<RespoonseLogs> response = serviceMongo.retriveLogs();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrive/superheroe", method=RequestMethod.POST)
	public ResponseEntity<?> retriveSuperheroe(HttpServletRequest req, 
			@RequestHeader HttpHeaders header){
		
		ResponseSuper response = serviceMongo.retriveSuperHeroe();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
