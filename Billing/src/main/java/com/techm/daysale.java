package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class daysale extends JFrame implements ActionListener
{
	JTextField day;
	Container c;
	int t=0,in=0;
	JButton sh,home;
	JLabel lday;
	String tp;
	int it[]=new int[100];
	int ct[]=new int[100];
	JOptionPane jp = new JOptionPane();
	public daysale()
	{
		super("Day Wise Sale Report");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lday = new JLabel("day :");  
		lday.setForeground(Color.black);
		
		
		day = new JTextField(); 
		day.setForeground(Color.black); 
		day.setBackground(Color.white);
		
		sh = new JButton("Show",new ImageIcon("image/other/New.GIF")); 
		sh.setForeground(Color.white); 
		sh.setBackground(new Color(128,0,0));
		sh.setToolTipText("Show Reports");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Goto Home Page");

		lday.setBounds(100,150,670,20);
		
		day.setBounds(190,150,150,20);
		
		sh.setBounds(80,300,100,30);
		home.setBounds(200,300,100,30);

		sh.addActionListener(this);
		home.addActionListener(this);

		c.add(lday);
		
		c.add(day);
		
		c.add(sh);
		c.add(home);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==home)
		{
			this.dispose();
			home t=new home();
			t.nn("","","","");
		}
		if(source==sh)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				ResultSet rs = stm.executeQuery("select * from BILL where day='"+day.getText()+"'");
				while(rs.next())
				{	
					t=1;	
				
			   		it[in]=rs.getInt("itid");
					ct[in++]=rs.getInt("count");
				}
				if(t==0)
				{
					jp.showMessageDialog(this,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
		        	c.close();
				stm.close();
		}
		catch(ClassNotFoundException cnf)
		{
			jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
			System.out.println("Cnf Exception");
		}
		catch(SQLException sql)
		{
			jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
		}
			//this.dispose();
			day u1=new day();
			u1.n1(it,ct,in);
		}
	}	
	public void n8()//public static void main(String arg[])
 	{
 		
		/*daysale u=new daysale();
		//u.setResizable(true);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}