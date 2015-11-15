package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class AdminEditUser
 */
@WebServlet("/EditUser")
public class AdminEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// take new parameters from the editUser.jsp form
		String userName = request.getParameter("userName");
		String phoneNumber = request.getParameter("userPhoneNumber");
		String userEmailAddress = request.getParameter("userEmailAddress");
		String password = request.getParameter("userPassword");
		
		try {
			// get user from session
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			// set new the updated user instance variables
			user.setUserName(userName);
			user.setUserPhoneNumber(phoneNumber);
			user.setUserEmailAddress(userEmailAddress);
			user.setUserPassword(password);
			
			// update the user variables in the database
			UserDao.updateUserInDatabase(user, (Connection)getServletContext().getAttribute("connection"));
			
			// set the updated user list to the session
			ArrayList<User> listOfUsers = UserDao.getAllUsers();
			session.setAttribute("listOfUsers", listOfUsers);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// redirect back to the adminMenu.jsp
		response.sendRedirect("adminMenu.jsp");
		
	}

}
