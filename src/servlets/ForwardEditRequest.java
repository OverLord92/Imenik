package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class ForwardEditRequest between the adminMenu.jsp and editUser.jsp
 * This servlet is used to omit business logic in the editUser.jsp 
 */
@WebServlet("/ForwardEditRequest")
public class ForwardEditRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the userName from the adminMenu.jsp edit user form
		String userName = request.getParameter("userName");
		try {
			// check if user exists in the database
			if (UserDao.doesUserExists(userName)) {
				// if the user exists add the user to the session 
				User user = UserDao.getUser(userName, (Connection) getServletContext().getAttribute("connection"));
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				// redirect to the editUser.jsp to take new parameters from the user
				RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
				rd.forward(request, response);
				
			} else {
				// if the user doesn't exists in the database return to adminMenu.jsp 
				System.out.println("The user " + userName + " doesn't exists in the database.");
				response.sendRedirect("adminMenu.jsp");
			}

		} catch (Exception ex) {
		}
	}
}
