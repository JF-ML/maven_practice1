package com.mayab.calidad;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculadora2 {

	static Calculadora miCalculadora; 
	
	@BeforeClass
	public static void setup() {
		System.out.println("Before test-->");
		miCalculadora = new Calculadora();
	}
	
	@Test
	public void SumaPositivoTest() {
		float operando1=10;
		float operando2 =20;
		float expResult =30;
		float result =-1;
		
		result = miCalculadora.suma(operando1,operando2);
		assertEquals(expResult,result,0);
	}

	@Test
	public void RestaPositivos() {
		float operando1=30;
		float operando2 =50;
		float expResult =-20;
		float result =-1;
		
		result = miCalculadora.resta(operando1,operando2);
		assertThat(result,is(expResult));
	}
	@Test
	public void Division1() {
		float operando1=20;
		float operando2 =2;
		float expResult =10;
		float result =-1;
		
		result = miCalculadora.division(operando1, operando2);
		assertThat(result,is(expResult));
	}
	@Test
	public void Division2() {
		float operando1=2;
		float operando2 =0;
		float expResult =0;
		float result =-1;
		
		result = miCalculadora.division(operando1, operando2);
		assertThat(result,is(expResult));
	}
	
	@After
	public void despues() {
		System.out.println("Despues de prueba");
	}
	
	@AfterClass
	public static void fin() {
		System.out.println("Final de pruebas");

	}
}
