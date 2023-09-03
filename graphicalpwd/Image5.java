package graphicalpwd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.JFrame;
import java.util.ArrayList;
class Image5 extends Canvas //implements MouseListener
{  
	static int flag;
	static int a[][];
	static String name;
	static String uname;
	public static void callme5(int f,int ar[][],String n,String un){
		flag=f;
        //System.out.println(flag);
        a=ar;
        name=n;
        uname=un;
		new Image5();      
	}
	public static void callmel5(int f,int ar[][],String un){
		flag=f;
		 a=ar;
		uname=un;
        //System.out.println(a);
		new Image5();  
        
	}
	public void paint(Graphics g) {  
		
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("5.png");  
        g.drawImage(i,0,0,700,700,this);  
          
    } 
     public Image5(){
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
						a[4][0]=e.getX();
						a[4][1]=e.getY();
						if(flag==1) {
							StoreInDB.StoreClickPoints(a,name,uname);
							f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
						}
						else if(flag==2)
							AuthenticateUser.authenticate(a,uname);
						//System.out.println(a[4][0]+" "+a[4][1]);
						/*for(int i=0;i<5;i++)
							System.out.println(a[i][0]+" "+a[i][1]);*/
						//System.out.println(name);
						f.setVisible(false);
						
                }

            });
	 }
	/*public static void main(String[] args) {  
        
    }  */
  
}  