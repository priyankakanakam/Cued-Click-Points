package graphicalpwd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class FailedAuth {
	static String username;
	private static Connection conn=null;
	static int f;
	public static int checkFail(String uname) {
		try {
			username=uname;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/mydb1";
			String user="Priya";
			String password="root";
			conn=DriverManager.getConnection(dburl,user,password);
			if(conn!=null) {
				Statement stmt=conn.createStatement();
			    String query="select fail from FailedAuth where uname=" +"\""+username+"\""+";";  //get fail
			    ResultSet rs=stmt.executeQuery(query);
			    if(rs.next()) {
			    		f=rs.getInt(1);
			    }
			    
				conn.close();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//System.out.print(f);
			return f;
		
	}
}
