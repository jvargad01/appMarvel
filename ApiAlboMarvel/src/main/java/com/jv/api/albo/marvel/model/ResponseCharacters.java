package com.jv.api.albo.marvel.model;

import java.util.List;

import com.jv.api.albo.marvel.model.dto.LCharactersDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ResponseCharacters {

	public String last_sync;

	public List<LCharactersDTO> characters; 
	
}
