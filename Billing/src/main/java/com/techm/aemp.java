package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class aemp extends JFrame implements ActionListener
{
	JTextField id,name,dob,qual,job,sal,pho;
	Container c;
	JButton add,reset,home;
	int t=0,flag=0;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname,ldob,lqual,ljob,lsal,lpho;
	public aemp()
	{
		super("ADD Empolyee");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		ldob = new JLabel("Date Of Birth :");  
		ldob.setForeground(Color.black);
		lqual = new JLabel("Qualification :");  
		lqual.setForeground(Color.black);
		ljob = new JLabel("Job :");  
		ljob.setForeground(Color.black);
		lsal = new JLabel("Salary :");  
		lsal.setForeground(Color.black);
		lpho = new JLabel("Phone Number :");  
		lpho.setForeground(Color.black);
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		dob = new JTextField(); 
		dob.setForeground(Color.black); 
		dob.setBackground(Color.white);
		qual = new JTextField(); 
		qual.setForeground(Color.black); 
		qual.setBackground(Color.white);
		job = new JTextField(); 
		job.setForeground(Color.black); 
		job.setBackground(Color.white);
		sal = new JTextField(); 
		sal.setForeground(Color.black); 
		sal.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);
		
		
		add = new JButton("ADD",new ImageIcon("image/other/New.GIF")); 
		add.setForeground(Color.white); 
		add.setBackground(new Color(128,0,0));
		add.setToolTipText("To Add Item");
		reset = new JButton("Reset",new ImageIcon("image/other/New.GIF")); 
		reset.setForeground(Color.white); 
		reset.setBackground(new Color(128,0,0));
		reset.setToolTipText("To Reset Fields");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(240,320,70,30);
		home.addActionListener(this);
		c.add(home);
		lid.setBounds(70,110,670,20);
		lname.setBounds(70,140,150,20);
		ldob.setBounds(70,170,150,20);
		lqual.setBounds(70,200,150,20);
		ljob.setBounds(70,230,150,20);
		lsal.setBounds(70,260,150,20);
		lpho.setBounds(70,290,150,20);
		
		id.setBounds(190,110,150,20);
		name.setBounds(190,140,150,20);
		dob.setBounds(190,170,150,20);
		qual.setBounds(190,200,150,20);
		job.setBounds(190,230,150,20);
		sal.setBounds(190,260,150,20);
		pho.setBounds(190,290,150,20);

		add.setBounds(80,320,70,30);
		reset.setBounds(160,320,70,30);

		add.addActionListener(this);
		reset.addActionListener(this);

		c.add(lid);
		c.add(lname);
		c.add(ldob);	
		c.add(lqual);
		c.add(ljob);
		c.add(lsal);
		c.add(lpho);
		c.add(id);
		c.add(name);
		c.add(dob);
		c.add(qual);
		c.add(job);
		c.add(sal);
		c.add(pho);
		
		
		c.add(add);
		c.add(reset);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==add)
		{
			flag=0;
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
			if(pho.getText().length()!=10)
			jp.showMessageDialog(this,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
			else
			{
				ResultSet rs1 = stm.executeQuery("select * from EMP where id="+id.getText());
				while(rs1.next())
				{	
					t=1;
				}
				if(t==0)
				{
					t=0;
					PreparedStatement ps  = c.prepareStatement("insert into emp values(?,?,?,?,?,?,?)");
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
					if((dob.getText()).length()!=0)
					ps.setString(3,dob.getText());
					else
					ps.setString(3,"");
					if((qual.getText()).length()!=0)
					ps.setString(4,qual.getText());
					else
					ps.setString(4,"");
					if((job.getText()).length()!=0)
					ps.setString(5,job.getText());
					else
					ps.setString(5,"");
					if((sal.getText()).length()!=0)
					ps.setString(6,sal.getText());
					else
					ps.setString(6,"");
					if((pho.getText()).length()!=0)
					ps.setString(7,pho.getText());
					else
					ps.setString(7,"");
					
					ps.executeUpdate();
					jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
					flag=1;
				}
				else
				{
					jp.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",jp.ERROR_MESSAGE);
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
			if(flag==1)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
		
				PreparedStatement ps  = c.prepareStatement("create table e"+id.getText()+"(day date,pre number(20))");
				ps.executeUpdate();
				
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
		if(source==reset)
		{
			id.setEditable(true);
			name.setEditable(true);
			dob.setEditable(true);
			qual.setEditable(true);
			job.setEditable(true);
			sal.setEditable(true);
			pho.setEditable(true);

			id.setText(null);
			name.setText(null);
			dob.setText(null);
			qual.setText(null);
			job.setText(null);
			sal.setText(null);
			pho.setText(null);
		}
		if(source==home)
		{
			this.dispose();
			home t=new home();
			t.nn("","","","");
		}
	}	
	public void n3()//public static void main(String arg[])
 	{
 		
		/*aemp u=new aemp();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}