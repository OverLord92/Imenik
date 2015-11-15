package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Contact;
import beans.User;
import dao.ContactDao;
import dao.ConnectionManager;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {

		// establish a connection with the database
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		// set the connection instance as a context attribute
		ServletContext ctx = getServletContext();
		ctx.setAttribute("connection", connection);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// take the parameters from the login form
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		boolean userNameExists = false;
		boolean passwordMatches = false;

		try {
			// check if the entered user name exists in the database
			userNameExists = UserDao.doesUserExists(userName);
			// check if the entered password matches users password
			passwordMatches = UserDao
					.getUsersPassword(userName, (Connection) getServletContext().getAttribute("connection"))
					.equals(userPassword);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		ServletContext ctx = getServletContext();
		String adminName = ctx.getInitParameter("adminName");
		String adminPassword = ctx.getInitParameter("adminPassword");

		// check if the person who tries to log in is the admin
		if ((userName.equals(adminName)) && (userPassword.equals(adminPassword))) {
			
			// if so get a list of all users and set is as a session attribute
			ArrayList<User> listOfUsers = null;
			try {
				listOfUsers = UserDao.getAllUsers();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("listOfUsers", listOfUsers);
			response.sendRedirect("adminMenu.jsp");
		}
		
		// if the userName exists and the entered password matches the user password
		// allow the user to log in
		else if (userNameExists && passwordMatches) {

			User user = null;
			try {

				// get the user instance with the entered userName 
				user = UserDao.getUser(userName, (Connection) getServletContext().getAttribute("connection"));
				// set the user intance as an session attribute
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			// take the user to the userProfile.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("userProfile.jsp");
			dispatcher.forward(request, response);
			
		} else {
			// if the login was unsuccessful refresh the login.jsp and clear input fields
			response.sendRedirect("login.jsp");
		}
	}
}
