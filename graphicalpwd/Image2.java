package graphicalpwd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Image2 extends Canvas
{  
	static int flag;
	static int a[][];
	static String name;
	static String uname;
	public static void callme2(int f,int ar[][],String n,String un){
		flag=f;
        //System.out.println(flag);
        a=ar;
        name=n;
        uname=un;
        new Image2();      
	}
	public static void callmel2(int f,int ar[][],String un){
		flag=f;
		 a=ar;
		uname=un;
        //System.out.println(a);
		new Image2();  
        
	}
	public void paint(Graphics g) {  
		
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("2.png");  
        g.drawImage(i,0,0,700,700,this);  
          
    } 
     public Image2(){
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
						a[1][0]=e.getX();
						a[1][1]=e.getY();
						//System.out.println(a[1][0]+" "+a[1][1]);
						if(flag==1) {
							Image3.callme3(flag,a,name,uname);
							
						}
						else if(flag==2) {
							Image3.callmel3(flag,a,uname);
							
						}
						f.setVisible(false);
                }

            });
	 }
	/*public static void main(String[] args) {  
        
    }  */
  
}  