package com.jv.api.albo.marvel.model;

import com.jv.api.albo.marvel.model.dto.DataDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSuperHeroe {
	
	public int code;
	
	public String status;
	
	public String copyright;
	
	public String attributionText;
	
	public String attributionHTML;
	
	public String etag;
	
	public DataDTO data;
}
