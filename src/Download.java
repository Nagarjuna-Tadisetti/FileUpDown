import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Download extends HttpServlet {  
  
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {   
		PrintWriter out = response.getWriter();  
		String filename = request.getParameter("fname");   
		String filepath = "d:\\myfiles\\";   
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
		FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
			out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
	}  
  
}  