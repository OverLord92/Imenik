package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ContactDao;
import dao.UserDao;

public class User implements Serializable{
	
	private String userId;
	private String userName;
	private String userPassword;
	private String userPhoneNumber;
	private String userEmailAddress;
	private String linkToImage;
	private ArrayList<Contact> contacts;
	
	
	
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}


	public String getUserId() {
		return userId;
	}
	
	
	public void setUserId(String user_id) {
		this.userId = user_id;
	}


	public String getUserName() {
		return userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public String getLinkToImage (){
		return linkToImage;
	}
	
	public void setLinkToImage (String linkToImage){
		this.linkToImage = linkToImage;
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	public User(){
	}


	// treba ubaciti konstruktor za registraciju
	
	// konstruktor za login
	public User(String userName, String userPassword, String userPhoneNumber, String userEmailAddress, String linkToImage) throws SQLException{
		this.userId = UserDao.getUsersId(userName);
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmailAddress = userEmailAddress;
		this.linkToImage = linkToImage;
		this.contacts = ContactDao.getUserContacts(userId);
	}
	
	
	
}
