package beans;

public class Contact {
	
	private String contactName;
	private String contactPhoneNumber;
	private String email_address;
	
	
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


	public String getEmail_address() {
		return this.email_address;
	}
	
	
	public Contact(String contactName, String contactPhoneNumber, String email_address) {
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.email_address = email_address;
	}

	
}
