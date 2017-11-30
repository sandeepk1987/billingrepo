package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class canbill extends JFrame implements ActionListener
{
	JTextField id,name,pho,bill;
	Container c;
	int t=0,in=0,i;
	int it[]=new int[20];
	int ct[]=new int[20];
	int st[]=new int[20];
	JButton can,home;
	JLabel lid,lname,lpho,lbill;
	String tp;
	JOptionPane jp = new JOptionPane();
	public canbill()
	{
		super("Cancel Bill");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		lpho = new JLabel("Phone Number :");  
		lpho.setForeground(Color.black);
		lbill = new JLabel("Total Bill :");  
		lbill.setForeground(Color.black);
		
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);
		
		bill = new JTextField(); 
		bill.setForeground(Color.black); 
		bill.setBackground(Color.white);
		
		can = new JButton("Cancel Bill",new ImageIcon("image/other/New.GIF")); 
		can.setForeground(Color.white); 
		can.setBackground(new Color(128,0,0));
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		

		tp=JOptionPane.showInputDialog("Enter Id of Bill to Cancel");
		if(tp.length()==0)
		{
		}
		else
		{
		lid.setBounds(70,120,670,20);
		lname.setBounds(70,150,150,20);
		lpho.setBounds(70,180,150,20);
		lbill.setBounds(70,210,150,20);
		

		id.setBounds(190,120,150,20);
		name.setBounds(190,150,150,20);
		pho.setBounds(190,180,150,20);
		bill.setBounds(190,210,150,20);
		can.setToolTipText("To Cancel Bill");
		home.setToolTipText("Goto Home Page");
		can.setBounds(80,300,100,30);
		home.setBounds(200,300,100,30);

		can.addActionListener(this);
		home.addActionListener(this);

		c.add(lid);
		c.add(lname);
		c.add(lpho);
		c.add(lbill);
		
		c.add(id);
		c.add(name);
		c.add(pho);
		c.add(bill);
		
		c.add(can);
		c.add(home);
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				ResultSet rs = stm.executeQuery("select * from PBILL where billid="+tp);
				while(rs.next())
				{	
					t=1;	
		
			   
					id.setText(rs.getString("billid"));
					id.setEditable(false);
			        	name.setText(rs.getString("cus"));name.setEditable(false);
					pho.setText(rs.getString("pho"));pho.setEditable(false);
			        	bill.setText(rs.getString("price"));bill.setEditable(false);
				
			        
				}
				if(t==0)
				{
					jp.showMessageDialog(this,"Sorry, No Such Bill exisits","INFORMATION",jp.ERROR_MESSAGE);
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
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
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
		if(source==can)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				PreparedStatement ps  = c.prepareStatement("delete from bill where billid="+id.getText());
							
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
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				PreparedStatement ps  = c.prepareStatement("delete from pbill where billid="+id.getText());
				
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
			jp.showMessageDialog(this,"Bill Canceled Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
		}
	}	
	public void n6()//public static void main(String arg[])
 	{
 		
		/*canbill u=new canbill();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}