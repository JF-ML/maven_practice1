package com.mayab.calidad.dao;

import java.sql.Connection;
import java.util.Vector;

public class DAOFake implements DAO {

	Vector<Alumno> list = new Vector<Alumno>();
	public DAOFake() {
	
	}
	
	@Override
	public boolean addAlumno(Alumno n) {
		// TODO Auto-generated method stub
		//AList.put(n.getId(), n);
		list.add(n);
		return true;
	}

	@Override
	public boolean deleteAlumno(Alumno n) {
		// TODO Auto-generated method stub
		
		list.remove(list.indexOf(n));
		return true;
	}

	@Override
	public boolean updatePromedio(Alumno n,double promedio) {
		// TODO Auto-generated method stub
		n.setPromedio(promedio);
		list.set(list.indexOf(n),n);
		
		return true;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numberAlumno() {
		
		return list.size();
	}

	@Override
	public Vector<Alumno> getAll() {
		// TODO Auto-generated method stub
		return list;
	}



}
