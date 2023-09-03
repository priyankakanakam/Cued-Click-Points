package graphicalpwd;
import java.util.regex.*;    
import java.util.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Registration extends JFrame implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;

	private JLabel name;
	private JTextField tname;

	private JLabel mno;
	private JTextField tmno;

	private JLabel pm;
	private JTextField tpm;

	private JLabel sm;
	private JTextField tsm;

	private JLabel uname;
	private JTextField tuname;

	private JCheckBox term;

	private JButton sub;
	private JButton reset;
	
	private JLabel res;
	

	// constructor, to initialize the components
	// with default values.
	public Registration()
	{
		setTitle("Registration Form");
		setBounds(300, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		//c = getContentPane();
		setContentPane(new JLabel(new ImageIcon("C:\\ccp\\rgradient.png")));
		setVisible(true);
		
		title = new JLabel("USER  SIGNUP");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setBounds(200,30,250, 40);
		add(title);

		name = new JLabel("Full name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setBounds(50,90,150, 25);
		add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setBounds(250,90,250, 25);
		add(tname);

		mno = new JLabel("Mobile number");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setBounds(50,130,150, 25);
		add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setBounds(250,130,250, 25);
		add(tmno);

		pm = new JLabel("Primary Mail");
		pm.setFont(new Font("Arial", Font.PLAIN, 20));
		pm.setBounds(50,170,150, 25);
		add(pm);

		tpm = new JTextField();
		tpm.setFont(new Font("Arial", Font.PLAIN, 15));
		tpm.setBounds(250,170,250, 25);
		add(tpm);

		sm = new JLabel("Secondary Mail");
		sm.setFont(new Font("Arial", Font.PLAIN, 20));
		sm.setBounds(50,210,150, 25);
		add(sm);

		tsm = new JTextField();
		tsm.setFont(new Font("Arial", Font.PLAIN, 15));
		tsm.setBounds(250,210,250, 25);
		add(tsm);

		uname = new JLabel("Username");
		uname.setFont(new Font("Arial", Font.PLAIN, 20));
		uname.setBounds(50,250,150, 25);
		add(uname);

		tuname = new JTextField();
		tuname.setFont(new Font("Arial", Font.PLAIN, 15));
		tuname.setBounds(250,250,250, 25);
		add(tuname);
		
		term = new JCheckBox("Accept Terms And Conditions.");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setBounds(150,300,300, 25);
		//term.setBackground(Color.white);
		term.setOpaque(false);
		add(term);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setBounds(100,340,150, 30);
		sub.setBackground(Color.white);
		sub.addActionListener(this);
		add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setBounds(300,340,150, 30);
		reset.setBackground(Color.white);
		reset.addActionListener(this);
		add(reset);


		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setBounds(50,390,400, 25);
		add(res);
		
		
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == sub) {
			
			if (term.isSelected() && e.getSource()==sub) {
				String name=tname.getText();
				String mobno=tmno.getText();
				String pmail=tpm.getText();
				String smail=tsm.getText();
				String username=tuname.getText();
				int funame=StoreInDB.UniqueUser(username);
				CheckValidity obj=new CheckValidity();
				if(!obj.NameValidation(name))
					JOptionPane.showMessageDialog(this, "Please enter valid name");
				else if(!obj.MobileNumberValidation(mobno))
					JOptionPane.showMessageDialog(this, "Please enter a valid mobile number");
				else if(!obj.EmailValidation(pmail))
					JOptionPane.showMessageDialog(this, "Please enter a valid primary mail id");
				else if(!obj.EmailValidation(smail))
					JOptionPane.showMessageDialog(this, "Please enter a valid secondary mail id");
				//check if username is unique or not by checking in database
				else if(username.isEmpty())
					JOptionPane.showMessageDialog(this, "Please enter a valid user name");
				else if(funame>0)
					JOptionPane.showMessageDialog(this, "User name already exists");
				
				else if(obj.NameValidation(name) && obj.MobileNumberValidation(mobno) && obj.EmailValidation(pmail) && obj.EmailValidation(smail)){
					ArrayList<String> al=new ArrayList<String>();
					al.add(name);
					al.add(mobno);
					al.add(pmail);
					al.add(smail);
					al.add(username);
					//System.out.print(al);
					StoreInDB.insertDetails(al);
					
					JOptionPane.showMessageDialog(this,"Set your password by clicking on the five images displayed.");
					Image1.callme1(1,name,username);
					setVisible(false);
					//ImageDisplay.callme1(1,name,username);
				}
				
			}
			else {
				res.setText("Please accept the terms & conditions..");
			}
		}

		else if(e.getSource()==reset){
			String def = "";
			tname.setText(def);
			tmno.setText(def);
			tpm.setText(def);
			tsm.setText(def);
			tuname.setText(def);
			res.setText(def);
			term.setSelected(false);
			
		}
	}
//}
	/*public static void main(String[] args) throws Exception
	{
		 new Registration();
	}*/
}


class CheckValidity
{
	public boolean NameValidation(String name){
		String regex = "^[A-Za-z\s]{1,}[.]{0,1}[A-Za-z\s]{0,}$";
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(name); 
		return matcher.matches();
	}

	public boolean MobileNumberValidation(String mno){
		String regex = "(0/91)?[7-9][0-9]{9}";
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(mno); 
		return matcher.matches();
	}

	public boolean EmailValidation(String mail){
		String regex = "^[a-zA-Z]+([a-zA-Z0-9+_.-])*+@+[a-zA-Z]+[.]{1}+([a-zA-Z.])*[a-zA-Z]+$";
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(mail); 
		return matcher.matches();
	}
}

