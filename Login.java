import graphicalpwd.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Login implements ActionListener
{
	static JFrame f;
	static JButton b1,b2,x;
	static JLabel l1,l2,header;
	static JTextField tuname;
	static int i=0,fail;
	
	public Login()
	{
		f=new JFrame();
		f.setBounds(300,100,400,600);
		f.setLayout(new BorderLayout());
		f.setContentPane(new JLabel(new ImageIcon("C:\\ccp\\gradientresized.png")));
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		header=new JLabel("USER LOGIN");
		header.setFont(new Font("Arial", Font.BOLD, 25));
		header.setBounds(120,50,250,40);
		f.add(header);
		
		
		JLabel img = new JLabel(); //JLabel Creation
        img.setIcon(new ImageIcon("user.png")); //Sets the image to be displayed as an icon
        img.setBounds(120, 100, 160, 160);
        f.add(img);
        
        tuname = new JTextField("  Enter username ",20);
		tuname.setFont(new Font("Arial", Font.PLAIN, 15));
		tuname.setBounds(50,300,250,40); 
		tuname.setOpaque(false); // Must add
		f.add(tuname);
		
		tuname.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent event) {
		        String content = tuname.getText();
		        if (content.equals("  Enter username ")) {
		        	tuname.setText("");
		        } 
		    }
		});
		
    	x=new JButton("X");
    	x.setFont(new Font("arial", Font.BOLD, 15));
    	x.setBounds(300,300,45,40);
    	x.setOpaque(false);
        x.setFocusable(false); 
        x.setBorderPainted(true); 
        x.setBackground(Color.white);
        x.addActionListener(this);
    	f.add(x);
		
		b1=new JButton("Login");
		b1.setBounds(130,370,150,40);
		b1.setOpaque(false); 
        b1.setFocusable(false); 
        b1.setBorderPainted(true); 
        b1.setBackground(Color.white);
        
        b2=new JButton("Signup");
		b2.setBounds(230,450,50,40);
        b2.setContentAreaFilled(false);
        b2.setFocusable(false); 
        b2.setBorderPainted(true); 
        b2.setBorder(null);
        b2.setForeground( Color.BLUE );
		f.add(b1);
		f.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		l1= new JLabel("Not an existing user?");
		l1.setFont(new Font("Arial", Font.BOLD, 13));
		l1.setBounds(100,450,300,40);
		f.add(l1);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String btn=e.getActionCommand();
		if(btn.equals("Signup")){
			new Registration();
			f.setVisible(false);
		}
		String username=tuname.getText();
		if (btn.equals("Login")){
			//check in database if username exists
			int col=StoreInDB.UniqueUser(username);
			if(col>0) {
				fail=FailedAuth.checkFail(username);
				if(fail<3) {
					JOptionPane.showMessageDialog(f, "Enter password");
					f.setVisible(false);
					Image1.callmel1(2,username);
					f.setVisible(false);
				}
				else if(fail>=3)
					JOptionPane.showMessageDialog(null,"Sorry,you have exceeded the no.of attempts");
			}
			else {
				JOptionPane.showMessageDialog(f,"Invalid Username");
			}
		}
		else if (btn.equals("X")) {
			String def = "";
			tuname.setText(def);
		}
		
		
	}
	public static void main(String[] args) 
	{
		new Login();
	}
}