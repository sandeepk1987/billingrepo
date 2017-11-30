package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class paybill extends JFrame implements ActionListener
{
	JTextField id,name,pho,bill;
	Container c;
	int t=0,in=0,i,flag=0;
	int it[]=new int[20];
	int ct[]=new int[20];
	int st[]=new int[20];
	JButton pay,home;
	JLabel lid,lname,lpho,lbill;
	String tp;
	JOptionPane jp = new JOptionPane();
	public paybill()
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
		
		pay = new JButton("Pay Bill",new ImageIcon("image/other/New.GIF")); 
		pay.setForeground(Color.white); 
		pay.setBackground(new Color(128,0,0));
		pay.setToolTipText("To Pay Bill");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Goto Home Page");
		

		tp=JOptionPane.showInputDialog("Enter Id of Bill id  to Pay");
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
		
		
		pay.setBounds(80,300,100,30);
		home.setBounds(200,300,100,30);

		pay.addActionListener(this);
		home.addActionListener(this);

		c.add(lid);
		c.add(lname);
		c.add(lpho);
		c.add(lbill);
		
		c.add(id);
		c.add(name);
		c.add(pho);
		c.add(bill);
		
		c.add(pay);
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
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;in=0;
				ResultSet rs = stm.executeQuery("select * from BILL where billid="+id.getText());
				while(rs.next())
				{	
					t=1;	
		
			   
					it[in]=rs.getInt("itid");
					ct[in++]=rs.getInt("count");
							        
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
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				for(i=0;i<in;i++)
				{
				ResultSet rs = stm.executeQuery("select * from ITEM where id="+it[i]);
				while(rs.next())
				{	
					t=1;	
		
			   
					st[i]=rs.getInt("stock")-ct[i];
							        
				}
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
		if(source==pay)
		{
			flag=0;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;flag=0;
				ResultSet rs = stm.executeQuery("select * from PBILL where billid="+tp);
				while(rs.next())
				{	
					if("yes".equals(rs.getString("paid")))
					flag=1;	
					
			   
					
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
		if(flag==0)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				PreparedStatement ps=c.prepareStatement ("Update pbill set paid=? where billid="+id.getText());	
				ps.setString(1,"yes");	ps.executeUpdate();
			
			
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
				for(i=0;i<in;i++)
				{
				PreparedStatement ps=c.prepareStatement ("Update item set stock=? where id="+it[i]);	
				ps.setInt(1,st[i]);	ps.executeUpdate();
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
			jp.showMessageDialog(this,"Bill Paid Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
		}
		else
		jp.showMessageDialog(this,"Sorry,Bill is Alredy Paid","INFORMATION",jp.ERROR_MESSAGE);
		}
	}	
	public void n7()//public static void main(String arg[])
 	{
 		
		/*paybill u=new paybill();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}