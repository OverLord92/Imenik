package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class AJAXCheckIfUserExists
 */
@WebServlet("/AJAXCheckIfUserExists")
public class AJAXCheckIfUserExists extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("ID");
		
		String userName = request.getParameter("userName");
//		String userEmailAddress = request.getParameter("userEmailAddress");
		
		if(ID.equals("userName")){
			if(UserDao.doesUserExists(userName)){
				
				HttpSession session = request.getSession();
				session.setAttribute("existingUser", userName);
				
				response.getWriter().write("<p>Korisnik " + userName + " pod tim imenom vec postoji." 
						+ " Da li se zelite ulogovati? <a href=\"login.jsp\">Login</a></p>");
			}
		}
	}
}
