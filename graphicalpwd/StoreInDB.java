package graphicalpwd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class StoreInDB {

	private static Connection conn=null;
	//ArrayList<Object> al=new ArrayList<Object>();
	
	public static int UniqueUser(String username) {
		// TODO Auto-generated method stub
		int count=0;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/mydb1";
				String user="Priya";
				String password="root";
				conn=DriverManager.getConnection(dburl,user,password);
				if(conn!=null) {
					//System.out.println("Hello-Demo");
					Statement stmt=conn.createStatement();
				    String query="select * from points where uname=" +"\""+username+"\""+";";  //get username

				    ResultSet rs=stmt.executeQuery(query);
					if(rs.next())
						count++;
					//System.out.println(count);
					conn.close();
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
	
	
	public static void insertDetails(ArrayList<String> a) {
		// TODO Auto-generated method stub
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/mydb1";
				String user="Priya";
				String password="root";
				conn=DriverManager.getConnection(dburl,user,password);
				if(conn!=null) {
					//System.out.println("Hello-Demo2");
					
						  String query = " INSERT INTO PDETAILS  (NAME, MOBNO, PMAIL, SMAIL, UNAME)"+ " values (?, ?, ?, ?, ?)";
						  
					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setString(1,(String)a.get(0));
					      preparedStmt.setString(2, (String)a.get(1));
					      preparedStmt.setString(3, (String)a.get(2));
					      preparedStmt.setString(4, (String)a.get(3));
					      preparedStmt.setString(5, (String)a.get(4));

					      // execute the preparedstatement
					      preparedStmt.execute();
					      conn.close();
				}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void StoreClickPoints(int a[][],String name,String uname) {
		// TODO Auto-generated method stub
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/mydb1";
				String user="Priya";
				String password="root";
				conn=DriverManager.getConnection(dburl,user,password);
				if(conn!=null) {
					//System.out.println("Hello-Demo3");
					
					  String query = " INSERT INTO POINTS(P1X,P1Y,P2X,P2Y,P3X,P3Y,P4X,P4Y,P5X,P5Y,NAME,UNAME)"+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
					  
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setInt(1,a[0][0]);
				      preparedStmt.setInt(2,a[0][1]);
				      preparedStmt.setInt(3,a[1][0]);
				      preparedStmt.setInt(4,a[1][1]);
				      preparedStmt.setInt(5,a[2][0]);
				      preparedStmt.setInt(6,a[2][1]);
				      preparedStmt.setInt(7,a[3][0]);
				      preparedStmt.setInt(8,a[3][1]);
				      preparedStmt.setInt(9,a[4][0]);
				      preparedStmt.setInt(10,a[4][1]);
				      preparedStmt.setString(11,name);
				      preparedStmt.setString(12, uname);

				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      
				      String q = " INSERT INTO FailedAuth(uname,fail)"+ " values (?,?)";
					  
				      // create the mysql insert preparedstatement
				      PreparedStatement pStmtFailAuth = conn.prepareStatement(q);
				      pStmtFailAuth.setString(1,uname);
				      pStmtFailAuth.setInt(2,0);
				      
				      pStmtFailAuth.execute();
				      
					conn.close();
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}


}
