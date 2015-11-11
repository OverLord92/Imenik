package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String userName = request.getParameter("userName");
	
		try {
			
			String user_id = UserDao.getUsersId(userName);
			
			ContactDao.deleteContactsFromDatabase(user_id, (Connection)getServletContext().getAttribute("connection"));
			
			UserDao.deleteUserFromDatabase(userName, (Connection)getServletContext().getAttribute("connection"));
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("adminMenu.jsp");
	}

}
