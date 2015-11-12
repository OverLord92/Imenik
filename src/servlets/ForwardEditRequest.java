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
 * Servlet implementation class ForwardEditRequest
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

		String userName = request.getParameter("userName");
		try {
			if (!UserDao.doesUserExists(userName)) {
				System.out.println("ne postoji");
				response.sendRedirect("adminMenu.jsp");
			} else {
				User user = UserDao.getUser(userName, (Connection) getServletContext().getAttribute("connection"));
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println(user.getUserName());
				
				RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
				rd.forward(request, response);
			}

		} catch (Exception ex) {
		}
	}
}
