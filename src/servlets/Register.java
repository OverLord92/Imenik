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
import javax.servlet.http.HttpSession;

import beans.User;
import dao.MyConnection;
import dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/controller")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(){
		
		Connection connection = MyConnection.getConnection();
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("connection", connection);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		getServletContext().getAttribute("nema");

		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPasswordConfirm = request.getParameter("userPasswordConfirm");

		if (Authentication.authenticate(userName, userPassword, userPasswordConfirm)) {
			try {
				String userPhoneNumber = request.getParameter("userPhoneNumber");
				String userEmailAddress = request.getParameter("userEmailAddress");
				
				User user = new User(userName, userPassword, userPhoneNumber, userEmailAddress, null);
				
				UserDao.addUserToDatabase(user, (Connection)getServletContext().getAttribute("connection"));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("login.jsp");
			return;
		} else {
			response.sendRedirect("register.jsp");
			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}