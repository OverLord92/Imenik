package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.ConnectionManager;
import dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/controller")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {

		// establish a connection with the database
		Connection connection = ConnectionManager.getInstance().getConnection();
		// and set it as a session attribute
		ServletContext ctx = getServletContext();
		ctx.setAttribute("connection", connection);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get parameters from the register.jsp form
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPasswordConfirm = request.getParameter("userPasswordConfirm");

		// check if entered userName and password passes validation
		if (Authentication.authenticate(userName, userPassword, userPasswordConfirm)) {
			try {
				// get remaining parameters
				String userPhoneNumber = request.getParameter("userPhoneNumber");
				String userEmailAddress = request.getParameter("userEmailAddress");

				// create a user instance
				User user = new User(userName, userPassword, userPhoneNumber, userEmailAddress, null);
				// add user to database
				UserDao.addUserToDatabase(user, (Connection) getServletContext().getAttribute("connection"));

			} catch (SQLException e) {
				e.printStackTrace();
			}
				// redirect user to login.jsp
				response.sendRedirect("login.jsp");
				return;
		} else {
			// if validation was unsuccessful stay on the register.jsp
			response.sendRedirect("register.jsp");
			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
