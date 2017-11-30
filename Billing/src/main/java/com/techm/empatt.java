package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class empatt extends JFrame implements ActionListener
{
	JTextField day;
	JLabel lday;
	boolean s[]=new boolean[50];
	Container c;
	JButton pr,home;
	Integer tem=new Integer(0);
	JOptionPane jp = new JOptionPane();
	int t=0,in=0,i,x=70,y=140;
	int id[]=new int[50];
	String tp;
	JCheckBox emid[]=new JCheckBox[50];
	public empatt()
	{
		super("Employee Attendence");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lday = new JLabel("Date :");  
		lday.setForeground(Color.black);
		day = new JTextField(); 
		day.setForeground(Color.black); 
		day.setBackground(Color.white);
		
		
		pr = new JButton("Present",new ImageIcon("image/other/New.GIF")); 
		pr.setForeground(Color.white); 
		pr.setBackground(new Color(128,0,0));
		pr.setToolTipText("Present Entry");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Go To Home");
		
		lday.setBounds(70,110,670,20);
		day.setBounds(190,110,150,20);

		pr.setBounds(80,320,100,30);
		home.setBounds(200,320,100,30);

		pr.addActionListener(this);
		home.addActionListener(this);

		c.add(lday);
		
		c.add(day);
		c.add(pr);
		c.add(home);
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from EMP");
			t=0;
			while(rs.next())
			{
				id[in++]=rs.getInt("id");
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
		
		for(i=0;i<in;i++)
		{
			tem=id[i];
			emid[i]=new JCheckBox(tem.toString(tem));
		}
		for(i=0;i<in;i++)
		{
			emid[i].setBounds(x,y+=30,50,20);
			c.add(emid[i]);
			if(y>=280)
			{
				y=140;
				x+=60;
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
		if(source==pr)
		{
			for(i=0;i<in;i++)
			{
			try
			{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
			
				s[i]=emid[i].isSelected();
				
				t=0;
				tem=id[i];
				
				PreparedStatement ps  = c.prepareStatement("insert into e"+id[i]+" values(?,?)");
				ps.setString(1,day.getText());
				if(s[i]==true)
				ps.setInt(2,1);	
				else
				ps.setInt(2,0);	
				ps.executeUpdate();
				if(s[i]==true)
				jp.showMessageDialog(this,id[i]+" is Present","SUCCESS",jp.INFORMATION_MESSAGE);
				else
				jp.showMessageDialog(this,id[i]+" is Absent","SUCCESS",jp.INFORMATION_MESSAGE);	
			
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
			}}
		}
	}	
	public void n13()//public static void main(String arg[])
 	{
 		
		/*empatt u=new empatt();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}