import java.io.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;  
import com.oreilly.servlet.MultipartRequest;  

@MultipartConfig  
public class FileNames extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
	response.setContentType("application/json");
	PrintWriter out = response.getWriter();
	final File folder = new File("d:\\myfiles");
	ArrayList<String> files = listFilesForFolder(folder);
	StringBuffer jsonFiles = new StringBuffer ("{ \"files\":[");
	for(String s: files){
		jsonFiles.append("\"");
		jsonFiles.append(s+"\",");
	}
	jsonFiles.append("\"end\"]}");
	out.print(jsonFiles);
	out.flush();
	}  

public ArrayList<String> listFilesForFolder(final File folder) {
	ArrayList<String> files = new ArrayList<String>();
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
        	files.add(fileEntry.getName());
        }
    }
    return files;
}
}