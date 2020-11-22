package com.mayab.calidad.dao;

public class AlumnoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(7);
		Alumno a2 = new Alumno(8);
		Alumno a3 = new Alumno(9);
		alumno.getConnection();
		
		alumno.addAlumno(a1);
		alumno.addAlumno(a2);
		alumno.addAlumno(a3);
		alumno.updatePromedio(a2, 9.9);
		//alumno.deleteAlumno(a1);
	}

}
