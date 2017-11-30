package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class tab extends JFrame// implements ActionListener
{
	JTextField name,pho,id,tot;

	JLabel lid,lname,lpho,ltot;
	int t=0,i=0,j=0;
	JOptionPane jp = new JOptionPane();
	public tab()
	{
		
		String ch[]={"Item id","Item Name","Cost","Tax","Count","Total"};
		Object d[][]=new Object[5][6];//{{"muni","10"},{"TechM","55"}};
		JTable jt=new JTable(d,ch);;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(jt,v,h);

		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Customer Name :");  
		lname.setForeground(Color.black);
		lpho = new JLabel("Phone No :");  
		lpho.setForeground(Color.black);
		ltot = new JLabel("Total Amount :");  
		ltot.setForeground(Color.black);
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black); 
		name.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black);
		pho.setBackground(Color.white);
		tot = new JTextField(); 
		tot.setForeground(Color.black);
		tot.setBackground(Color.white);
		
		lname.setBounds(70,110,670,20);
		lpho.setBounds(70,140,150,20);
		lid.setBounds(70,170,670,20);
		ltot.setBounds(70,170,670,20);
		name.setBounds(190,110,150,20);
		pho.setBounds(190,140,150,20);
		id.setBounds(190,170,150,20);
		tot.setBounds(190,170,150,20);
		
		
		add(lid);
		add(tot);
		add(id);
		add(tot);
		add(lname);
		add(lpho);
		add(name);
		add(pho);
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				ResultSet rs = stm.executeQuery("select * from ITEM");
				while(rs.next())
				{	
					t=1;	
		
			   		j=0;
					d[i][j]=rs.getString("name");j++;
					d[i][j]=rs.getString("rol");i++;
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
		//jsp.setBounds(10,150,200,400);
		add(jsp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arg[])
	{
		tab u=new tab();
		u.setBounds(0,0,850,590);
		u.show();
	}
	
}