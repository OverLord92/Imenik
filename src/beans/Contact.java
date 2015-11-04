package beans;

// bean class which represents users contacts
public class Contact {
	
	private String contactName;
	private String contactPhoneNumber;
	private String emailAddress;
	
	
	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	
	
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}


	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public Contact(){
	}
	
	public Contact(String contactName, String contactPhoneNumber, String emailAddress) {
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.emailAddress = emailAddress;
	}

	
}
