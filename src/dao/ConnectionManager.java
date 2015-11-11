package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "gEdOrA92";
	private static final String CONN_STRING = "jdbc:mysql://localhost/imenik";
	
	private Connection connection = null;
	
	private ConnectionManager(){
	}
	
	public static ConnectionManager getInstance(){
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection(){

		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			System.err.println("Driver class not found");
		}
		
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch(SQLException ex) {
			System.err.println(ex);
			return false;
		}
	}
	
	public Connection getConnection(){
		if(connection == null){
			if(openConnection()){
				System.out.println("Connection established.");
				return connection;
			}else{
				return null;
			}
		}
		return connection;
	}
	
	public void close(){
		try{
			connection.close();
			connection = null;
		}catch(Exception ex){
		}
	}	
}