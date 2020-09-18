package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;

public class TestDependency {

	private Dependency dependency;
	@Before
	public void setupMocks() {
		dependency = mock(Dependency.class);
		//dependency = new Dependency(new Subdependency());
	}
	@Test
	public void test() {
		when(dependency.getClassName()).thenReturn("miNombre");
		
		assertThat(dependency.getClassName(),is("miNombre"));
		//assertNull(dependency.getClassName());
		//assertNull(dependency.getClassNameUpperCase());
		//assertNull(dependency.getSubdependencyClassName());
	}
	@Test
	public void another() {
		when(dependency.getClassName()).thenReturn("Zoro");
		assertThat(dependency.getClassName(),is("Zoro"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	
	public void testThrown() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	@Test
	public void testAdd(){
		when(dependency.addTwo(anyInt())).thenReturn(5);
		assertThat(dependency.addTwo(1),is(5));
		assertThat(dependency.addTwo(5),is(5));
	}
	
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				int arg = (Integer) invocation.getArguments() [0];
				return arg + 20;
			}
		});
		assertThat(dependency.addTwo(10),is(30));
	}
}
