package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
//import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class install extends JFrame implements ActionListener
{
	JTextField qu1,ex1,rat1,qu2,qu3,uname,ge,yr1,un,id,name,fn,as,as1,jo1,ge1,d1,q1,dob,ad,al,cj,cj1,ex,qu,phno,padd,eadd,p1,p2,p3,p4,p5,p6,p7,pp1,pp2,pp3,do1,do2,do3,ad1,ad2,ad3,al1,al2,al3;
	TextField opd,cpd,npd,pa;
	Container c;
	JButton search,new1,save,home,exit,update,cupdate,bupdate,tupdate,nupdate,create,new2,csave,bsave,tsave,nsave;
	JButton cdok,log,sub;
	JLabel luname,lopd,lnpd,lcpd,lqu1,lqu2,lqu3;
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar;	
	JMenu menu1,menu2,menu3,menu4; 
	JMenu menuItemS,menuItemT,menuItemSS,menuItemST,menuItemus,menuItemut,file;
	JMenuItem cdpd,btech,btechs,mba,mca,tech,ntech,mbas,mcas,techs,ntechs,menuItemA,menuItemD,menuItemU,menuItemE;
	Cursor cur;
	String tu,tp="TechM",p,ppp,pr;
	int f=0,t=0,a1,a2,a3;
	Choice lcou,cex1,rat,lqul,ljo1,lqul1,yr,gen,dob1,dob2,dob3,all1,all2,all3,add1,add2,add3,de1;
	public install()
	{
		super("Project Installing....");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,850,590);
		setFont(new Font("TechM",50,44));
		
		ImageIcon college = new ImageIcon("image/other/install.gif");
		JLabel colLogo = new JLabel(college);
		colLogo.setBounds(0,0,500,100);
		c.add(colLogo);
		
			ImageIcon backg = new ImageIcon("image/other/install.GIF");
			JLabel cdlogo = new JLabel(backg);
			c.add(cdlogo);  
			lqu1 = new JLabel("Q1: What Is Your Pet Name ?"); lqu1.setForeground(Color.black);
			lqu2 = new JLabel("Q2: Who Is Your Best Friend ?"); lqu2.setForeground(Color.black);
			lqu3 = new JLabel("Q3: What Is Your Luky Number ?"); lqu3.setForeground(Color.black);
			qu1 = new JTextField();
			qu2 = new JTextField();
			qu3 = new JTextField();
				
			luname = new JLabel("User Name :"); luname.setForeground(Color.black);
			
			lnpd = new JLabel("Password :"); lnpd.setForeground(Color.black);		
			lcpd = new JLabel("Re Enter password :");	lcpd .setForeground(Color.black);
			uname = new JTextField();
			
			opd = new TextField();
			npd = new TextField();
			cpd = new TextField();
			opd.setEchoChar('$');
			cpd.setEchoChar('$');
			npd.setEchoChar('$');
			sub = new JButton("Submit",new ImageIcon("image/other/tick.PNG"));sub.setForeground(Color.white); sub.setBackground(new Color(128,0,0));
			sub.setToolTipText("Submit Details");
			c.add(lqu1);
			c.add(lqu2);
			c.add(lqu3);
			c.add(qu1);
			c.add(qu2);
			c.add(qu3);
			c.add(luname);
			
			c.add(lnpd);
			c.add(lcpd);
			c.add(uname);
			
			c.add(npd);
			c.add(cpd);
			c.add(sub);
			//cdlogo.setBounds(0,0,500,100);
			lqu1.setBounds(100,120,210,25);
			lqu2.setBounds(100,180,210,25);
			lqu3.setBounds(100,240,210,25);
			qu1.setBounds(100,150,150,25);
			qu2.setBounds(100,210,150,25);
			qu3.setBounds(100,270,150,25);
			luname.setBounds(50,320,210,25);
			
		//c.add(home);
			lnpd.setBounds(50,350,210,25);
			lcpd.setBounds(50,380,210,25);
			uname.setBounds(170,320,150,25);
			
			npd.setBounds(170,350,150,25);
			cpd.setBounds(170,380,150,25);
			sub.setBounds(180,480,110,25);
			sub.addActionListener(this);
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(str1.equals("Submit"))
		{
			try
			{
				if(npd.getText().equals(cpd.getText()))
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:odbc:sysDSN","system","tiger");
				Statement stm = c.createStatement();
		
				PreparedStatement ps  = c.prepareStatement("create table ques(an1 varchar(10),an2 varchar(10),an3 varchar(10))");
				ps.executeUpdate();
				PreparedStatement ps1  = c.prepareStatement("insert into ques values(?,?,?)");
		        	ps1.setString(1,qu1.getText());
				ps1.setString(2,qu2.getText());
				ps1.setString(3,qu3.getText());
				ps1.executeUpdate();
				
				PreparedStatement ps2  = c.prepareStatement("CREATE TABLE  PASS(NAME VARCHAR2(20),PAS VARCHAR2(20))");
				ps2.executeUpdate();
				PreparedStatement ps3  = c.prepareStatement("insert into pass values(?,?)");
		        	ps3.setString(1,uname.getText());
				ps3.setString(2,npd.getText());
				ps3.executeUpdate();
				PreparedStatement ps4  = c.prepareStatement("CREATE TABLE  ITEM(ID VARCHAR2(20),NAME VARCHAR2(20),COST NUMBER,TAX NUMBER,STOCK NUMBER)");
				ps4.executeUpdate();
				PreparedStatement ps5  = c.prepareStatement("CREATE TABLE EMP(ID NUMBER,NAME VARCHAR2(20), DOB DATE, QUAL VARCHAR2(20),JOB VARCHAR2(20),SAL NUMBER,PHO NUMBER)");
				ps5.executeUpdate();
				PreparedStatement ps6  = c.prepareStatement("create table mba(sid varchar(10),name varchar(20),fname varchar(20),do1 varchar(10),do2 varchar(10),do3 varchar(10),ad1 varchar(10),ad2 varchar(10),ad3 varchar(10),al1 varchar(10),al2 varchar(10),al3 varchar(10),ad varchar(20),cou varchar(10),join varchar(10),gen varchar(10),year varchar(10),phno varchar(20),padd varchar(30),eadd varchar(30),pp1 varchar(10),pp2 varchar(20),pp3 varchar(10),p1 varchar(10),p2 varchar(10),p3 varchar(10),p4 varchar(10))");
				ps6.executeUpdate();
				PreparedStatement ps7  = c.prepareStatement("create table tech(sid varchar(10),name varchar(20),fname varchar(20),do1 varchar(10),do2 varchar(10),do3 varchar(10),ad1 varchar(10),ad2 varchar(10),ad3 varchar(10),job varchar(20),dep varchar(10),exp varchar(10),exp1 varchar(10),qual varchar(10),gen varchar(10),sal varchar(10),phno varchar(20),padd varchar(30),eadd varchar(30),rat varchar(30))");
				ps7.executeUpdate();
				PreparedStatement ps8  = c.prepareStatement("create table ntech(sid varchar(10),name varchar(20),fname varchar(20),do1 varchar(10),do2 varchar(10),do3 varchar(10),ad1 varchar(10),ad2 varchar(10),ad3 varchar(10),job varchar(20),dep varchar(10),exp varchar(10),exp1 varchar(10),qual varchar(10),gen varchar(10),sal varchar(10),phno varchar(20),padd varchar(30),eadd varchar(30),rat varchar(30))");
				ps8.executeUpdate();
				jp.showMessageDialog(this,"Project Installed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);	
				c.close();
				stm.close();
				
				}
				else
				{
					jp.showMessageDialog(this,"Sorry, Please Enter Password & Re-enter Password Must be Same","INFORMATION",jp.ERROR_MESSAGE);
				}
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
	public static void main(String arg[])
 	{
 		
		 install u1=new install();
		u1.setResizable(false);
		u1.setBounds(0,0,510,600);
		u1.show();
	}
}