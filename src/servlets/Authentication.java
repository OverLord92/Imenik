package servlets;
import java.sql.SQLException;

import dao.UserDao;

/**
 * Class contains method to authenticate user name and password during
 * registration
 */
public class Authentication {


	public Authentication() {

	}

	/**
	 * Check if userName is available, if the password is valid 
	 * and if the pair of entered passwords is identical.
	 * */
	public static boolean authenticate(String userName, String userPassword, String userPasswordConfirm) {

		// check if user entered a userName
		if (userName == null || userName.trim() == "") {
			return false;
		}
		
		// check if user entered password
		if (userPassword == null || userPasswordConfirm.trim() == "") {
			return false;
		}
		
		// check if user entered a pair of dentical passwords
		if (!userPassword.equals(userPasswordConfirm)) {
			return false;
		}

		boolean userNameAvailable = false;
		boolean passwordIsValid = false;

		// check if userName is available and if password is valid
		try {
			userNameAvailable = userNameAvailable(userName);
			passwordIsValid = passwordIsValid(userPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true && userNameAvailable && passwordIsValid;
	}

	/** check if userName is available */
	public static boolean userNameAvailable(String userName) throws SQLException {
		return !UserDao.doesUserExists(userName);
	}

	/**
	 * Check if password is valid.
	 * Password must contains 5 alphanumeric characters and contain at least one
	 * letter and one digit.
	 */
	public static boolean passwordIsValid(String password) {
		int numberOfDigits = 0;
		int numberOfLetters = 0;
		
		// check if password is long enough
		if(password.length() < 5)
			return false;
		
		for(int charIndex = 0; charIndex < password.length(); charIndex++){
			// count digits in password
			if(Character.isDigit(password.charAt(charIndex)))
				numberOfDigits++;
			// count letters in password
			if(Character.isLetter(password.charAt(charIndex)))
				numberOfLetters++;
		}
		
		return (numberOfDigits > 0) && (numberOfLetters > 0);
		
	}

}
