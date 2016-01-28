package servlets;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		// check the content type of the input
		if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
			
			DataInputStream in  = new DataInputStream(request.getInputStream());
			
			// read the image into a byte array
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			
			while(totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			
			// create a string of the byte array
			String file = new String(dataBytes);
			
			//
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
			
			
			saveFile = "c:/imenik_slike/" + saveFile;
			
			// create a file object of the read bytes
			File ff = new File(saveFile);
			
			try{
				// paste the image to the target file
				FileOutputStream fileOut = new FileOutputStream(ff);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
			} catch(Exception e){
				e.printStackTrace();
				System.err.println("An error ocurred during the upload.");
			}
			
		}
		
		// return to the userProfile.jsp
		response.sendRedirect("userProfile.jsp");
		
	}
}
