package com.mayab.calidad.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Vector;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matcher.*;
import static org.mockito.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.doubles.Dependency;

public class TestDAOMock {

	private DAOFake fake;
	private Alumno alumno;
	@Before
	public void setUpMock() {
		fake = mock(DAOFake.class);
		when(fake.list.add(alumno)).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				
				
				return true;
			}
		});
	}
	public void setUpVector() {
		when(fake.list).thenReturn(new Vector<Alumno>());
	}
	
	@Test
	public void Addtest() {
		int num = fake.list.size();
		fake.list.add(alumno);
		
		assertThat(num+1,is(fake.list.size()));
	}
	
	
	

}
	
