package com.jv.api.albo.marvel.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class RequestRegister {
	  
  @JsonProperty("resource")
  private String resource; 
}
