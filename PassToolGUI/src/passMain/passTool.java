package passMain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import packGenerator.Generator;
import packValidate.Validator;

public class passTool extends JFrame implements ActionListener
{
	JLabel l;
	JButton b1, b2;
	
	public void mainwindow()
	{
		JFrame f1 = new JFrame();
		f1.setTitle("PassTool");
		f1.setSize(400,400);
		f1.getContentPane().setLayout(null);
		f1.getContentPane().setBackground(Color.white);
		f1.setResizable(false);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l = new JLabel("PassTool");
		l.setBounds(160,100,100,50);
		b1 = new JButton("Password Validator");
		b1.setBounds(90,150,200,40);
		b1.setFocusable(false);
		b2 = new JButton("Password Generator");
		b2.setBounds(90,200,200,40);
		b2.setFocusable(false);
		
		f1.add(l);
		f1.add(b1);
		f1.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f1.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals("Password Validator"))
		{
			Validator.validFun();
		}
		if(str.equals("Password Generator"))
		{
			Generator.generateFun();
		}
	}
	
    public static void main(String[] args)
    {
       passTool pt = new passTool();
       pt.mainwindow();
    }
}