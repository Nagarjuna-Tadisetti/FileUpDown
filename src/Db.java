import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;

public class Db {
	
	public static void fileDbInsert(String file, String path) throws SQLException {
	
		Connection dbConnection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Step 1
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb","root",""); // Step 2
			statement = dbConnection.createStatement(); // Step 3
			statement.executeUpdate("INSERT INTO myfiles values('"+file+"','"+path+"')");		
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement != null){
				statement.close();
			}
			if(dbConnection != null ){
				dbConnection.close();
			}
		}
	}
}