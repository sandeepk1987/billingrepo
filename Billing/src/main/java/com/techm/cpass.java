package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
//import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class cpass extends JFrame implements ActionListener
{
	JTextField qu1,ex1,rat1,qu2,qu3,uname,ge,yr1,un,id,name,fn,as,as1,jo1,ge1,d1,q1,dob,ad,al,cj,cj1,ex,qu,phno,padd,eadd,p1,p2,p3,p4,p5,p6,p7,pp1,pp2,pp3,do1,do2,do3,ad1,ad2,ad3,al1,al2,al3;
	TextField opd,cpd,npd,pa;
	Container c;
	
	JButton cdok,log,sub,home;
	JLabel luname,lopd,lnpd,lcpd,lqu1,lqu2,lqu3;
	JOptionPane jp = new JOptionPane();
	
	
	int f=0,t=0,a1,a2,a3;
	
	public cpass()
	{
		super("Change Password");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,510,600);
		
		
		ImageIcon college = new ImageIcon("image/other/CDLABEL.gif");
		JLabel colLogo = new JLabel(college);
		colLogo.setBounds(0,0,500,100);
		c.add(colLogo);
		
		
			ImageIcon backg = new ImageIcon("image/other/CDLABEL.GIF");
			JLabel cdlogo = new JLabel(backg);
			c.add(cdlogo);  
			lqu1 = new JLabel("Q1: What Is Your Pet Name ?"); lqu1.setForeground(Color.black);
			lqu2 = new JLabel("Q2: Who Is Your Best Friend ?"); lqu2.setForeground(Color.black);
			lqu3 = new JLabel("Q3: What Is Your Luky Number ?"); lqu3.setForeground(Color.black);
			qu1 = new JTextField();
			qu2 = new JTextField();
			qu3 = new JTextField();
				
			luname = new JLabel("User Name :"); luname.setForeground(Color.black);
			lopd = new JLabel("Old Password :"); lopd.setForeground(Color.black);
			lnpd = new JLabel("New Password :"); lnpd.setForeground(Color.black);		
			lcpd = new JLabel("Conform Password :");	lcpd .setForeground(Color.black);
			uname = new JTextField();
			opd = new TextField();
			npd = new TextField();
			cpd = new TextField();
			opd.setEchoChar('$');
			cpd.setEchoChar('$');
			npd.setEchoChar('$');
			cdok = new JButton("Ok",new ImageIcon("image/other/tick.PNG"));cdok.setForeground(Color.white); cdok.setBackground(new Color(128,0,0));
			c.add(lqu1);
			cdok.setToolTipText("To Change Password");
			c.add(lqu2);
			c.add(lqu3);
			c.add(qu1);
			c.add(qu2);
			c.add(qu3);
			c.add(luname);
			c.add(lopd);
			c.add(lnpd);
			c.add(lcpd);
			c.add(uname);
			c.add(opd);
			c.add(npd);
			c.add(cpd);
			c.add(cdok);
			//cdlogo.setBounds(0,0,500,100);
			lqu1.setBounds(100,120,210,25);
			lqu2.setBounds(100,180,210,25);
			lqu3.setBounds(100,240,210,25);
			qu1.setBounds(100,150,150,25);
			qu2.setBounds(100,210,150,25);
			qu3.setBounds(100,270,150,25);
			luname.setBounds(50,320,210,25);
			lopd.setBounds(50,350,210,25);
			lnpd.setBounds(50,380,210,25);
			lcpd.setBounds(50,410,210,25);
			uname.setBounds(170,320,150,25);
			opd.setBounds(170,350,150,25);
			npd.setBounds(170,380,150,25);
			cpd.setBounds(170,410,150,25);
			cdok.setBounds(130,480,98,25);
			cdok.addActionListener(this);
			home = new JButton("Home",new ImageIcon("image/other/New.GIF")); 
		home.setForeground(Color.white); 
		home.setBackground(new Color(128,0,0));
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(240,480,100,25);
		home.addActionListener(this);
		c.add(home);
			
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
		if(source==cdok)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				
				t=0;
				ResultSet rs = stm.executeQuery("select * from QUES");
				while(rs.next())
				{	
					t=1;	   
					if((qu1.getText()).equals(rs.getString("an1"))&&(qu2.getText()).equals(rs.getString("an2"))&&(qu3.getText()).equals(rs.getString("an3")))
					t=-1;
				}
				if(t==0)
				{
					jp.showMessageDialog(this,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
				
				if(t==-1)
				{
				if(((npd.getText()).equals(cpd.getText()))&&(npd.getText().length()!=0)&&(cpd.getText().length()!=0))
				{
					PreparedStatement ps=c.prepareStatement ("Update pass set pas=?");	
					ps.setString(1,npd.getText());	ps.executeUpdate();
					jp.showMessageDialog(this,"Password is Successfully Changed","SUCCESS",jp.INFORMATION_MESSAGE);
					this.dispose();
			home t=new home();
			t.nn("","","","");	}
				else
				{
					jp.showMessageDialog(this,"All Fields are Incomplete or Incorrect","INFORMATION",jp.ERROR_MESSAGE);
				}
				}				
				else
				{
					jp.showMessageDialog(this,"Sorry, Your Security Questions are Incorrect","WARRNING",jp.ERROR_MESSAGE);
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
	
	public void n19()
 	{
 		 //this.setResizable(false);
	 }
}