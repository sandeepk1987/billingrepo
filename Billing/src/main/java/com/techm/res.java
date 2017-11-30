package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class res extends JFrame// implements ActionListener
{
	JTextField name,pho,id,tot;
	JButton ok;
	JLabel lid,lname,lpho,ltot;
	int t=0,i=0,j=0,in,cont;
	int ite[]=new int[50];
	int cou[]=new int[50];
	float vcost,vtax,vtotal;
	Float to=new Float(0.00);
	String tp;
	JOptionPane jp = new JOptionPane();
		String ch[]={"Item id","Item Name","Cost","Tax","Count","total"};
		Object d[][]=new Object[20][7];//{{"muni","10"},{"TechM","55"}};
		JTable jt=new JTable(d,ch);;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(jt,v,h);

		
	public res()
	{
		super("Generate Bill");
		//setBounds(0,0,850,600);
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
		ok = new JButton("Ok",new ImageIcon("image/other/New.GIF")); 
		ok.setForeground(Color.black); 
		ok.setBackground(Color.gray);
		lname.setBounds(430,380,670,20);
		lpho.setBounds(430,410,150,20);
		lid.setBounds(430,440,670,20);
		ltot.setBounds(430,470,670,20);
		name.setBounds(550,380,150,20);
		pho.setBounds(550,410,150,20);
		id.setBounds(550,440,150,20);
		tot.setBounds(550,470,150,20);
		//ok.addActionListener(this);
		jt.setBounds(400,200,100,20);
		add(lid);
		add(tot);
		add(id);
		add(ltot);
		add(lname);
		add(lpho);
		add(name);
		add(pho);
		//add(ok);
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from BILL");
			t=0;
			while(rs.next())
			{
				t++;
				id.setText(rs.getString("billid"));
				name.setText(rs.getString("cus"));
				pho.setText(rs.getString("pho"));
				id.setEditable(false);
				name.setEditable(false);
				pho.setEditable(false);
				tot.setEditable(false);
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
		
		add(jsp);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void n1(int it[],int coun[],int cu)//public static void main(String arg[])
	{
		
		
		cont=cu;
		for(in=0;in<cont;in++)
		{
			ite[in]=it[in];
			cou[in]=coun[in];
		}
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				for(in=0;in<cont;in++)
				{
				ResultSet rs = stm.executeQuery("select * from ITEM where id="+ite[in]);
				while(rs.next())
				{	
					t=1;	
					j=0;
				
					d[i][j]=rs.getString("id");j++;
					d[i][j]=rs.getString("name");j++;
					d[i][j]=vcost=rs.getInt("cost");j++;
					d[i][j]=vtax=rs.getInt("tax");j++;
					d[i][j]=cou[in];j++;
					vtax=vcost*(vtax/100);
					vtotal=cou[in]*(vcost+vtax);
					d[i][j]=vtotal;i++;
					//name.setText(rs.getString("cus"));
					//pho.setText(rs.getString("pho"));
					to+=vtotal;
					
				}
				tot.setText(to.toString(to));
				if(t==0)
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
			jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
			System.out.println("Cnf Exception");
		}
		catch(SQLException sql)
		{
			jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
		}
		
		//res u=new res();
		setBounds(0,0,850,590);
		//u.show();
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
			PreparedStatement ps  = c.prepareStatement("insert into pbill values(?,?,?,?,?)");
			if((id.getText()).length()!=0)
			ps.setString(1,id.getText());
			else
			ps.setString(1,"");
			if((tot.getText()).length()!=0)
			ps.setString(2,tot.getText());	
			else
			ps.setString(2,"");	
			
			ps.setString(3,"No");
			if((name.getText()).length()!=0)
			ps.setString(4,name.getText());
			else
			ps.setString(4,"");
			if((pho.getText()).length()!=0)
			ps.setString(5,pho.getText());
			else
			ps.setString(5,"");
		
			ps.executeUpdate();
			//jp.showMessageDialog(this,"Bill Paid Amount is"+tp,"SUCCESS",jp.INFORMATION_MESSAGE);
								
			
			
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