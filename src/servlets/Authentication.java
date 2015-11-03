package servlets;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;

/**
 * Class contains method to authenticate user name and password during
 * registration
 */
public class Authentication {


	public Authentication() {

	}

	public static boolean authenticate(String userName, String userPassword, String userPasswordConfirm) {

		if (userName == null || userName.trim() == "") {
			return false;
		}

		if (userPassword == null || userPasswordConfirm.trim() == "") {
			return false;
		}

		if (!userPassword.equals(userPasswordConfirm)) {
			return false;
		}

		boolean userNameAvailable = false;
		boolean passwordIsValid = false;

		try {
			userNameAvailable = userNameAvailable(userName);
			passwordIsValid = passwordIsValid(userPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true && userNameAvailable && passwordIsValid;
	}

	public static boolean userNameAvailable(String userName) throws SQLException {
		ArrayList<String> userNames = UserDao.getUserNames();

		for (String str : userNames) {
			if (userName.equals(str)) {
				System.out.println("Korisnik zauzet");
				return false;
			}
		}

		return true;
	}

	/**
	 * password must contains 5 alphanumeric characters and contain at least one
	 * letter and one digit
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
