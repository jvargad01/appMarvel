package com.jv.api.albo.marvel.mongo.entity;

import java.io.Serializable;

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
@Table(name = "superheroe")
public class SuperHeroeEntity implements Serializable {

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
	 * clave superheroe.
	 */ 
	private String clavesuperheroe;
	
	/**
	 * nombre superheroe.
	 */ 
	private String nombre;
}
