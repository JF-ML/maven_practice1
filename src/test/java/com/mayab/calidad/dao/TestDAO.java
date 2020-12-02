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
		assertThat(num+1,is(fake.list.size()));
		
	}
	@Test
	public void DeleteTest() {
		int num;
		num = fake.list.size();
		fake.deleteAlumno(a1);
		assertThat(num-1,is(fake.list.size()));
	}
	@Test 
	public void UpdateTest() {
		fake.updatePromedio(a1,9.9);
		assertThat(9.9,is(a1.getPromedio()));
	}
	@Test 
	public void numberTest() {
		int n = fake.numberAlumno();
		assertThat(1,is(n));
	}
	@Test
	public void getAllTest() {
		Vector<Alumno> list = fake.getAll();
		assertThat(a1.getId(),is(list.get(list.indexOf(a1)).getId()));
		assertThat(a1.getNombre(),is(list.get(list.indexOf(a1)).getNombre()));
	}
	/*
	addAlumno
	
	deleteAlumno
	
	updatePromedio*/
}
