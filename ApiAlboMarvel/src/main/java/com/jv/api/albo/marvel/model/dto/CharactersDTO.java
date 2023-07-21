package com.jv.api.albo.marvel.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharactersDTO {
    public int available;
    
	public String collectionURI;
    
	public List<ItemDTO> items;
	
	public int returned;
}
