package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class perm extends JFrame implements ActionListener
{
	JTextField uname,id;
	JLabel lname,lpass,lid;
	JPasswordField pass;
	boolean s[]=new boolean[15];
	Container c;
	JButton ch,cre,home;
	Integer tem=new Integer(0);
	JOptionPane jp = new JOptionPane();
	int t=0,in=0,i,x=70,y=140,flag=0;
	String na[]={"Add Item","Edit Item","Add Emp","Edit Emp","Genrate Bill","Cancel Bill","Pay bill","Day Wise Sale","Balence Stock","Day to Day Report","NIL Stock","Emp Attendence","Attendence Entry"};
	String tp;
	JCheckBox emid[]=new JCheckBox[15];
	public perm()
	{
		super("Permissions");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,600,400);
		lname = new JLabel("User Name :");  
		lname.setForeground(Color.black);
		lid = new JLabel("Id :");  
		lid.setForeground(Color.black);
		lpass = new JLabel("Password :");  
		lpass.setForeground(Color.black);
		uname = new JTextField(); 
		uname.setForeground(Color.black); 
		uname.setBackground(Color.white);
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		pass = new JPasswordField(); 
		pass.setForeground(Color.black); 
		pass.setBackground(Color.white);
		
		ch = new JButton("Change",new ImageIcon("image/other/New.GIF")); 
		ch.setForeground(Color.white); 
		ch.setBackground(new Color(128,0,0));
		ch.setToolTipText("To Change Permitions");
		cre = new JButton("Create",new ImageIcon("image/other/New.GIF")); 
		cre.setForeground(Color.white); 
		cre.setBackground(new Color(128,0,0));
		cre.setToolTipText("To Create Permition");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Go To Home");
		
		lid.setBounds(80,110,670,20);
		lname.setBounds(290,110,670,20);
		id.setBounds(110,110,150,20);
		uname.setBounds(370,110,150,20);
		lpass.setBounds(290,140,670,20);
		pass.setBounds(370,140,150,20);
		ch.setBounds(240,320,100,30);
		home.setBounds(350,320,100,30);
		cre.setBounds(130,320,100,30);
		ch.addActionListener(this);
		home.addActionListener(this);
		cre.addActionListener(this);
		c.add(lname);
		c.add(lpass);
		c.add(lid);
		c.add(id);
		c.add(pass);
		c.add(uname);
		c.add(ch);
		c.add(cre);
		c.add(home);
		for(i=0;i<13;i++)
		{
			
			emid[i]=new JCheckBox(na[i]);
		}
		for(i=0;i<13;i++)
		{
			emid[i].setBounds(x,y+=30,140,20);
			c.add(emid[i]);
			if(y>=280)
			{
				y=140;
				x+=150;
			}
		}
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
		if(source==ch)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				ResultSet rs1 = stm.executeQuery("select * from PERM where ="+id.getText());
				while(rs1.next())
				{	
					t=1;
				}
				if(t==1)
				{
					t=0;
					if((pass.getText()).length()!=0)
					{
							PreparedStatement ps=c.prepareStatement ("Update perm set pass=? where id="+id.getText());	
							ps.setString(2,pass.getText());	ps.executeUpdate();
					}
					jp.showMessageDialog(this,"Password Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
				}								
				else
				{
					jp.showMessageDialog(this,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
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
		if(source==cre)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;flag=0;
			ResultSet rs1 = stm.executeQuery("select * from EMP where id="+id.getText());
			while(rs1.next())
			{	
				t=1;
			}
			if(t==0)
			{
				jp.showMessageDialog(this,"Sorry, Not a Valied Employee Id","INFORMATION",jp.ERROR_MESSAGE);
				t=0;flag=1;
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
			if(flag==0)
			{
			if((uname.getText().length()!=0)&&(pass.getText().length()!=0))
			{
			try
			{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
				for(i=0;i<13;i++)
				s[i]=emid[i].isSelected();
				
				t=0;
				
				
				PreparedStatement ps  = c.prepareStatement("insert into perm values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,uname.getText());
				
				ps.setString(2,pass.getText());		
				if(s[1]==true)
				ps.setInt(3,1);	
				else
				ps.setInt(3,0);			
				if(s[2]==true)
				ps.setInt(4,1);	
				else
				ps.setInt(4,0);			
				if(s[3]==true)
				ps.setInt(5,1);	
				else
				ps.setInt(5,0);			
				if(s[4]==true)
				ps.setInt(6,1);	
				else
				ps.setInt(6,0);			
				if(s[5]==true)
				ps.setInt(7,1);	
				else
				ps.setInt(7,0);			
				if(s[6]==true)
				ps.setInt(8,1);	
				else
				ps.setInt(8,0);			
				if(s[7]==true)
				ps.setInt(9,1);	
				else
				ps.setInt(9,0);			
				if(s[8]==true)
				ps.setInt(10,1);	
				else
				ps.setInt(10,0);			
				if(s[9]==true)
				ps.setInt(11,1);	
				else
				ps.setInt(11,0);			
				if(s[10]==true)
				ps.setInt(12,1);	
				else
				ps.setInt(12,0);			
				if(s[11]==true)
				ps.setInt(13,1);	
				else
				ps.setInt(13,0);			
				if(s[12]==true)
				ps.setInt(14,1);	
				else
				ps.setInt(14,0);			
				if(s[13]==true)
				ps.setInt(15,1);	
				else
				ps.setInt(15,0);			
				ps.setString(16,id.getText());
				ps.executeUpdate();
				
				jp.showMessageDialog(this,"Permissions are Given ","SUCCESS",jp.INFORMATION_MESSAGE);
				
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
			else
			jp.showMessageDialog(this,"Please Fill User Name and Password","SUCCESS",jp.INFORMATION_MESSAGE);	
			}
		}
	}	
	public void n15()//public static void main(String arg[])
 	{
 		
		/*perm u=new perm();
		//u.setResizable(false);
		u.setBounds(0,0,600,400);
		u.show();*/
	 }
}