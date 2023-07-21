package com.jv.api.albo.marvel.mongo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter
@Getter
@Table(name = "registros")
public class RegistrosEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	/**
	 * id table.
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * date ejecution.
	 */ 
	private Date date;
	
	/**
	 * requet ejecution.
	 */ 
	private String resource;
}
