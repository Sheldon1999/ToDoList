package com.toDoList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemDbUtil {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
		String dbName = "toDoDatabase";
		String dbUserName = "toDoAdmin";
		String dbPassword = "toDoAdmin";
		String dbUrl = "jdbc:mysql://localhost:3306/";
		Connection conn = DriverManager.getConnection(dbUrl + dbName, 
                dbUserName,dbPassword); 
		return conn;
		
	}
	
	private void closeConnection(Connection conn, Statement stmt, ResultSet rst){
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rst != null){
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public String checkCredentials(String email, String password){
		
		String areValid = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		
		try{
			
			conn = getConnection();
			
			if(!isAlreadyRegistered(email, conn)){
				areValid = "not registered";
			}
			else{
				String sqlStatement = "select * from users where email = binary '" + email + "' and password = binary '" + password + "'";
				
				stmt = conn.createStatement();
				rst = stmt.executeQuery(sqlStatement);
				if(rst.next()){
					areValid = "valid";
				}
				else{
					areValid = "inValid";
				}

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			closeConnection(conn, stmt, rst);
		}
		
		return areValid;
		
	}
	
	public void addItem(item theItem, String email){
		
		Connection conn = null;
		String tableName = getTableName(email);
		try {
			conn = getConnection();
		
			String label = theItem.getLabel();
			String date = theItem.getDate();
			String time = theItem.getTime();
			
			String sqlStatement = "insert into " + tableName
					+ " (label, date, time)"
					+ "values (?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sqlStatement);
			
			stmt.setString(1, label);
			stmt.setString(2, date);
			stmt.setString(3, time);
			
			stmt.execute();
			
			closeConnection(conn, stmt, null);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<item> getItems(String email){
		
		List<item> items = new ArrayList<>();
		
		String tableName = getTableName(email);
		
		Connection conn = null;
		try {
			conn = getConnection();
			
			String sqlStatement = "select * from " + tableName;
			Statement stmt = conn.createStatement();
			
			ResultSet rst = stmt.executeQuery(sqlStatement);
			
			while(rst.next()){
				
				// retrieve data from result set row
				int id = rst.getInt("id");
				String label = rst.getString("label");
				String date = rst.getString("date");
				String time = rst.getString("time");
				
				item theItem = new item(id, label, date, time);
				
				items.add(theItem);
			}
			
			closeConnection(conn, stmt, rst);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
		
	}
	
	private String getTableName(String email){
		
		int pos1 = email.indexOf("@");
		
		int pos2 = email.indexOf(".",pos1);
		
		String tableName = email.substring(0, pos1) + "_" + email.substring(pos1+1, pos2);
		
		return tableName;
	}
	
	private void createTable(Connection conn, String email){
		
		Statement smt = null;
		
		String tableName = getTableName(email);
		
		try {
			smt = conn.createStatement();
			String sql = "CREATE TABLE " + tableName + " " +
	                   "(id INTEGER NOT NULL AUTO_INCREMENT, " +
	                   " label VARCHAR(50), " + 
	                   " date VARCHAR(12), " + 
	                   " time VARCHAR(10), " + 
	                   " PRIMARY KEY ( id ))"; 

			smt.executeUpdate(sql);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      
	}
	
	private boolean isAlreadyRegistered(String email, Connection conn){
		
		String sqlStatement = "select * from users where email = binary '" + email + "'";
		
		Statement stmt = null;
		
		ResultSet rst = null;
		
		Boolean isFound = false;
		
		try {
			stmt = conn.createStatement();
			rst = stmt.executeQuery(sqlStatement);
			if(rst.next()){
				isFound = true;
			}
			else{
				isFound = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isFound;
		
	}

	public String addUser(String email, String password) {
		
		Connection conn = null;
		
		String userAdded = null;
		
		try {
			conn = getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isAlreadyRegistered(email, conn)){
			userAdded =  "already registered";
		}
		
		else{
			
			try {
				
				String sqlStatement = "insert into users "
						+ "(email, password)"
						+ "values (?, ?)";
				
				PreparedStatement stmt = conn.prepareStatement(sqlStatement);
				
				stmt.setString(1, email);
				stmt.setString(2, password);
				
				stmt.execute();
				
				createTable(conn, email);
			      
			  	userAdded = "user registered";
				
				closeConnection(conn, stmt, null);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return userAdded;
		
	}

}
