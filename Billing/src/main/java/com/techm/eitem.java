package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class eitem extends JFrame implements ActionListener
{
	JTextField id,name,cost,tax,stock;
	Container c;
	int t=0;
	JButton ch,home;
	JLabel lid,lname,lcost,ltax,lstock;
	String tp;
	JOptionPane jp = new JOptionPane();
	public eitem()
	{
		super("EDIT Item");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		lcost = new JLabel("Cost :");  
		lcost.setForeground(Color.black);
		ltax = new JLabel("Tax (%):");  
		ltax.setForeground(Color.black);
		lstock = new JLabel("Stock :");  
		lstock.setForeground(Color.black);
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		cost = new JTextField(); 
		cost.setForeground(Color.black); 
		cost.setBackground(Color.white);
		tax = new JTextField(); 
		tax.setForeground(Color.black); 
		tax.setBackground(Color.white);
		stock = new JTextField(); 
		stock.setForeground(Color.black); 
		stock.setBackground(Color.white);
		
		ch = new JButton("Change",new ImageIcon("image/other/New.GIF")); 
		ch.setForeground(Color.white); 
		ch.setBackground(new Color(128,0,0));
		ch.setToolTipText("To Change data");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Go To Home");

		tp=JOptionPane.showInputDialog("Enter Id of Student");
		if(tp.length()==0)
		{
		}
		else
		{
		lid.setBounds(70,120,670,20);
		lname.setBounds(70,150,150,20);
		lcost.setBounds(70,180,150,20);
		ltax.setBounds(70,210,150,20);
		lstock.setBounds(70,240,150,20);

		id.setBounds(190,120,150,20);
		name.setBounds(190,150,150,20);
		cost.setBounds(190,180,150,20);
		tax.setBounds(190,210,150,20);
		stock.setBounds(190,240,150,20);
		
		ch.setBounds(80,300,100,30);
		home.setBounds(200,300,100,30);

		ch.addActionListener(this);
		home.addActionListener(this);

		c.add(lid);
		c.add(lname);
		c.add(lcost);
		c.add(ltax);
		c.add(lstock);
		c.add(id);
		c.add(name);
		c.add(cost);
		c.add(tax);
		c.add(stock);
		c.add(ch);
		c.add(home);
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				ResultSet rs = stm.executeQuery("select * from ITEM where id="+tp);
				while(rs.next())
				{	
					t=1;	
		
			   
					id.setText(rs.getString("id"));
					id.setEditable(false);
			        	name.setText(rs.getString("name"));
					cost.setText(rs.getString("cost"));
			        	tax.setText(rs.getString("tax"));
					stock.setText(rs.getString("stock"));
			        
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
		if(source==ch)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				if((Integer.parseInt(tax.getText())<0)||(Integer.parseInt(tax.getText())>100))
				jp.showMessageDialog(this,"Tax Between 1-99 %","INFORMATION",jp.ERROR_MESSAGE);
				else
				{
					ResultSet rs1 = stm.executeQuery("select * from ITEM where id="+id.getText());
					while(rs1.next())
					{	
						t=1;
					}
					if(t==1)
					{
						t=0;
						if((name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update item set name=? where id="+id.getText());	
							ps.setString(1,name.getText());	ps.executeUpdate();
						}
						if((cost.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update item set cost=? where id="+id.getText());	
							ps.setString(1,cost.getText());ps.executeUpdate();
						}
						if((tax.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update item set tax=? where id="+id.getText());	
							ps.setString(1,tax.getText());ps.executeUpdate();
						}
						
						if((stock.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update item set stock=? where id="+id.getText());	
							ps.setString(1,stock.getText());ps.executeUpdate();
						}
						
						jp.showMessageDialog(this,"Record Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
												
					}
					else
					{
						jp.showMessageDialog(this,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
						t=0;
		
					}
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
	}	
	public void n2()//public static void main(String arg[])
 	{
 		
		/*eitem u=new eitem();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}