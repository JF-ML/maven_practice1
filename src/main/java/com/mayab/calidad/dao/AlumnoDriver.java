package com.mayab.calidad.dao;

public class AlumnoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno();
		alumno.getConnection();
		
		
		alumno.deleteAlumno(a1);
	}

}
