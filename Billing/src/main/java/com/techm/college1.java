package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.JPopupMenu;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
public class college1 extends JFrame implements ActionListener
{
	JTextField qu1,ex1,rat1,qu2,qu3,uname,ge,yr1,un,id,name,fn,as,as1,jo1,ge1,d1,q1,dob,ad,al,cj,cj1,ex,qu,phno,padd,eadd,p1,p2,p3,p4,p5,p6,p7,pp1,pp2,pp3,do1,do2,do3,ad1,ad2,ad3,al1,al2,al3;
	JPasswordField opd,cpd,npd,pa;
	Container c;
	JButton search,new1,save,delete,exit,update,cupdate,bupdate,tupdate,nupdate,create,new2,csave,bsave,tsave,nsave;
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
	public college1()
	{
		super("College Management");
		c = getContentPane(); c.setBackground(new Color(240,200,100));
		c.setLayout(null); 
		setBounds(0,0,850,590);
		setFont(new Font("TechM",50,44));
		cur = new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(cur);
		
		ImageIcon coll = new ImageIcon("PICT0052.jpg");
		JLabel LogoColl = new JLabel(coll);
		
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("File");
		menu1.setBackground(Color.white);
		menu1.setMnemonic('F');	
		menu2 = new JMenu("Entry");	
		menu2.setBackground(Color.white);
		menu2.setMnemonic('E');
		menu3 = new JMenu("Show"); 	
		menu3.setMnemonic('S');	
		menu3.setBackground(Color.white);
		menu4 = new JMenu("Help"); 	
		menu4.setMnemonic('H');	
		menu4.setBackground(Color.white);
		menuItemS = new JMenu("Studets"); 
		menuItemS.setBackground(Color.white);
		menuItemS.setMnemonic('t');
		menuItemT = new JMenu("Staff");
		menuItemT.setBackground(Color.white);
		menuItemT.setMnemonic('a');
		menuItemE = new JMenuItem("Exit",new ImageIcon("Exit.PNG")); 
		menuItemE.setBackground(Color.white);
		menuItemE.setMnemonic('E');
		menuItemSS = new JMenu("Studets"); 
		menuItemSS.setBackground(Color.white);
		menuItemSS.setMnemonic('t');
		menuItemST = new JMenu("Staff");
		menuItemST.setBackground(Color.white);
		menuItemST.setMnemonic('a');
		menuItemus = new JMenu("Studets"); 
		menuItemus.setBackground(Color.white);
		menuItemus.setMnemonic('t');
		menuItemut = new JMenu("Staff");
		menuItemut.setBackground(Color.white);
		menuItemut.setMnemonic('a');
		menuItemU = new JMenuItem("About US");
		menuItemU.setBackground(Color.white);
		menuItemU.setMnemonic('U');
		menuItemA = new JMenuItem("About Project",new ImageIcon("help.gif")); 
		menuItemA.setBackground(Color.white);
		menuItemA.setMnemonic('E');
		btech = new JMenuItem("B.Tech"); 
		btech.setBackground(Color.white);
		btech.setMnemonic('T');
		
		btechs = new JMenuItem("B.Tech");
		btechs.setBackground(Color.white);
		btechs.setMnemonic('T');
		
		mca = new JMenuItem("MCA");
		mca.setBackground(Color.white);
		mca.setMnemonic('C');
		
		mcas = new JMenuItem("MCA");
		mcas.setBackground(Color.white);
		mcas.setMnemonic('C');
		mba = new JMenuItem("MBA");
		mba.setBackground(Color.white);
		mba.setMnemonic('A');
		
		mbas = new JMenuItem("MBA");
		mbas.setBackground(Color.white);
		mbas.setMnemonic('A');
		tech = new JMenuItem("TECHING");
		tech.setBackground(Color.white);
		tech.setMnemonic('I');
		
		techs = new JMenuItem("TECHING");
		techs.setBackground(Color.white);
		techs.setMnemonic('I');
		ntech = new JMenuItem("NON TECHING");
		ntech.setBackground(Color.white);
		ntech.setMnemonic('N');
		
		ntechs = new JMenuItem("NON TECHING");
		ntechs.setBackground(Color.white);
		ntechs.setMnemonic('N');
		menuItemD = new JMenuItem("About DataBase",new ImageIcon("bookbig.gif"));
		menuItemD.setBackground(Color.white);
		menuItemD.setMnemonic('A');
		
		

		cdpd= new JMenuItem("Change Password",new ImageIcon("lock.PNG"));
		cdpd.setBackground(Color.white);
		cdpd.setMnemonic('P');
		setJMenuBar(menuBar);
		
		
		
		
		
		ImageIcon background = new ImageIcon("backg.jpg");
		JLabel img = new JLabel(background);

		ImageIcon college = new ImageIcon("Movie1.gif");
		JLabel colLogo = new JLabel(college);
	
		ImageIcon LineStraight = new ImageIcon("lineh.gif");
		JLabel Line = new JLabel(LineStraight);
		ImageIcon LineStraight1 = new ImageIcon("lineh.gif");
		JLabel Line1 = new JLabel(LineStraight1);

			
		//LogoColl.setBounds(0,350,850,200);
		


		
		
		//LogoColl.setBounds(100,300,850,142);
		
		img.setBounds(90,100,20,40);
		colLogo.setBounds(0,0,850,142);
		Line.setBounds(2,2,48,1000);

		
		Line1.setBounds(800,0,48,1000);
			
		
		

		menu1.add(cdpd);
		menu1.add(menuItemE);
		
		menuItemS.add(btech);
		menuItemS.add(mca);
		menuItemS.add(mba);
		menu2.add(menuItemS);
		
		menuItemT.add(tech);
		menuItemT.add(ntech);
		menu2.add(menuItemT);
		
		
		
		
		menuItemSS.add(btechs);
		menuItemSS.add(mcas);
		menuItemSS.add(mbas);
		menu3.add(menuItemSS);
		
		menuItemST.add(techs);
		menuItemST.add(ntechs);
		menu3.add(menuItemST);
		
		
		
		menu4.add(menuItemA);
		menu4.add(menuItemD);
		menu4.add(menuItemU);
		
		
		
		menuItemS.addActionListener(this);
		menuItemT.addActionListener(this);
		menuItemSS.addActionListener(this);
		menuItemST.addActionListener(this);
		menuItemA.addActionListener(this);
		menuItemD.addActionListener(this);
		menuItemU.addActionListener(this);
		menuItemE.addActionListener(this);

		btech.addActionListener(this);
		btechs.addActionListener(this);	
		mca.addActionListener(this);
		mcas.addActionListener(this);
		
		mba.addActionListener(this);
		mbas.addActionListener(this);
		
		tech.addActionListener(this);
		techs.addActionListener(this);
		
		ntech.addActionListener(this);
		ntechs.addActionListener(this);
		
		cdpd.addActionListener(this);

				menuBar.add(menu1);
				menuBar.add(menu2);
				menuBar.add(menu3);
				menuBar.add(menu4);
			
		
	
		
		c.add(colLogo);
		c.add(LogoColl);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		
		

		if(source==menuItemU)
		{
			JFrame aboutus = new JFrame("About us");
			aboutus.setSize(800,590);
			aboutus.getContentPane().setLayout(null);
			ImageIcon design = new ImageIcon("about.jpg");
			JLabel cover = new JLabel(design);
			aboutus.getContentPane().add(cover);
			cover.setBounds(0,0,800,590);
			aboutus.setVisible(true);
			aboutus.setResizable(false);
		}
		if(source==menuItemD)
		{
			JFrame aboutdb = new JFrame("About Database");
			aboutdb.setSize(700,500);
			aboutdb.getContentPane().setLayout(null);
			ImageIcon design1 = new ImageIcon("teams.GIF");
			JLabel cover1 = new JLabel(design1);
			aboutdb.getContentPane().add(cover1);
			cover1.setBounds(0,0,700,500);
			aboutdb.setVisible(true);
			aboutdb.setResizable(false);
		}
		
		
		if(source==menuItemE)
		{
			System.exit(0);
			jp = new JOptionPane();
		}	
		if(source==btech)
		{	
			JApplet cd=new JApplet();
			cd.setSize(800,590);	
			cd.getContentPane().setLayout(null);
			cd.getContentPane().setBackground(new Color(240,32,100));

//			cd.setResizable(false);
			ImageIcon backg = new ImageIcon("mca.GIF");
			JLabel cdlogo = new JLabel(backg);
			cd.getContentPane().add(cdlogo);  
		
		
		
		
		
		

		
			
		
			cdlogo.setBounds(0,0,800,100);
			
			cd.setVisible(true);
			
		}	
		if(source==new1)	
		{
			

			id.setEditable(true);
			name.setEditable(true);
			fn.setEditable(true);
			//dob.setEditable(true);
			//ad.setEditable(true);
			//al.setEditable(true);
			as.setEditable(true);
			//cj.setEditable(true);
			//qu.setEditable(true);
			phno.setEditable(true);
			padd.setEditable(true);
			eadd.setEditable(true);
			//as1.setEditable(true);
			//ex.setEditable(true);
			
			//lqul.setBounds(190,380,150,20);
			
			p1.setEditable(true);
			p2.setEditable(true);
			p3.setEditable(true);
			p4.setEditable(true);
			p5.setEditable(true);
			p6.setEditable(true);
			p7.setEditable(true);
		
			pp1.setEditable(true);
			pp2.setEditable(true);
			//pp3.setEditable(true);

			id.setText(null);
			name.setText(null);
			fn.setText(null);
			//dob.setText(null);
			//ad.setText(null);
			//al.setText(null);
			as.setText(null);
			//cj.setText(null);
			//qu.setText(null);
			phno.setText(null);
			padd.setText(null);
			eadd.setText(null);
			
			//lqul.setBounds(190,380,150,20);
			
			p1.setText(null);
			p2.setText(null);
			p3.setText(null);
			p4.setText(null);
			p5.setText(null);
			p6.setText(null);
			p7.setText(null);
		
			pp1.setText(null);
			pp2.setText(null);
			//as1.setText(null);
			//ex.setText(null);
			//pp3.setText(null);
			
		}
		
 		
		if(str1.equals("Exit"))
		{
			System.exit(0);
		}
	  }	
	public static void main(String arg[])
 	{
 		
		 college1 u1=new college1();
		u1.setResizable(false);
		u1.setBounds(0,0,850,600);
		u1.show();
	 }
}