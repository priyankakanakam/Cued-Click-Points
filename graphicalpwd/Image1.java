package graphicalpwd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Image1 extends Canvas
{  
	int a[][]=new int[5][2];
	static int flag;
	static String name;
	static String uname;
	public static void callme1(int f,String n,String un){
		flag=f;
		name=n;
		uname=un;
        //System.out.println(a);
		new Image1();  
        
	}
	public static void callmel1(int f,String un){
		flag=f;
		uname=un;
        //System.out.println(un);
		new Image1();  
        
	}
	public void paint(Graphics g) {  
		
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("1.png");  
        g.drawImage(i,0,0,700,700,this);  
          
    } 
	public Image1(){
		JFrame f=new JFrame();  
        f.setBounds(300,100,700,700);
		f.add(this);
		f.setResizable(false);
        f.setVisible(true); 
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    
						//System.out.println(e.getX()+"  "+e.getY());
						a[0][0]=e.getX();
						a[0][1]=e.getY();
						//System.out.println(a[0][0]+" "+a[0][1]);
						if(flag==1) {  //registration
						Image2.callme2(flag,a,name,uname);
						}
						else if(flag==2) {
						Image2.callmel2(flag,a,uname);
						
						}
						f.setVisible(false);	
                }
                
            });
		
	 }
      
	/*public static void main(String[] args) {  
        callme1();
    }*/
  
}  
