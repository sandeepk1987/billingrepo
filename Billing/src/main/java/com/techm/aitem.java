package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class aitem extends JFrame implements ActionListener
{
	JTextField id,name,cost,tax,stock;
	Container c;
	JButton add,reset,home;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname,lcost,ltax,lstock;
	int t=0;
	public aitem()
	{
		super("ADD Item");
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
		
		add = new JButton("Add",new ImageIcon("image/other/New.GIF")); 
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
        	home.setBounds(240,300,70,30);
		home.addActionListener(this);
		c.add(home);
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
		
		add.setBounds(80,300,70,30);
		reset.setBounds(160,300,70,30);

		add.addActionListener(this);
		reset.addActionListener(this);

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
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
			Statement stm = c.createStatement();
			t=0;
			if(((tax.getText().length()!=0)&&(Integer.parseInt(tax.getText())>100||Integer.parseInt(tax.getText())<0)))
			jp.showMessageDialog(this,"Tax Must be in between 1 to 100","INFORMATION",jp.ERROR_MESSAGE);
			else
			{
				ResultSet rs1 = stm.executeQuery("select * from ITEM where id="+id.getText());
				while(rs1.next())
				{	
					t=1;
				}
				if(t==0)
				{
					t=0;
					PreparedStatement ps  = c.prepareStatement("insert into item values(?,?,?,?,?)");
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
					if((cost.getText()).length()!=0)
					ps.setString(3,cost.getText());
					else
					ps.setString(3,"");
					if((tax.getText()).length()!=0)
					ps.setString(4,tax.getText());
					else
					ps.setString(4,"");
					if((stock.getText()).length()!=0)
					ps.setString(5,stock.getText());
					else
					ps.setString(5,"");
					
					ps.executeUpdate();
					jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
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
 		}
		if(source==reset)
		{
			id.setEditable(true);
			name.setEditable(true);
			cost.setEditable(true);
			tax.setEditable(true);
			stock.setEditable(true);
			
			id.setText(null);
			name.setText(null);
			cost.setText(null);
			tax.setText(null);
			stock.setText(null);
			
		}
		if(source==home)
		{
			this.dispose();
			home t=new home();
			t.nn("","","","");
		}
	}	
	public void n1()//public static void main(String arg[])
 	{
 		
		/*aitem u=new aitem();
		//u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}