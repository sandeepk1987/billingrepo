package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class eemp extends JFrame implements ActionListener
{
	JTextField id,name,dob,qual,job,sal,pho;
	Container c;
	JButton ch,home;
	JOptionPane jp = new JOptionPane();
	int t=0;
	String tp;
	JLabel lid,lname,ldob,lqual,ljob,lsal,lpho;
	public eemp()
	{
		super("Edit Empolyee");
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
		
		tp=JOptionPane.showInputDialog("Enter Id of Student");
		if(tp.length()==0)
		{
		}
		else
		{
		ch = new JButton("Change",new ImageIcon("image/other/New.GIF")); 
		ch.setForeground(Color.white); 
		ch.setBackground(new Color(128,0,0));
		ch.setToolTipText("To Change Data");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Go To Home");
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

		ch.setBounds(80,320,100,30);
		home.setBounds(200,320,100,30);

		ch.addActionListener(this);
		home.addActionListener(this);

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
		
		
		c.add(ch);
		c.add(home);
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;
				ResultSet rs = stm.executeQuery("select * from EMP where id="+tp);
				while(rs.next())
				{	
					t=1;	
		
			   
					id.setText(rs.getString("id"));
					id.setEditable(false);
			        	name.setText(rs.getString("name"));
					dob.setText(rs.getString("dob"));
			        	qual.setText(rs.getString("qual"));
					job.setText(rs.getString("job"));
					sal.setText(rs.getString("sal"));
					pho.setText(rs.getString("pho"));
			        
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
	}}
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
				if(pho.getText().length()!=10)
				jp.showMessageDialog(this,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
				else
				{
					ResultSet rs1 = stm.executeQuery("select * from EMP where id="+id.getText());
					while(rs1.next())
					{	
						t=1;
					}
					if(t==1)
					{
						t=0;
						if((name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set name=? where id="+id.getText());	
							ps.setString(1,name.getText());	ps.executeUpdate();
						}
						if((dob.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set dob=? where id="+id.getText());	
							ps.setString(1,dob.getText());ps.executeUpdate();
						}
						if((qual.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set qual=? where id="+id.getText());	
							ps.setString(1,qual.getText());ps.executeUpdate();
						}
						
						if((job.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set job=? where id="+id.getText());	
							ps.setString(1,job.getText());ps.executeUpdate();
						}
						if((sal.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set sal=? where id="+id.getText());	
							ps.setString(1,sal.getText());ps.executeUpdate();
						}
						
						if((pho.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set pho=? where id="+id.getText());	
							ps.setString(1,pho.getText());ps.executeUpdate();
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
	public void n4()//public static void main(String arg[])
 	{
 		
		/*eemp u=new eemp();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}