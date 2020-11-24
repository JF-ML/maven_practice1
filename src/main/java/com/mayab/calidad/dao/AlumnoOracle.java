package com.mayab.calidad.dao;

import java.sql.DriverManager;
import java.sql.*;
public class AlumnoOracle implements DAO {

	
	public Connection getConnection() {
		 Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbunit","dbunit");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	}
	
	@Override
	public boolean addAlumno(Alumno n) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"insert into alumno(id,nombre,edad,promedio,email) values (?,?,?,?,?)");
			ps.setInt(1,n.getId());
			ps.setString(2,n.getNombre());
			ps.setInt(3,n.getEdad());
			ps.setDouble(4,n.getPromedio());
			ps.setString(5,n.getEmail());
			
			int status = ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public boolean deleteAlumno(Alumno n) {
		// TODO Auto-generated method stub
		try {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"Delete From Alumno Where id = ?");
			ps.setInt(1,n.getId());
			
			
			int status = ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public boolean updatePromedio(Alumno n, double promedio) {
		try {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"update alumno set promedio  = ? Where id = ?");
			ps.setDouble(1,promedio);
			ps.setInt(2,n.getId());
			
			
			int status = ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public int numberAlumno() {
		// TODO Auto-generated method stub
		int n = 0;
		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT COUNT(*) AS count FROM alumno");
			
			while(result.next()){
				n = result.getInt("count");
				
			}
			
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return n;
	}

}
