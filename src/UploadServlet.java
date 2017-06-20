import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;  
import com.oreilly.servlet.MultipartRequest;  

@MultipartConfig  
public class UploadServlet extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
	
	MultipartRequest m=new MultipartRequest(request,"d:\\myfiles");
	String filename = null;
	for(java.util.Enumeration e=m.getFileNames(); e.hasMoreElements();)
    {
		filename=m.getFilesystemName((String)e.nextElement());
    }
	
	try{
		Db.fileDbInsert(filename, "d:\\\\myfiles");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	 RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
     rd.include(request, response);  
	
	}  
}