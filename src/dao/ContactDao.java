package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Contact;

public class ContactDao {

	/** Get the users contact using the user's id */
	public static ArrayList<Contact> getUserContacts(String user_id){

		ArrayList<Contact> userContacts = new ArrayList<>();
		ResultSet result = null;

		ConnectionManager cm = ConnectionManager.getInstance();
		Connection connection = cm.getConnection();
		
		try (
				// get all contacts of a specific user from the database using the user_id 
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contacts WHERE user_id=?");) {
			stmt.setString(1, user_id);

			result = stmt.executeQuery();

			// create an Contact object for every user's contact in the database and add it to the userContacts list
			while (result.next()) {
				Contact contact = new Contact(result.getString(3), result.getString(4), result.getString(5));
				userContacts.add(contact);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userContacts;

	}

	/** Used to add an contact with specific user_id to database */
	public static void addContactToDatabase(String user_id, Contact contact, Connection connection) {

		try ( 
				PreparedStatement stmt = connection.prepareStatement(
						"INSERT INTO contacts (user_id, contactName, contactNumber, email_address) VALUES (?, ?, ?, ?)");) {

			// set strings to the PreparedStatement
			stmt.setString(1, user_id);
			stmt.setString(2, contact.getContactName());
			stmt.setString(3, contact.getContactPhoneNumber());
			stmt.setString(4, contact.getEmailAddress());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** If you want to delete a user you first must invoke this method to delete the user's contacts */
	public static void deleteContactsFromDatabase(String user_id, Connection connection) throws SQLException {
		
		try (
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM contacts WHERE user_id=?");
				) {

			stmt.setString(1, user_id);			

			stmt.executeUpdate();
			
			System.out.println("Contacts with user_id" + user_id + "deleted successfully.");
		} 

	}
}
