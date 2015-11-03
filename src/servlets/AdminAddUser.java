package servlets;


import java.io.IOException;
import java.sql.SQLException;

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
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPasswordConfirm = request.getParameter("userPasswordConfirm");

		System.out.println(userName + " " + userPassword + " " + userPasswordConfirm);
		
		if (Authentication.authenticate(userName, userPassword, userPasswordConfirm)) {
			try {
				String userPhoneNumber = request.getParameter("userPhoneNumber");
				String userEmailAddress = request.getParameter("userEmailAddress");
				
				User user = new User(userName, userPassword, userPhoneNumber, userEmailAddress, null);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				UserDao.addUserToDatabase(user);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("adminMenu.jsp");
			return;
		} else {
			System.out.println("nije prolsa valijdacija");
			response.sendRedirect("adminMenu.jsp");
			return;
		}
		
	}

}
