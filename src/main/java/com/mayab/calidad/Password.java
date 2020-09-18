package com.mayab.calidad;

public class Password {
	String value ="";
	
	Password(){
		
	}
	public String getValue() {
		if(value.length()>12) {
			return "Error,maximo 12 caracteres";
		}
		return value;
	}
}
