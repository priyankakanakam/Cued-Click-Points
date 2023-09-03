package graphicalpwd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class AuthenticateUser {
	static int actpts[][]=new int[5][2];
	static int clkpts[][]=new int[5][2];
	static String username;
	private static Connection conn=null;
	static int a[]=new int[5];
	static int f;
	public static void authenticate(int ar[][],String uname) {
		clkpts=ar;
		username=uname;
		//System.out.println("In authenticate clicked points");
		/*for(int i=0;i<5;i++)
			System.out.println(ar[i][0]+" "+ar[i][1]);*/
		//System.out.println("before extracting  clicked points");
		AuthenticateUser.getPoints();
	}
	

	
	public static void getPoints() {
		// TODO Auto-generated method stub
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/mydb1";
				String user="Priya";
				String password="root";
				conn=DriverManager.getConnection(dburl,user,password);
				if(conn!=null) {
					Statement stmt=conn.createStatement();
				    String query="select * from points where uname=" +"\""+username+"\""+";";  //get username
				    ResultSet rs=stmt.executeQuery(query);
				    if(rs.next()) {
						actpts[0][0]=rs.getInt(1);
						actpts[0][1]=rs.getInt(2);
						actpts[1][0]=rs.getInt(3);
						actpts[1][1]=rs.getInt(4);
						actpts[2][0]=rs.getInt(5);
						actpts[2][1]=rs.getInt(6);
						actpts[3][0]=rs.getInt(7);
						actpts[3][1]=rs.getInt(8);
						actpts[4][0]=rs.getInt(9);
						actpts[4][1]=rs.getInt(10);
				    }
					conn.close();
				}
				AuthenticateUser.checkTolerance();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void checkTolerance() {
		int tx,ty,dx,dy;
		int[] s={1,1,0,1,0};
		for(int i=0;i<5;i++) {
				tx=actpts[i][0]-clkpts[i][0];
				ty=actpts[i][1]-clkpts[i][1];
				dx=tx*tx;
				dy=ty*ty;
				if((dx+dy<100)&&(s[i]==1)) {
					a[i]=1;
				}
				else if(!(dx+dy<100)&&(s[i]==0)) {
					a[i]=1;	
				}
		}
		if(a[0]+a[1]+a[2]+a[3]+a[4]==5) {
			LoginResponsePage.callme(username);
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/mydb1";
				String user="Priya";
				String password="root";
				conn=DriverManager.getConnection(dburl,user,password);
				f=FailedAuth.checkFail(username);
				f+=1;
				String q="update FailedAuth set fail=" +"\""+f+"\"where uname=" +"\""+username+"\""+";";  //get fail
				PreparedStatement pStmtFailAuth = conn.prepareStatement(q);
				pStmtFailAuth.execute();
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
			JOptionPane.showMessageDialog(null,"Incorrect password");	
		}
		
	}
	
}
