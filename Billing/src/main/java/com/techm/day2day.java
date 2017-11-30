package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class day2day extends JFrame implements ActionListener
{
	JTextField day1,day2,id;
	Container c;
	int t=0,in=0,re,p;
	Integer mo1=new Integer(0);
	Integer mo2=new Integer(0);
	JButton sh,home,sha;
	JLabel lday1,lday2,lid;
	String tp;
	String mo[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	int it[]=new int[100];
	int ct[]=new int[100];
	Choice dob1,dob2,add1,add2;
	JOptionPane jp = new JOptionPane();
	public day2day()
	{
		super("Empolyee Attendence Report");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,400,400);
		
		lday1 = new JLabel("Day From :");  
		lday1.setForeground(Color.black);
		lday2 = new JLabel("Day To:");  
		lday2.setForeground(Color.black);
		
		
		day1 = new JTextField(); 
		day1.setForeground(Color.black); 
		day1.setBackground(Color.white);
		day2 = new JTextField(); 
		day2.setForeground(Color.black); 
		day2.setBackground(Color.white);
		sh = new JButton("Show",new ImageIcon("image/other/New.GIF")); 
		sh.setForeground(Color.white); 
		sh.setBackground(new Color(128,0,0));
		sh.setToolTipText("Show Report");
		
		home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
		home.setToolTipText("Go To Home");
		
		
		lday1.setBounds(100,150,670,20);
		lday2.setBounds(100,180,670,20);
		
		day1.setBounds(190,150,150,20);
		day2.setBounds(190,180,150,20);
		sh.setBounds(80,300,100,30);
		
		home.setBounds(200,300,100,30);
		
		sh.addActionListener(this);
		home.addActionListener(this);

		dob1 = new Choice();
		dob2 = new Choice();
		dob1.add("1");
		dob1.add("2");
		dob1.add("3");
		dob1.add("4");
		dob1.add("5");
		dob1.add("6");
		dob1.add("7");
		dob1.add("8");
		dob1.add("9");
		dob1.add("10");
		dob1.add("11");
		dob1.add("12");
		dob1.add("13");
		dob1.add("14");
		dob1.add("15");
		dob1.add("16");
		dob1.add("17");
		dob1.add("18");
		dob1.add("19");
		dob1.add("20");
		dob1.add("21");
		dob1.add("22");
		dob1.add("23");
		dob1.add("24");
		dob1.add("25");
		dob1.add("26");
		dob1.add("27");
		dob1.add("28");
		dob1.add("29");
		dob1.add("30");
		dob1.add("31");
		dob2.add("JAN");
		dob2.add("FEB");
		dob2.add("MAR");
		dob2.add("APR");
		dob2.add("MAY");
		dob2.add("JUN");
		dob2.add("JUL");
		dob2.add("AUG");
		dob2.add("SEP");
		dob2.add("OCT");
		dob2.add("NOV");
		dob2.add("DEC");
		dob1.setBounds(190,150,40,20);
		dob2.setBounds(250,150,55,20);
		add1 = new Choice();
		add2 = new Choice();
		
		add1.add("1");
		add1.add("2");
		add1.add("3");
		add1.add("4");
		add1.add("5");
		add1.add("6");
		add1.add("7");
		add1.add("8");
		add1.add("9");
		add1.add("10");
		add1.add("11");
		add1.add("12");
		add1.add("13");
		add1.add("14");
		add1.add("15");
		add1.add("16");
		add1.add("17");
		add1.add("18");
		add1.add("19");
		add1.add("20");
		add1.add("21");
		add1.add("22");
		add1.add("23");
		add1.add("24");
		add1.add("25");
		add1.add("26");
		add1.add("27");
		add1.add("28");
		add1.add("29");
		add1.add("30");
		add1.add("31");
		add2.add("JAN");
		add2.add("FEB");
		add2.add("MAR");
		add2.add("APR");
		add2.add("MAY");
		add2.add("JUN");
		add2.add("JUL");
		add2.add("AUG");
		add2.add("SEP");
		add2.add("OCT");
		add2.add("NOV");
		add2.add("DEC");
		add1.setBounds(190,180,40,20);
		add2.setBounds(250,180,55,20);

		
		c.add(lday1);
		c.add(lday2);
		//c.add(day1);
		
		//c.add(day1);
		//c.add(day2);
		c.add(sh);
		
		c.add(home);
		c.add(dob1);
		c.add(dob2);
		c.add(add1);
		c.add(add2);
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
		if(source==sh)
		{
			for(p=0;p<12;p++)
			{
				if(mo[p]==dob2.getSelectedItem())
				mo1=p+1;
				if(mo[p]==add2.getSelectedItem())
				mo2=p+1;
			}
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;in=0;
				ResultSet rs = stm.executeQuery("select * from BILL where (to_char(day,'mm') between "+mo1+" and "+mo2+")and(to_char(day,'dd') between "+dob1.getSelectedItem()+"and "+add1.getSelectedItem()+")");
				while(rs.next())
				{	
					t=1;	
				
			   		it[in]=rs.getInt("itid");
					ct[in++]=rs.getInt("count");
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
			
			//this.dispose();
			dtod t=new dtod();
			t.n2(it,ct,in);
		}
		
	}	
	public void n10()//public static void main(String arg[])
 	{
 		
		/*day2day u=new day2day();
		//u.setResizable(true);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}