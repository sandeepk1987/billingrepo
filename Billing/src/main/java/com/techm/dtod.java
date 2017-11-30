package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class dtod extends JFrame// implements ActionListener
{
	String tp,dat;
	int t=0,i=0,j=0,in=0,k=0,cont=0,ix;
	int ite[]=new int[100];
	int cou[]=new int[100];
	float vcost,vtax,vtotal;
	Float to=new Float(0.00);
	JOptionPane jp = new JOptionPane();
	String ch[]={"Item id","Item Name","Cost","Tax","Count","total"};
		Object d[][]=new Object[50][6];//{{"muni","10"},{"TechM","55"}};
		JTable jt=new JTable(d,ch);;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(jt,v,h);
	public dtod()
	{
		
		
			
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void n2(int it[],int ct[],int in)//public static void main(String arg[])
	{
		//dat=dt;
		//day u=new day();
		setBounds(0,0,850,590);
		//u.show();
		cont=in;//jp.showMessageDialog(this,"Sorry,"+cont,"INFORMATION",jp.ERROR_MESSAGE);
		for(ix=0;ix<cont;ix++)
		{
			ite[ix]=it[ix];
			cou[ix]=ct[ix];
		}
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				for(k=0;k<cont;k++)
				{
				ResultSet rs = stm.executeQuery("select * from ITEM where id="+ite[k]);
				while(rs.next())
				{	
					t=1;	
		
			   		j=0;
					d[i][j]=rs.getString("id");j++;
					d[i][j]=rs.getString("name");j++;
					d[i][j]=vcost=rs.getInt("cost");j++;
					d[i][j]=vtax=rs.getInt("tax");j++;
					d[i][j]=cou[k];j++;
					vtax=vcost*(vtax/100);
					vtotal=cou[k]*(vcost+vtax);
					d[i][j]=vtotal;i++;
					
					to+=vtotal;
				}
				if(t==0)
				{
					jp.showMessageDialog(this,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}}d[i+1][4]="total";d[i+1][5]=to;
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
	}
	
}