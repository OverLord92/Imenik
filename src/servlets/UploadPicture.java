package servlets;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class UploadPicture
 */
@WebServlet("/UploadPicture")
public class UploadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveFile = new String();
		String contentType = request.getContentType();
		
		if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
			
			DataInputStream in  = new DataInputStream(request.getInputStream());
			
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			
			while(totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			
			String file = new String(dataBytes);
			
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
			
			int lastIndex = contentType.lastIndexOf("=");
			
			String boundary = contentType.substring(lastIndex + 1, contentType.length());
			
			int pos;
			
			pos = file.indexOf("file=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			
			saveFile = "C:/Users/GEDORA/git/Imenik/WebContent/images/" + saveFile;
			
			File ff = new File(saveFile);
				
			HttpSession session = request.getSession();	
			User user = (User)session.getAttribute("user");
			UserDao.setUserPicture(user, saveFile, (Connection)getServletContext().getAttribute("connection"));
			
			try{
				FileOutputStream fileOut = new FileOutputStream(ff);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
			} catch(Exception e){
			}
			
		}
		
		response.sendRedirect("imena.jsp");
		
	}
}
