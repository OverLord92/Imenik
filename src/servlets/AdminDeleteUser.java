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
import dao.ContactDao;
import dao.UserDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class AdminDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the userName from the adminMenu.jsp delete user form
		String userName = request.getParameter("userName");
	
		try {
			
			// get userId
			String user_id = UserDao.getUsersId(userName);
			
			// delete all users contacts first(required in order to be able delete user from database)
			ContactDao.deleteContactsFromDatabase(user_id, (Connection)getServletContext().getAttribute("connection"));
			
			// delete user from database
			UserDao.deleteUserFromDatabase(userName, (Connection)getServletContext().getAttribute("connection"));
			
			// set updated user list as a session attribute
			ArrayList<User> listOfUsers = UserDao.getAllUsers();
			HttpSession session = request.getSession();
			session.setAttribute("listOfUsers", listOfUsers);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return to adminMenu.jsp
		response.sendRedirect("adminMenu.jsp");
	}

}
