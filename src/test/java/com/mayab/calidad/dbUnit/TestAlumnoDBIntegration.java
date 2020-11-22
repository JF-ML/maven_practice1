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
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;



public class TestAlumnoDBIntegration extends DBTestCase{

	
	public TestAlumnoDBIntegration(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "hr");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "hr");
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
		
	}
	@Test
	public void test() {
		//Fetch database data after executing your code
		
		AlumnoOracle alumno = new AlumnoOracle();
		Alumno a1 = new Alumno(9);
		a1.setNombre("Jorge");
		a1.setPromedio(9.9);
		alumno.addAlumno(a1);
				try{
					IDataSet databaseDataSet = getConnection().createDataSet();
					ITable actualTable = databaseDataSet.getTable("alumnos");
					//Leemos los datos del archivo esperado
					//InputStream xmlFile =  getClass().getResourceAsStream("/insert_result.xml");
					IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
					ITable expectedTable = expectedDataSet.getTable("alumnos");
					// Assert actual database table match expected table
					Assertion.assertEquals(expectedTable, actualTable);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}

	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		//InputStream xmlFile = getClass().getResourceAsStream("/alumno_init-xml");
		
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}
	}



