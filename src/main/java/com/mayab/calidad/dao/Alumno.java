package com.mayab.calidad.dao;

public class Alumno {
	
	private int id;
	
	private String nombre;
	
	private String email;
	
	public int edad;
	
	public double promedio;
	
	public Alumno() {
		this.id=1;
		this.nombre="john";
		this.email= "xxx@.com";
		this.edad = 18;
		this.promedio = 0.0;
	}
	
	public Alumno(int n) {
		this.id=n;
		this.email= "xxx@.com";
		this.edad = 18;
		this.promedio = 0.0;
	}
	
	public Alumno(int id,String nombre,String email,int edad,double promedio) {
		this.id=id;
		this.nombre=nombre;
		this.email= email;
		this.edad = edad;
		this.promedio = promedio;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
}
