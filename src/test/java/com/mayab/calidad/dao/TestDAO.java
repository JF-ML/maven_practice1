package com.mayab.calidad.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;

import java.awt.List;
import java.util.HashMap;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class TestDAO {
	Alumno alumno;
	private DAOFake fake = new DAOFake();
	Alumno a1 = new Alumno();
	
	@Before
	public void beforeTest() {
		
		fake.addAlumno(a1);
		
		//fake.AList.put(1, a1);
	}
	
	@Test
	public void AddTest(){
		int num;
		num = fake.list.size();
		fake.addAlumno(alumno);
		assertThat(100,is(fake.list.size()));
		
	}
	@Test
	public void DeleteTest() {
		int num;
		num = fake.list.size();
		fake.deleteAlumno(a1);
		assertThat(100,is(fake.list.size()));
	}
	@Test 
	public void UpdateTest() {
		fake.updatePromedio(a1,9.9);
		assertThat(100,is(a1.getPromedio()));
	}
	@Test 
	public void numberTest() {
		int n = fake.numberAlumno();
		assertThat(100,is(n));
	}
	@Test
	public void getAllTest() {
		Vector<Alumno> list = fake.getAll();
		assertThat(100,is(list.get(list.indexOf(a1)).getId()));
		assertThat(a1.getNombre(),is(list.get(list.indexOf(a1)).getNombre()));
	}
	/*
	addAlumno
	
	deleteAlumno
	
	updatePromedio*/
}
