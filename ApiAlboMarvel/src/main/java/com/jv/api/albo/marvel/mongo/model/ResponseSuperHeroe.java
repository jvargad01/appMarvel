package com.jv.api.albo.marvel.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseSuperHeroe {
  
	private String claveSuperHeroe;
	
	private String name;
	
	
}
