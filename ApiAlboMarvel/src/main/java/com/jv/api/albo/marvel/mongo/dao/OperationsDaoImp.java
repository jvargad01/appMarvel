package com.jv.api.albo.marvel.mongo.dao;
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jv.api.albo.marvel.mongo.entity.RegistrosEntity;
import com.jv.api.albo.marvel.mongo.entity.SuperHeroeEntity;
import com.jv.api.albo.marvel.mongo.model.RequestRegister;
import com.jv.api.albo.marvel.mongo.model.ResponseRegiste;
import com.jv.api.albo.marvel.mongo.model.ResponseSuperHeroe;
import com.jv.api.albo.marvel.mongo.model.RespoonseLogs;
import com.jv.api.albo.marvel.mongo.repository.RegistrosRepository;
import com.jv.api.albo.marvel.mongo.repository.SuperHeroeRepository;
import com.jv.api.albo.marvel.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional
public class OperationsDaoImp implements OperationsDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
    private SuperHeroeRepository superHeroe;
	
	@Autowired
    private RegistrosRepository registrosEntity;
    
	private Utils utils;
	
	@Override
	public ResponseRegiste insertRegistro(RequestRegister request) {
		ResponseRegiste response = new ResponseRegiste();
		LocalDateTime datetime = LocalDateTime.now();
		
		String qry = "INSERT INTO registros (date, resource) values (?, ?)";
		int result = jdbcTemplate.update(
				qry,  
				datetime,
				request.getResource()
				);
		if(result > 0) {
			response.setStatus("OK");
			response.setMessage("Register sussefult!");
			log.info("Register sussefult.");
		} else {
			response.setStatus("ERROR");
			response.setMessage("Error Register!");
			log.error("Error Register!!");
		}
		return response;
	}

	@Override
	public List<ResponseSuperHeroe> retriveSuperHereo() {
		// TODO Auto-generated method stub
		List<SuperHeroeEntity> lsuperHeroe = superHeroe.findAll();
		List<ResponseSuperHeroe> response = new ArrayList<>();
		lsuperHeroe.forEach(a -> {
			ResponseSuperHeroe superHeroe = ResponseSuperHeroe.builder()
					.claveSuperHeroe(a.getClavesuperheroe())
					.name(a.getNombre())
					.build();  
			
			response.add(superHeroe);
		}); 
		return response;
	}

	@Override
	public List<RespoonseLogs> retirveLRegister() {
		
		List<RegistrosEntity> lregister = registrosEntity.findAll();
		List<RespoonseLogs> responseslog = new ArrayList<>();
		
		lregister.forEach(a -> {
			RespoonseLogs responselog = new RespoonseLogs();
			responselog.setFecha(utils.formatDateDay(a.getDate()));
			responselog.setResource(a.getResource());
			responseslog.add(responselog);
		});
		
		return responseslog;
	}

}
