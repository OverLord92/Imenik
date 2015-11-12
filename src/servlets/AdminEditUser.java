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
	
		String userName = request.getParameter("userName");
		String phoneNumber = request.getParameter("userPhoneNumber");
		String userEmailAddress = request.getParameter("userEmailAddress");
		
		String password = request.getParameter("userPassword");
		
		try {
			
			User user = UserDao.getUser(userName, (Connection)getServletContext().getAttribute("connection"));
			
			user.setUserPhoneNumber(phoneNumber);
			user.setUserEmailAddress(userEmailAddress);
			user.setUserPassword(password);
			
			UserDao.updateUserInDatabase(user, (Connection)getServletContext().getAttribute("connection"));
			
			ArrayList<User> listOfUsers = UserDao.getAllUsers();
			HttpSession session = request.getSession();
			session.setAttribute("listOfUsers", listOfUsers);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		response.sendRedirect("adminMenu.jsp");
		
	}

}
