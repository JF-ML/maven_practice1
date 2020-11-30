package com.mayab.calidad.dbUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.dao.Alumno;
import com.mayab.calidad.dao.AlumnoOracle;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.InputStream;
import java.util.Vector;

import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;



public class TestAlumnoDBIntegrationInsert extends DBTestCase{

	
	public TestAlumnoDBIntegrationInsert(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "travis");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "travis");
		
		
	}

	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDatabaseConnection connection= getConnection();
		 
		try {
			DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
		}finally {
			connection.close();
		}
		
	}
	@After
	public void tearDown() throws Exception{
		
	}/*
	@Test
	public void testInsert() throws Exception {
		//Fetch database data after executing your code
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(9);
		
		a1.setNombre("Jorge");
		a1.setPromedio(9.9);
		
		alumno.addAlumno(a1);

		IDataSet databaseDataSet = getConnection().createDataSet();			
		ITable actualTable = databaseDataSet.getTable("ALUMNO");
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("ALUMNO");

		Assertion.assertEquals(expectedTable, actualTable);
		
		connection.close();		

	}*/
	
	
	@Test
	public void testInsert2() throws Exception {
		//Fetch database data after executing your code
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(9);
		a1.setNombre("Jorge");
		a1.setPromedio(9.9);
		int n =connection.getRowCount("ALUMNO") + 1;
		alumno.addAlumno(a1);
		assertEquals(n, connection.getRowCount("ALUMNO"));	
		
		
		
		connection.close();		

	}
	@Test
	public void testDelete() throws Exception{
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(9);
		Alumno a2 = new Alumno(10);
		a1.setNombre("Jorge");
		a1.setPromedio(9.9);
		alumno.addAlumno(a1);
		alumno.addAlumno(a2);
		int n =connection.getRowCount("ALUMNO")-1;
		
		
		alumno.deleteAlumno(a2);
		IDataSet databaseDataSet = getConnection().createDataSet();			
		ITable actualTable = databaseDataSet.getTable("ALUMNO");
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("ALUMNO");
		// Assert actual database table match expected table
		
		//Assertion.assertEquals(expectedTable, actualTable);
		assertEquals(n, connection.getRowCount("alumno"));	
		
		
		
		connection.close();
	}
	
	@Test
	public void testUpdate() throws Exception {
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(8);
		a1.setNombre("Jose");
		a1.setPromedio(8.5);
		
		alumno.addAlumno(a1);
		
		alumno.updatePromedio(a1, 9.9);
		
		
		IDataSet databaseDataSet = getConnection().createDataSet();			
		ITable actualTable = databaseDataSet.getTable("ALUMNO");
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/update_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("ALUMNO");
		// Assert actual database table match expected table
		Assertion.assertEquals(expectedTable, actualTable);
		
		connection.close();	
	}
	
	@Test
	public void testNumber() throws Exception {
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		int n = alumno.numberAlumno();
		
		
		
		assertEquals(n, connection.getRowCount("ALUMNO"));
		
		connection.close();	
	}
	@Test
	public void testGetAll() throws Exception {
		IDatabaseConnection connection= getConnection();
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(9);
		a1.setNombre("Jorge");
		a1.setPromedio(9.9);
		
		alumno.addAlumno(a1);
		
		IDataSet databaseDataSet = getConnection().createDataSet();			
		Vector<Alumno> actualTable =  alumno.getAll();
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("ALUMNO");
		// Assert actual database table match expected table
		
	
		for(int i = 0; i<actualTable.size();i++) {
			
			assertEquals(expectedTable.getValue(i, "ID"), Integer.toString(actualTable.get(i).getId()));
			assertEquals(expectedTable.getValue(i, "NOMBRE"), actualTable.get(i).getNombre());
			
		}
		
		connection.close();	
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		//InputStream xmlFile = getClass().getResourceAsStream("/alumno_init-xml");
		
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}
	}



