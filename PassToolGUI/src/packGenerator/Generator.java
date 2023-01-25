package packGenerator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Generator extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2776311776960849963L;
	JLabel l01, l02, l03, l11, l12, l13, l14, l15, l21, l22, l23, l24, l25;
	JTextField tf1, tf2;
	JButton b01, b02, b1, b2;
	JFrame f3, f4, f5;
	
	public void generatewindow()
	{
		f3 = new JFrame();
		f3.setTitle("PassTool");
		f3.setSize(1000,700);
		f3.getContentPane().setLayout(null);
		f3.getContentPane().setBackground(Color.white);
		f3.setResizable(false);
		f3.setLocationRelativeTo(null);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    l01 = new JLabel("Password Generator");
		l01.setBounds(425,100,150,40);
		l02 = new JLabel("Password Generator generates valid random password");
		l02.setBounds(325,150,350,40);
		b01 = new JButton("Automatic Password Generator");
		b01.setBounds(360,250,250,40);
		b01.setFocusable(false);
		b02 = new JButton("Custom Password Generator");
		b02.setBounds(360,300,250,40);
		b02.setFocusable(false);
		
		f3.add(l01);
		f3.add(l02);
		f3.add(b01);
		f3.add(b02);
		
		b01.addActionListener(this);
		b02.addActionListener(this);
		
	    f3.setVisible(true);
	}
	
	public void autogen()
	{
		f4 = new JFrame();
		f4.setTitle("PassTool");
		f4.setSize(1000,700);
		f4.getContentPane().setLayout(null);
		f4.getContentPane().setBackground(Color.white);
		f4.setResizable(false);
		f4.setLocationRelativeTo(null);
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    l11 = new JLabel("Automatic Password Generator");
		l11.setBounds(425,100,200,40);
		l12 = new JLabel("Password Generator generates valid random password of given length");
		l12.setBounds(325,150,400,40);
		b1 = new JButton("Generate Password");
		b1.setBounds(380,250,250,40);
		b1.setFocusable(false);
		tf1 = new JTextField("Enter Password Length");
		tf1.setBounds(380,200,250,40);
		l13 = new JLabel("");
		l13.setBounds(360,300,350,40);
		l14 = new JLabel("");
		l14.setBounds(360,350,350,40);
		l15 = new JLabel("");
		l15.setBounds(380,400,350,40);
		
		f4.add(l11);
		f4.add(l12);
		f4.add(l13);
		f4.add(l14);
		f4.add(l15);
		f4.add(b1);
		f4.add(tf1);
		
		b1.addActionListener(this);

	    f4.setVisible(true);
	}
	
	public void customgen()
	{
		f5 = new JFrame();
		f5.setTitle("PassTool");
		f5.setSize(1000,700);
		f5.getContentPane().setLayout(null);
		f5.getContentPane().setBackground(Color.white);
		f5.setResizable(false);
		f5.setLocationRelativeTo(null);
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    l21 = new JLabel("Password Generator");
		l21.setBounds(425,100,150,40);
		l22 = new JLabel("Password Generator generates valid random password for given custom text");
		l22.setBounds(275,150,450,40);
		b2 = new JButton("Generate Password");
		b2.setBounds(375,250,250,40);
		b2.setFocusable(false);
		tf2 = new JTextField("Enter Custom Text");
		tf2.setBounds(375,200,250,40);
		l23 = new JLabel("");
		l23.setBounds(360,300,350,40);
		l24 = new JLabel("");
		l24.setBounds(360,350,350,40);
		l25 = new JLabel("");
		l25.setBounds(380,400,350,40);
		
		f5.add(l21);
		f5.add(l22);
		f5.add(l23);
		f5.add(l24);
		f5.add(l25);
		f5.add(b2);
		f5.add(tf2);
		
		b2.addActionListener(this);

	    f5.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b01)
		{
			Generator gra = new Generator();
	        gra.autogen();
		}
		else if(ae.getSource()==b02)
		{
			Generator grc = new Generator();
	        grc.customgen();
		}
		else if(ae.getSource()==b1)
		{
			l13.setVisible(false);
			l14.setVisible(false);
			l15.setVisible(false);
			int len = Integer.parseInt(tf1.getText());
			if(len<8)
			{
		        l13.setVisible(true);
			    l13.setForeground(Color.red);
				l13.setText("Password Length should be greater than or equal to 8");
			}
			if(len<4)
			{
				l14.setVisible(true);
				l14.setForeground(Color.red);
			    l14.setText("Not possible to generate password");
			    return;
			}
			String password = "";
			for(int i=0; i<len; i++)
			{
				password = password + (char)(int)(97+Math.random()*26);
			}
			 
			int CapNum = (int)(Math.random()*len/5)+1;
			int NumNum = (int)(Math.random()*len/5)+1;
			int SplNum = (int)(Math.random()*len/5)+1;
			    
			int CapPos[] = new int[CapNum];
			int NumPos[] = new int[NumNum];
			int SplPos[] = new int[SplNum];
			    
			for(int i=0; i<CapNum; i++)
			{
				CapPos[i]=(int)(Math.random()*len);
			}
			for(int i=0; i<NumNum; i++)
			{
				NumPos[i]=(int)(Math.random()*len);
			    for(int j=0; j<CapNum; j++)
			    {
			        while(NumPos[i]==CapPos[j])
			    	{
			    		NumPos[i]=(int)(Math.random()*len);
			    	}
			    }
			 }
			 for(int i=0; i<SplNum; i++)
			 {
				  SplPos[i]=(int)(Math.random()*len);
			      int j;
			      for(j=0;((j<CapNum)&&(j<NumNum)); j++)
			      {
			    	  while((SplPos[i]==CapPos[j])||(SplPos[i]==NumPos[j]))
			    	  {
			    		  SplPos[i]=(int)(Math.random()*len);
			    	  }
			      }
			      while(j<CapNum)
			      {
			    	  while(SplPos[i]==CapPos[j])
			    	  {
			    		  SplPos[i]=(int)(Math.random()*len);
			    	  }
			    	  j++;
			      }
			      while(j<NumNum)
			      {
			    	  while(SplPos[i]==NumPos[j])
			    	  {
			    		  SplPos[i]=(int)(Math.random()*len);
			    	  }
			    	  j++;
			      }
			  }
			    
			  String numStr = "0123456789";
			  String splStr = "!@#$%^&*";
			  for(int i=0; i<CapNum; i++)
			  {
				  password = password.substring(0,CapPos[i])+((char)(password.charAt(CapPos[i])-32))+password.substring(CapPos[i]+1);
			  }
			  for(int i=0; i<NumNum; i++)
			  {
				  password = password.substring(0,NumPos[i])+(numStr.charAt((int)(Math.random()*10)))+password.substring(NumPos[i]+1);
			  }
			  for(int i=0; i<SplNum; i++)
			  {
				  password = password.substring(0,SplPos[i])+(splStr.charAt((int)(Math.random()*8)))+password.substring(SplPos[i]+1);
			  }
			  l15.setVisible(true);
			  l15.setForeground(Color.blue);
			  l15.setText("Password: "+password); 
		}
		else if(ae.getSource()==b2)
		{
			l23.setVisible(false);
			l24.setVisible(false);
			l25.setVisible(false);
			int len = (tf2.getText()).length();
			if(len<8)
			{
		        l23.setVisible(true);
			    l23.setForeground(Color.red);
				l23.setText("Password Length should be greater than or equal to 8");
			}
			if(len<4)
			{
				l24.setVisible(true);
				l24.setForeground(Color.red);
			    l24.setText("Not possible to generate password");
			    return;
			}
			String password = tf2.getText();
			 
            int CapNum = (int)(Math.random()*len/5)+1;
            int NumNum = (int)(Math.random()*len/5)+1;
            int SplNum = (int)(Math.random()*len/5)+1;
            int SmlNum = (int)(Math.random()*len/5)+1;
            
            int CapPos[] = new int[CapNum];
            int NumPos[] = new int[NumNum];
            int SplPos[] = new int[SplNum];
            int SmlPos[] = new int[SmlNum];
            
            for(int i=0; i<CapNum; i++)
            {
            	CapPos[i]=(int)(Math.random()*len);
            }
            for(int i=0; i<NumNum; i++)
            {
            	NumPos[i]=(int)(Math.random()*len);
            	for(int j=0; j<CapNum; j++)
            	{
            		while(NumPos[i]==CapPos[j])
            		{
            			NumPos[i]=(int)(Math.random()*len);
            		}
            	}
            }
            for(int i=0; i<SplNum; i++)
            {
            	SplPos[i]=(int)(Math.random()*len);
            	int j;
            	for(j=0;((j<CapNum)&&(j<NumNum)); j++)
            	{
            		while((SplPos[i]==CapPos[j])||(SplPos[i]==NumPos[j]))
            		{
            			SplPos[i]=(int)(Math.random()*len);
            		}
            	}
            	while(j<CapNum)
            	{
            		while(SplPos[i]==CapPos[j])
            		{
            			SplPos[i]=(int)(Math.random()*len);
            		}
            		j++;
            	}
            	while(j<NumNum)
            	{
            		while(SplPos[i]==NumPos[j])
            		{
            			SplPos[i]=(int)(Math.random()*len);
            		}
            		j++;
            	}
            }
            for(int i=0; i<SmlNum; i++)
            {
            	SmlPos[i]=(int)(Math.random()*len);
            	int j;
            	for(j=0;((j<CapNum)&&(j<NumNum)); j++)
            	{
            		while((SmlPos[i]==CapPos[j])||(SmlPos[i]==NumPos[j]))
            		{
            			SmlPos[i]=(int)(Math.random()*len);
            		}
            	}
            	while(j<CapNum)
            	{
            		while(SmlPos[i]==CapPos[j])
            		{
            			SmlPos[i]=(int)(Math.random()*len);
            		}
            		j++;
            	}
            	while(j<NumNum)
            	{
            		while(SmlPos[i]==NumPos[j])
            		{
            			SmlPos[i]=(int)(Math.random()*len);
            		}
            		j++;
            	}
            	int k;
            	for(k=0; k<SplNum; k++)
            	{
            		while(SmlPos[i]==SplPos[k])
            		{
            			SmlPos[i]=(int)(Math.random()*len);
            		}
            	}
            }
            
            String numStr = "0123456789";
            String splStr = "!@#$%^&*";
            String capStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String smlStr = "abcdefghijklmnopqrstuvwxyz";
            for(int i=0; i<CapNum; i++)
            {
            	if(password.charAt(CapPos[i])>='a'&&password.charAt(CapPos[i])<='z')
            	{
            		password = password.substring(0,CapPos[i])+((char)(password.charAt(CapPos[i])-32))+password.substring(CapPos[i]+1);
            	}
            	else if(password.charAt(CapPos[i])>='A'&&password.charAt(CapPos[i])<='Z')
            	{
            		
            	}
            	else
            	{
            		password = password.substring(0,CapPos[i])+(capStr.charAt((int)(Math.random()*26)))+password.substring(CapPos[i]+1);
            	}
            }
            for(int i=0; i<NumNum; i++)
            {
            	if(password.charAt(NumPos[i])>='0'&&password.charAt(NumPos[i])<='9')
            	{
            		
            	}
            	else
            	{
            	    password = password.substring(0,NumPos[i])+(numStr.charAt((int)(Math.random()*10)))+password.substring(NumPos[i]+1);
            	}
            }
            for(int i=0; i<SplNum; i++)
            {
            	 password = password.substring(0,SplPos[i])+(splStr.charAt((int)(Math.random()*8)))+password.substring(SplPos[i]+1);
            }
            for(int i=0; i<SmlNum; i++)
            {
            	if(password.charAt(SmlPos[i])>='A'&&password.charAt(SmlPos[i])<='Z')
            	{
            		password = password.substring(0,SmlPos[i])+((char)(password.charAt(SmlPos[i])+32))+password.substring(SmlPos[i]+1);
            	}
            	else if(password.charAt(SmlPos[i])>='a'&&password.charAt(SmlPos[i])<='z')
            	{
            		
            	}
            	else
            	{
            		password = password.substring(0,SmlPos[i])+(smlStr.charAt((int)(Math.random()*26)))+password.substring(SmlPos[i]+1);
            	}
            }
            
			  l25.setVisible(true);
			  l25.setForeground(Color.blue);
			  l25.setText("Password: "+password); 
		}
	}
	
    public static void generateFun()
    {
    	Generator gr = new Generator();
        gr.generatewindow();
    }
}
