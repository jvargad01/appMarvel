package com.jv.api.albo.marvel.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
  
	public static String getMD5(String input) { 
	  String md5 = DigestUtils.md5Hex(input); 
	  return md5;
	}
	
	public static List<String> clearDuplicate(List<String> listWithDuplicates){
		// construye un conjunto a partir de elementos de la lista
        Set<String> set = new LinkedHashSet<>(listWithDuplicates);
 
        // construir una nueva lista a partir de un conjunto e imprimirla
        List<String> listWithoutDuplicates = new ArrayList<>(set);
        return listWithoutDuplicates;
	}
	
	public static String dateDay() {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		 
        return dateFormat.format(new Date());
        
	}
	
	public static String formatDateDay(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		 
        return dateFormat.format(date);
        
	}
	
}
