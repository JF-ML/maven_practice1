package com.mayab.calidad.dao;

import java.sql.DriverManager;
import java.util.Vector;
import java.sql.*;
public class AlumnoOracle implements DAO {

	
	public Connection getConnection() {
		 Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","travis","travis");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	}
	
	@Override
	public boolean addAlumno(Alumno n) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"insert into ALUMNO(ID,NOMBRE,EDAD,PROMEDIO,EMAIL) values (?,?,?,?,?)");
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
					"Delete From ALUMNO Where ID = ?");
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
					"update ALUMNO set PROMEDIO  = ? Where ID = ?");
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
			ResultSet result = statement.executeQuery("SELECT COUNT(*) AS count FROM ALUMNO");
			
			while(result.next()){
				n = result.getInt("count");
				
			}
			
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return n;
	}

	@Override
	public Vector<Alumno> getAll() {
		Vector<Alumno> list = new Vector<Alumno>();
		try {
			Connection con = getConnection();
			Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery("SELECT * FROM ALUMNO");
			result.last();
			int size = result.getRow();
			result.first();
			
            
            for(int i = 0; i < size; i ++) {
            	list.add(new Alumno());
	            	if(result.next())
	            	{
		            	list.get(i).setId(result.getInt("ID"));
		            	list.get(i).setNombre(result.getString("NOMBRE"));
		            	list.get(i).setEdad(result.getInt("EDAD"));
		            	list.get(i).setPromedio(result.getFloat("PROMEDIO"));
		    			list.get(i).setEmail(result.getString("EMAIL"));
		    			
	            	}
        	}
			
			con.close();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return list;
	}

}
