package packValidate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Validator extends JFrame implements ActionListener
{
	//passTool pt = new passTool();
    //pt.automaticwindow();
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField tf;
	JButton b;
	JFrame f2;
	
	public void validwindow()
	{
    	f2 = new JFrame();
		f2.setTitle("PassTool");
		f2.setSize(1000,800);
		f2.getContentPane().setLayout(null);
		f2.getContentPane().setBackground(Color.white);
		f2.setResizable(false);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        l1 = new JLabel("Password Validator");
		l1.setBounds(425,100,150,40);
		l2 = new JLabel("Password Validator validates/invalidates random password");
		l2.setBounds(325,150,350,40);
		b = new JButton("Validate Password");
		b.setBounds(380,250,200,40);
		b.setFocusable(false);
		tf = new JTextField("Enter Password");
		tf.setBounds(380,200,200,40);
		l3 = new JLabel("");
		l3.setBounds(350,300,350,40);
		l4 = new JLabel("");
		l4.setBounds(350,350,350,40);
		l5 = new JLabel("");
		l5.setBounds(350,400,375,40);
		l6 = new JLabel("");
		l6.setBounds(350,450,350,40);
		l7 = new JLabel("");
		l7.setBounds(350,500,350,40);
		l8 = new JLabel("");
		l8.setBounds(350,600,350,40);
		
		f2.add(l1);
		f2.add(l2);
		f2.add(l3);
		f2.add(l4);
		f2.add(l5);
		f2.add(l6);
		f2.add(l7);
		f2.add(l8);
		f2.add(b);
		f2.add(tf);
		
        b.addActionListener(this);

        f2.setVisible(true);
	}
	
    public static void validFun()
    {
        Validator vr = new Validator();
        vr.validwindow();
    }
    
    public void actionPerformed(ActionEvent ae)
	{
    	String password = tf.getText();
    	
    	int flagLen = 0;
        int flagCap = 0;
        int flagLow = 0;
        int flagNum = 0;
        int flagSpl = 0;
        int valid = 0;
        
    	if(password.length()>=8)
        {
            flagLen = 1;
        }
        for(int i=0; i<password.length(); i++)
        {
            if(password.charAt(i)>='a'&&password.charAt(i)<='z')
            {
                flagLow = 1;
            }
            else if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
            {
                flagCap = 1;
            }
            else if(password.charAt(i)>='0'&&password.charAt(i)<='9')
            {
                flagNum = 1;
            }
            else
            {
                flagSpl = 1;
            }
        }

        if((flagLen==1)&&(flagLow==1)&&(flagCap==1)&&(flagNum==1)&&(flagSpl==1))
        {
            valid = 1;
        }

        if(flagLen==1)
        {
        	l3.setForeground(Color.green);
            l3.setText('\u2713'+" Password Length is good");
        }
        else
        { 
        	l3.setForeground(Color.red);
            l3.setText('\u274C'+" Password Length should be greater than or equal to 8");
        }
        if(flagLow==1)
        {
        	l4.setForeground(Color.green);
            l4.setText('\u2713'+" Password contains a lowercase character");
        }
        else
        { 
        	l4.setForeground(Color.red);
            l4.setText('\u274C'+" Password must contain a lowercase character");
        }
        if(flagCap==1)
        {
        	l5.setForeground(Color.green);
            l5.setText('\u2713'+" Password contains an uppercase character/capital letter");
        }
        else
        { 
        	l5.setForeground(Color.red);
            l5.setText('\u274C'+" Password must contain an uppercase character/capital letter");
        }
        if(flagNum==1)
        {
        	l6.setForeground(Color.green);
            l6.setText('\u2713'+" Password contains a number");
        }
         else
         { 
        	 l6.setForeground(Color.red);
             l6.setText('\u274C'+" Password must contain a number");
         }
         if(flagSpl==1)
         {
        	 l7.setForeground(Color.green);
             l7.setText('\u2713'+" Password contains special character");
         }
         else
         { 
        	 l7.setForeground(Color.red);
             l7.setText('\u274C'+" Password must contain special charatcter");
         }
         if(valid==1)
         {
        	 l8.setForeground(Color.green);
             l8.setText('\u2713'+" Password is valid");
         }
         else
         { 
        	 l8.setForeground(Color.red);
             l8.setText('\u274C'+" Password is invalid");
         }
	}
}