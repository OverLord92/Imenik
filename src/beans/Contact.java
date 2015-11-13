package beans;

import java.io.Serializable;

/** bean class which represents users contacts */
public class Contact implements Serializable{
	
	// bean version
	private static final long serialVersionUID = 1L;
	
	// data fields
	private String contactName;
	private String contactPhoneNumber;
	private String emailAddress;
	
	// getters
	public String getContactName() {
		return contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	
	// setters 
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	
	// contactName setter omitted - contactName shouldn't be changed


	/** No-argument constructor */
	public Contact(){
	}
	
	/** Overloaded constructor */
	public Contact(String contactName, String contactPhoneNumber, String emailAddress) {
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.emailAddress = emailAddress;
	}

	
}
