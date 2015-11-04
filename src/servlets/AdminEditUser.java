package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			User user = UserDao.getUser(userName);
			
			user.setUserPhoneNumber(phoneNumber);
			user.setUserEmailAddress(userEmailAddress);
			user.setUserPassword(password);
			
			UserDao.updateUserInDatabase(user, (Connection)getServletContext().getAttribute("connection"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		response.sendRedirect("adminMenu.jsp");
		
	}

}
