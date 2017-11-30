package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class login extends JFrame implements ActionListener
{
	JTextField uname,id;
	JPasswordField pass;
	Container c;
	JButton enter,exit;
	JLabel luname,lpass,ltype,lid;
	JOptionPane jp = new JOptionPane();
	Choice ctype;
	String tu,p,pe;
	public login()
	{
		super("Billing Project               ::TechM PROJECTS::");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		
		ltype= new JLabel("User Type :"); 
		ltype.setForeground(Color.black);
		ltype.setBounds(80,100,220,20);
		c.add(ltype);
		lid= new JLabel("Id :"); 
		lid.setForeground(Color.black);
		lid.setBounds(80,250,220,20);
		c.add(lid);
		JLabel luname = new JLabel("User Name :"); 
		luname.setForeground(Color.black);
		luname.setBounds(80,150,220,20);
		c.add(luname);
		JLabel lpass = new JLabel("Password :"); 
		lpass.setForeground(Color.black);
		lpass.setBounds(80,200,220,20);
		c.add(lpass);
		ctype = new Choice();
		ctype.add("admin");
		ctype.add("other");
		ctype.setBounds(160,105,80,30);
		c.add(ctype);
		
		id = new JTextField();
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		id.setBounds(160,250,180,25);
		c.add(id);
		uname = new JTextField();
		uname.setForeground(Color.black); 
		uname.setBackground(Color.white);
		uname.setBounds(160,150,180,25);
		c.add(uname);
		pass = new JPasswordField();
		pass.setForeground(Color.black); 
		pass.setBackground(Color.white);
		pass.setBounds(160,200,180,25);
		c.add(pass);
		
		enter = new JButton("Enter"); 
		enter.setForeground(Color.white); 
		enter.setBackground(new Color(128,0,0));
		enter.setToolTipText("Login in to Project");
		enter.setBounds(130,300,100,30);
		enter.addActionListener(this);
		c.add(enter);

		exit = new JButton("Exit"); 
		exit.setForeground(Color.white);
		exit.setBackground(new Color(128,0,0));
		exit.setBounds(240,300,100,30);
		exit.addActionListener(this);
		c.add(exit);
				
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==enter)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			pe=ctype.getSelectedItem();
			if(pe.equals("admin"))
			{
			ResultSet rs = stm.executeQuery("select * from PASS");
			while(rs.next()){
			tu=rs.getString(1);
			p=rs.getString(2);
			}
			if((tu.equals(uname.getText()))&&(p.equals(pass.getText())))
			{
				
				this.dispose();
				home p1=new home();
				p1.nn(pe,uname.getText(),pass.getText(),id.getText());
				//jp.showMessageDialog(this,"Login Completed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			}
			else
			jp.showMessageDialog(this,"Sorry, User Name or Password is Wrong","WARRNING",jp.ERROR_MESSAGE);
			}
			else
			{
			ResultSet rs1 = stm.executeQuery("select * from PERM");
			while(rs1.next()){
			tu=rs1.getString(1);
			p=rs1.getString(2);
			}
			if((tu.equals(uname.getText()))&&(p.equals(pass.getText())))
			{
				this.dispose();
				home p1=new home();
				p1.nn(pe,uname.getText(),pass.getText(),id.getText());
				//jp.showMessageDialog(this,"Login Completed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			}
			else
			jp.showMessageDialog(this,"Sorry, User Name or Password is Wrong","WARRNING",jp.ERROR_MESSAGE);
			}
			c.close();
			stm.close();
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
 		}
		if(source==exit)
		{
			System.exit(0);
		}
	}	
	public static void main(String arg[])
 	{
 		
		 login u=new login();
		//u.setResizable(false);
		u.setBounds(0,0,450,450);
		u.show();
	 }
}