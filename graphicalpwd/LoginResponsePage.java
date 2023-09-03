package graphicalpwd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class LoginResponsePage extends JFrame{
	private String a[]=new String[5];
	
	private Container c;
	private JLabel img,uname;
	LoginResponsePage(String username){
		setTitle("login");
		setBounds(300, 100, 450, 450);
		setVisible(true);
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("C:\\ccp\\rgradient.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = new JLabel(); //JLabel Creation
        img.setIcon(new ImageIcon("user.png")); //Sets the image to be displayed as an icon
        img.setBounds(135, 50, 160, 160);
        add(img);
		
        uname = new JLabel("Hello user "+username);
		uname.setFont(new Font("Arial", Font.PLAIN, 25));
		uname.setBounds(120,250,250,25);
		add(uname);
	}
	public static void callme(String username) {
		new LoginResponsePage(username);
	}
	/*public static void main(String[] args) {
		new LoginResponsePage("sai shriya");
	}*/
}
