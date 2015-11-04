package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Contact;

public class ContactDao {

	/**  */
	public static ArrayList<Contact> getUserContacts(String user_id, Connection connection) {

		ArrayList<Contact> userContacts = new ArrayList<>();
		ResultSet result = null;

		try (
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contacts WHERE user_id=?");) {
			stmt.setString(1, user_id);

			result = stmt.executeQuery();

			while (result.next()) {
				Contact contact = new Contact(result.getString(3), result.getString(4), result.getString(5));
				userContacts.add(contact);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userContacts;

	}

	public static void addContactToDatabase(String user_id, Contact contact, Connection con) {

		try ( PreparedStatement stmt = con.prepareStatement(
						"INSERT INTO contacts (user_id, contactName, contactNumber, email_address) VALUES (?, ?, ?, ?)");) {

			stmt.setString(1, user_id);
			stmt.setString(2, contact.getContactName());
			stmt.setString(3, contact.getContactPhoneNumber());
			stmt.setString(4, contact.getEmail_address());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteContactsFromDatabase(String user_id, Connection connection) throws SQLException {
		
		

		try (
				PreparedStatement stmt = connection
						.prepareStatement("DELETE FROM contacts WHERE user_id=?");
				
				) {

			
			stmt.setString(1, user_id);			

			stmt.executeUpdate();
			
			System.out.println("sksesfuli");
		} 

	}
}
