package servlets;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Contact;
import beans.User;
import dao.ContactDao;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		boolean userNameExists = false;
		boolean passwordMatches = false;
		
		try {
			// check if the entered user name exists in the database
			userNameExists = UserDao.doesUserExists(userName);
			// check if the entered password matches users password
			passwordMatches = UserDao.getUsersPassword(userName).equals(userPassword);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		ServletContext ctx = getServletContext();
		String adminName = ctx.getInitParameter("adminName");
		String adminPassword = ctx.getInitParameter("adminPassword");
		
		System.out.println(adminName + " " + adminPassword);
		System.out.println(userName + " " + userPassword);
		
		if((userName.equals(adminName))&&(userPassword.equals(adminPassword))){
			response.sendRedirect("adminMenu.jsp");
		}
		// if the previous two condition are true allow the user to log in
		else if(userNameExists && passwordMatches){
			
			User user = null;
			try {
				user = UserDao.getUser(userName);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ArrayList<Contact> userContacts = ContactDao.getUserContacts(user.getUserId());
			
			for(Contact c: userContacts)
				System.out.println(c.getContactName());
			
			
			HttpSession session = request.getSession();
			session.setAttribute("userContacts", userContacts);
			
			
			response.sendRedirect("imena.jsp");
		}	
		else {
			response.sendRedirect("login.jsp");
		}
		
	}


}
