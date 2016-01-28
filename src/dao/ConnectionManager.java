package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** ConnectionManager class implemented using Singleton pattern */
public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	// arguments used to connect to database
	private static final String USERNAME = "root";
	private static final String PASSWORD = "gEdOrA92";
	private static final String CONN_STRING = "jdbc:mysql://localhost/imenik";
	
	private Connection connection = null;

	/** private No-argument constructor */
	private ConnectionManager(){
	}
	
	/** Returns an instance of ConnectionManager*/
	public static ConnectionManager getInstance(){
		// if an instance instance doesn't exist invoke the constructor
		if(instance == null) {
			instance = new ConnectionManager();
		}
		
		return instance;
	}
	
	/** Open connection with database. Returns true if a connection is establishe.
	 *  Otherwise returns false. */
	private boolean openConnection(){

		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			System.err.println("Driver class not found");
		}
		
		try {
			// gets a connection with the database
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			// return true if the connection is established successfully 
			return true;
		} catch(SQLException ex) {
			System.err.println(ex);
			return false;
		}
	}
	
	/** Invoked by the program to get a connection with the database */
	public Connection getConnection(){
		// if the connection variable is null create a connection
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
	
	/** Closes the private Connection of the ConnectionManager  */
	public void close(){
		try{
			connection.close();
			connection = null;
		}catch(Exception ex){
		}
	}	
}