package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class gen extends JFrame implements ActionListener
{
	JTextField id,co,name,pho,bid,da;
	Container c;
	Integer i=new Integer(0);
	int t=0,cu=0;
	String ph,i1;
	int it[]=new int[50];
	int coun[]=new int[50];
	JButton add,reset,ge,home;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lco,lname,lpho,lbid,lda;
	public gen()
	{
		super("Generate Bill");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,500,500);
		lbid = new JLabel("Bill ID :");  
		lbid.setForeground(Color.black);
		lda = new JLabel("Date :");  
		lda.setForeground(Color.black);
		lid = new JLabel("Item ID :");  
		lid.setForeground(Color.black);
		lco = new JLabel("Count :");  
		lco.setForeground(Color.black);
		lname = new JLabel("Customer Name :");  
		lname.setForeground(Color.black);
		lpho = new JLabel("Phone No :");  
		lpho.setForeground(Color.black);
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		bid = new JTextField(); 
		bid.setForeground(Color.black); 
		bid.setBackground(Color.white);
		da = new JTextField(); 
		da.setForeground(Color.black); 
		da.setBackground(Color.white);
		co = new JTextField(); 
		co.setForeground(Color.black);
		co.setBackground(Color.white);
		co.setText("1");
		name = new JTextField(); 
		name.setForeground(Color.black); 
		name.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black);
		pho.setBackground(Color.white);

		add = new JButton("ADD",new ImageIcon("image/other/New.GIF")); 
		add.setForeground(Color.white); 
		add.setBackground(new Color(128,0,0));
		add.setToolTipText("Add Items To Bill");
		reset = new JButton("Next",new ImageIcon("image/other/New.GIF")); 
		reset.setForeground(Color.white); 
		reset.setBackground(new Color(128,0,0));
		reset.setToolTipText("Reset Item");
		ge = new JButton("Generate",new ImageIcon("image/other/New.GIF")); 
		ge.setForeground(Color.white); 
		ge.setBackground(new Color(128,0,0));
		ge.setToolTipText("Generate Bill");
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(230,350,100,30);
		home.addActionListener(this);
		c.add(home);
		lname.setBounds(80,140,670,20);
		lpho.setBounds(80,170,150,20);
		lda.setBounds(80,200,150,20);
		lid.setBounds(80,230,670,20);
		lbid.setBounds(80,110,670,20);
		lco.setBounds(80,260,150,20);

		name.setBounds(200,140,150,20);
		pho.setBounds(200,170,150,20);
		da.setBounds(200,200,150,20);
		id.setBounds(200,230,150,20);
		bid.setBounds(200,110,150,20);
		co.setBounds(200,260,150,20);

		ge.setBounds(90,350,100,30);
		add.setBounds(90,310,100,30);
		reset.setBounds(230,310,100,30);

		add.addActionListener(this);
		reset.addActionListener(this);
		ge.addActionListener(this);
		c.add(lid);
		c.add(lbid);
		c.add(lco);
		c.add(lda);
		c.add(id);
		c.add(bid);
		c.add(co);
		c.add(lname);
		c.add(lpho);
		c.add(name);
		c.add(pho);
		c.add(da);
		c.add(add);
		c.add(reset);
		c.add(ge);
			bid.setEditable(false);
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select max(BILLID) from BILL");
			t=0;
			while(rs.next())
			{
				t++;
				i=rs.getInt("MAX(BILLID)");
				i=i+1;
				//i1.toString(i);
			}
			if(t==0)
			bid.setText("1");
			else
			bid.setText(i.toString(i));
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
		if(source==add)
		{
			name.setEditable(false);
			pho.setEditable(false);
			da.setEditable(false);
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
			if(pho.getText().length()!=10&&pho.getText().length()!=0)
			jp.showMessageDialog(this,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
			else
			{	ResultSet rs1 = stm.executeQuery("select * from BILL where billid="+bid.getText()+"and itid="+id.getText());
				while(rs1.next())
				{	
					t=1;
				}
				if(t==0)
				{
					t=0;
				PreparedStatement ps  = c.prepareStatement("insert into bill values(?,?,?,?,?,?)");
				if((bid.getText()).length()!=0)
				ps.setString(1,bid.getText());
				else
				ps.setString(1,"");
				if((name.getText()).length()!=0)
				ps.setString(2,name.getText());	
				else
				ps.setString(2,"");	
				if((pho.getText()).length()!=0)
				ps.setString(3,pho.getText());
				else
				ps.setString(3,"");
				if((da.getText()).length()!=0)
				ps.setString(4,da.getText());
				else
				ps.setString(4,"");
				if((id.getText()).length()!=0)
				ps.setString(5,id.getText());
				else
				ps.setString(5,"");
				if((co.getText()).length()!=0)
				ps.setString(6,co.getText());
				else
				ps.setString(6,"");
								
				ps.executeUpdate();
				//jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
				
				it[cu]=Integer.parseInt(id.getText());
				coun[cu++]=Integer.parseInt(co.getText());

				}
				else
				{
					jp.showMessageDialog(this,"Sorry, Item ID is Already Entered","INFORMATION",jp.ERROR_MESSAGE);
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
		if(source==reset)
		{
			id.setEditable(true);
			id.setText(null);
		}
		if(source==ge)
		{
			//this.dispose();
			res u1=new res();
			u1.n1(it,coun,cu);
		}
	}	
	public void n5()//public static void main(String arg[])
 	{
 		
		/*gen u=new gen();
		//u.setResizable(false);
		u.setBounds(0,0,500,500);
		u.show();*/
	 }
}