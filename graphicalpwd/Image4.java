package graphicalpwd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Image4 extends Canvas
{  
	static int flag;
	static int a[][];
	static String name;
	static String uname;
	public static void callme4(int f,int ar[][],String n,String un){
		flag=f;
        //System.out.println(flag);
        a=ar;
        name=n;
        uname=un;
		new Image4();      
	}
	public static void callmel4(int f,int ar[][],String un){
		flag=f;
		 a=ar;
		uname=un;
        //System.out.println(a);
		new Image4();  
        
	}
	public void paint(Graphics g) {  
		
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("4.png");  
        g.drawImage(i,0,0,700,700,this);  
          
    } 
	
     public Image4(){
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
						a[3][0]=e.getX();
						a[3][1]=e.getY();
						//System.out.println(a[3][0]+" "+a[3][1]);
						if(flag==1) {
							Image5.callme5(flag,a,name,uname);
							
						}
						else if(flag==2) {
							Image5.callmel5(flag,a,uname);
							
						}
						f.setVisible(false);
                }

            });
	 }
	/*public static void main(String[] args) {  
        
    }  */
  
}  