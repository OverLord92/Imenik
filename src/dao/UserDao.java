package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;


public class UserDao {
	
	/**
	 * if the user passes the authentication call this method to add user to
	 * database
	 */
	public static void addUserToDatabase(User user, Connection connection) throws SQLException {
		
		try (
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO users(userName, userPassword, phone_number, email_address, active)" 
				+ " VALUES(?, ?, ?, ?, ?)");
				) {

			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPassword());
			stmt.setString(3, user.getUserPhoneNumber());
			stmt.setString(4, user.getUserEmailAddress());
			stmt.setInt(5, 1);
			
			stmt.executeUpdate();
			
		} 

	}
	
	
	/**
	 * if the user passes the authentication call this method to add user to
	 * database
	 */
	public static void deleteUserFromDatabase(String userName, Connection connection) throws SQLException {
		
		try (
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM users WHERE userName=?");
				) {

			stmt.setString(1, userName);			

			stmt.executeUpdate();
			
		} 

	}
	
	
	public static void updateUserInDatabase(User user, Connection connection) {
		
		try (
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE users SET userPassword=?, phone_number=?, email_address=?   WHERE userName = ?");
				) {

			stmt.setString(1, user.getUserPassword());
			stmt.setString(2, user.getUserPhoneNumber());
			stmt.setString(3, user.getUserEmailAddress());
			stmt.setString(4, user.getUserName());
	
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	
	
	public static void setUserPicture(User user, String linkToImage, Connection connection){
		
		try (
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE users SET user_image=? WHERE userName = ?");
				) {

			
			stmt.setString(1, linkToImage);
			stmt.setString(2, user.getUserName());
	
			stmt.executeUpdate();
			
			user.setLinkToImage(linkToImage);
	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	
	public static int getNextAvailableUserId() {

		int nextAvailableUserId = 0;

		try (	
				Connection connection = MyConnection.getConnection();
				Statement stmt = connection.createStatement();
				) {
			ResultSet result = stmt.executeQuery("SELECT MAX(user_id) FROM users;");

			if (result.next()) {
				nextAvailableUserId = Integer.parseInt(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nextAvailableUserId + 1;

	}

	/**
	 * return an array list with userNames to check if a userName already exists
	 * in the database
	 * 
	 * @throws SQLException
	 */
	public static ArrayList<String> getUserNames() throws SQLException {
		ArrayList<String> userNames = new ArrayList<>();

		try (
				Connection connection = MyConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT userName FROM users");) {

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				userNames.add(resultSet.getString(1));
			}

		}

		return userNames;
	}

	
	public static boolean doesUserExists(String userName) throws SQLException {

		ArrayList<String> userNames = getUserNames();

		return userNames.contains(userName);

	}
	

	public static String getUsersPassword(String userName, Connection connection) throws SQLException {

		String userPassword = null;
		ResultSet result = null;
		
		try (
				PreparedStatement stmt = connection.prepareStatement("SELECT userPassword FROM users WHERE userName=?");) {
			stmt.setString(1, userName);

			result = stmt.executeQuery();

			result.next();

			userPassword = result.getString(1);

		}

		return userPassword;
	}

	
	public static String getUsersId(String userName, Connection connection) throws SQLException {

		String useriD = null;
		ResultSet result = null;
		try (
				PreparedStatement stmt = connection.prepareStatement("SELECT user_id FROM users WHERE userName=?");) {
			stmt.setString(1, userName);

			result = stmt.executeQuery();

			if(result.next()){
				useriD = result.getString(1);
			}
		}

		return useriD;
	}
	
	
	
	public static User getUser(String userName, Connection connection) throws SQLException {

		User user = null;
		ResultSet result = null;
		
		try (
				
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE userName=?");) {
			stmt.setString(1, userName);

			result = stmt.executeQuery();

			result.next();

			String userId = result.getString(1);
			String userPassword = result.getString(3);
			String userPhoneNumber = result.getString(4);
			String email_address = result.getString(5);
			String userImage = result.getString(6);
			
			user = new User(userName, userPassword, userPhoneNumber, email_address, userImage);
			user.setUserId(userId);
			
		}

		return user;
	}
	
	public static ArrayList<User> getAllUsers() throws SQLException{
		
		Connection connection = MyConnection.getConnection();
		
		ArrayList<User> users = new ArrayList<>();
		
		ArrayList<String> userNames = getUserNames();
		
		for(int i = 0; i < userNames.size(); i++){
			
			users.add(getUser(userNames.get(i), connection));		
		
		}
		
		return users;	
		
	}
}
