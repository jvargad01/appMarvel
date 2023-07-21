package com.jv.api.albo.marvel.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoriesDTO {

	public int available;
    public String collectionURI;
    
    public List<ItemsDTO> items;

	public int returned;
    
}
