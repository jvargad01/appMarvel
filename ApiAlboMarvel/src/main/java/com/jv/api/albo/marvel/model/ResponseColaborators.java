package com.jv.api.albo.marvel.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ResponseColaborators {

	 public String last_sync;

	 public List<String> writers;
	 
	 public List<String> editors; 
	 
	 public List<String> colorists;
}
