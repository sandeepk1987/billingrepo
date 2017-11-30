package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class erep extends JFrame// implements ActionListener
{
	
	int t=0,i=0,j=0,in=0,pr=0,tot;
	JOptionPane jp = new JOptionPane();
	int id[]=new int[100];
	String ch[]={"Employee Id","Employee Name","Total Days","Present Days"};
		Object d[][]=new Object[50][5];//{{"muni","10"},{"TechM","55"}};
		JTable jt=new JTable(d,ch);;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(jt,v,h);
	public erep()
	{
		
		
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from EMP");
			t=0;j=0;
			while(rs.next())
			{
			
				d[j][0]=id[in++]=rs.getInt("id");
				d[j++][1]=rs.getString("name");
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
			
		//jsp.setBounds(10,150,200,400);
		add(jsp);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void n1(String d1,String m1,String d2,String m2)//public static void main(String arg[])
	{
		//erep u=new erep();
		this.setBounds(0,0,850,590);
		this.show();
		
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select count(*) from e101 where (to_char(day,'mm') between "+m1+" and "+m2+")and(to_char(day,'dd') between "+d1+" and "+d2+")");
			t=0;j=0;
			while(rs.next())
			{
				
				tot=rs.getInt(1);
			}
			for(i=0;i<in;i++)
			d[j++][2]=tot;
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
				t=0;j=0;
				for(i=0;i<in;i++)
				{pr=0;
				ResultSet rs = stm.executeQuery("select * from e"+id[i]+" where (to_char(day,'mm') between "+m1+" and "+m2+")and(to_char(day,'dd') between "+d1+" and "+d2+")");
				while(rs.next())
				{	
					t=1;	
		
			   		
					pr+=rs.getInt("pre");
				}
				d[j++][3]=pr;
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
	}
	
}