package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Contact;
import beans.User;
import dao.ContactDao;

/**
 * Servlet implementation class AddNewContactSevlet
 */
@WebServlet("/AddContact")
public class AddNewContactSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get contact name from form on JSP page imena.jsp
		String contactName = request.getParameter("contactName");
		// get contact phone number from form on JSP page imena.jsp
		String contactPhoneNumber = request.getParameter("contactPhoneNumber");
		
		String emailAddress = request.getParameter("contactEmailAddress");
		
		// create a new contact instance
		Contact contact = new Contact(contactName, contactPhoneNumber, emailAddress);
		
		// get session to retrieve users contacts
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Contact> userContacts = user.getContacts();
		
		// add entered contact to list
		userContacts.add(contact);
		
		ContactDao.addContactToDatabase(user.getUserId(), contact, (Connection)getServletContext().getAttribute("connection"));
		
		session.setAttribute("user", user);
		
		response.sendRedirect("userProfile.jsp");
		
	}

}
