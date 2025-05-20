package PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Utility {
	
	public String dburl = "jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
	public String user = "ha2203150";
	public String pass = "ha2203150";
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	
	
	public Utility() throws SQLException {   //to connect to the DB
		 conn = DriverManager.getConnection(dburl,user,pass);
		 conn.createStatement();
		 
	}
	
	
	public void Terminate() throws SQLException {
		System.out.println("Terminated");
		conn.close();
	}
	
	public String getAID() {
		
		try {
			Utility ut = new Utility();
			ut.conn.setAutoCommit(false);
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return dburl;
		
		
		
	}
	
	
	

	
	
	
	

	
	
}
