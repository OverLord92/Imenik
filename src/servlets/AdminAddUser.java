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
 * Servlet implementation class AdminAddUser
 */
@WebServlet("/AdminAddUser")
public class AdminAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get parameters from the adminMenu.jsp 'add new user' form
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPasswordConfirm = request.getParameter("userPasswordConfirm");

		// check if the userName and passwords pass validation
		if (Authentication.authenticate(userName, userPassword, userPasswordConfirm)) {
			try {
				// get the remaining parameters from the form
				String userPhoneNumber = request.getParameter("userPhoneNumber");
				String userEmailAddress = request.getParameter("userEmailAddress");
				
				// create an user instance and add it to the database
				User user = new User(userName, userPassword, userPhoneNumber, userEmailAddress, null);
				UserDao.addUserToDatabase(user, (Connection)getServletContext().getAttribute("connection"));
				
				// set the updated user list as a session attribute
				ArrayList<User> listOfUsers = UserDao.getAllUsers();
				HttpSession session = request.getSession();
				session.setAttribute("listOfUsers", listOfUsers);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// return to adminMenu.jsp after adding new user
			response.sendRedirect("adminMenu.jsp");
			return;
		} else {
			// return to adminMenu.jsp without any changes
			response.sendRedirect("adminMenu.jsp");
			return;
		}
		
	}

}
