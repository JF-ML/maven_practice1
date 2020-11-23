package com.mayab.calidad.dao;


import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;

public interface DAO {
	
	
	public boolean addAlumno(Alumno n);
	public boolean deleteAlumno(Alumno n);
	public boolean updatePromedio(Alumno n,double promedio);
	
	
	public Connection getConnection();
}
