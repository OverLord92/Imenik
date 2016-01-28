package beans;

import java.io.Serializable;
import java.util.ArrayList;

import dao.ContactDao;
import dao.UserDao;

/** bean class witch represents users */
public class User implements Serializable{
	
	// bean version
	private static final long serialVersionUID = 1L;
	
	// data fields
	private String userId;
	private String userName;
	private String userPassword;
	private String userPhoneNumber;
	private String userEmailAddress;
	private String linkToImage;
	private ArrayList<Contact> contacts;
	
	
	
	//getters
	public String getUserId() {
		return userId;
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
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	
	// setters
	
	// userId setter omitted - userId shouldn't be changed by the program 
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}
	
	public void setLinkToImage (String linkToImage){
		this.linkToImage = linkToImage;
	}

	
	/** No-argument constructor */ 
	public User(){
	}

	/** Overloaded User constructor*/
	public User(String userName, String userPassword, String userPhoneNumber, String userEmailAddress, String linkToImage) {
		
		// if the constructor is invoked during user registration this value will be null
		// user will get an id during insertion into database
		this.userId = UserDao.getUsersId(userName);
		
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmailAddress = userEmailAddress;
		this.linkToImage = linkToImage;
		
		// if the constructor is invoked during user registration this value will be an empty array
		this.contacts = ContactDao.getUserContacts(userId);
	}
	
	
	
}
