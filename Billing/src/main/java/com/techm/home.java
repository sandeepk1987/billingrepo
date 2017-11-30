package com.techm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;
public class home extends JFrame implements ActionListener
{
	
	JMenuBar menuBar;
	JMenu st,bill,rep,oth;
	JOptionPane jp = new JOptionPane();
	JMenuItem adi,ade,edi,ede,gbil,cbil,bpay,days,bals,dds,nils,empa,cp,per,emae;
	Container c;
	int in=0,i=0,t=0;
	int pr[]=new int[15];
	String pe;
	public home()
	{
		super("Billing Projects                                                   ::TechM PROJECTS::");
		c = getContentPane(); c.setBackground(new Color(255,179,179));
		c.setLayout(null); 
		setBounds(0,0,850,590);
			
			
		
		
		/*if(pe.equals("other"))
		{
			
		
		ImageIcon coll = new ImageIcon("ifill.JPG");
		JLabel LogoColl = new JLabel(coll);
		LogoColl.setBounds(0,25,850,550);
		c.add(LogoColl);
			menuBar = new JMenuBar(); 	
		st = new JMenu("Stock");
		st.setBackground(Color.white);
		st.setMnemonic('S');	
		bill = new JMenu("Bill");	
		bill.setBackground(Color.white);
		bill.setMnemonic('B');
		rep = new JMenu("Reports"); 	
		rep.setMnemonic('R');	
		rep.setBackground(Color.white);
		oth = new JMenu("Other"); 	
		oth.setMnemonic('O');	
		oth.setBackground(Color.white);
			if(pr[0]==1){
			adi = new JMenuItem("Add Item"); 
			adi.setBackground(Color.white);
			adi.setMnemonic('A');
			adi.addActionListener(this);
			st.add(adi);}
			if(pr[1]==1){
			edi = new JMenuItem("Edit Item"); 
			edi.setBackground(Color.white);
			edi.setMnemonic('E');
			edi.addActionListener(this);
			st.add(edi);}
			if(pr[2]==1){
			ade = new JMenuItem("Add Empolyee"); 
			ade.setBackground(Color.white);
			ade.setMnemonic('d');
			ade.addActionListener(this);
			st.add(ade);}
			if(pr[3]==1){
			ede = new JMenuItem("Edit Empolyee"); 
			ede.setBackground(Color.white);
			ede.setMnemonic('i');
			ede.addActionListener(this);
			st.add(ede);}
			if(pr[4]==1){
			gbil = new JMenuItem("Generate Bill"); 
			gbil.setBackground(Color.white);
			gbil.setMnemonic('G');
			gbil.addActionListener(this);
			bill.add(gbil);}
			if(pr[5]==1){
			cbil = new JMenuItem("Cancel Bill"); 
			cbil.setBackground(Color.white);
			cbil.setMnemonic('C');
			cbil.addActionListener(this);
			bill.add(cbil);}
			if(pr[6]==1){
			bpay = new JMenuItem("Bill Payment"); 
			bpay.setBackground(Color.white);
			bpay.setMnemonic('B');
			bpay.addActionListener(this);
			bill.add(bpay);}
			if(pr[7]==1){
			days = new JMenuItem("Day Wise Sale"); 
			days.setBackground(Color.white);
			days.setMnemonic('D');
			days.addActionListener(this);
			rep.add(days);}
			if(pr[8]==1){
			bals = new JMenuItem("Balence Stock"); 
			bals.setBackground(Color.white);
			bals.setMnemonic('B');
			bals.addActionListener(this);
			rep.add(bals);}
			if(pr[9]==1){
			dds = new JMenuItem("Day To Day Sale"); 
			dds.setBackground(Color.white);
			dds.setMnemonic('T');
			dds.addActionListener(this);
			rep.add(dds);}
			if(pr[10]==1){
			nils = new JMenuItem("Nil Stock"); 
			nils.setBackground(Color.white);
			nils.setMnemonic('N');
			nils.addActionListener(this);
			rep.add(nils);}
			if(pr[11]==1){
			empa = new JMenuItem("Employee Attendence"); 
			empa.setBackground(Color.white);
			empa.setMnemonic('E');
			empa.addActionListener(this);
			rep.add(empa);}
			if(pr[12]==1){
			emae = new JMenuItem("Employee Attendence Entry"); 
			emae.setBackground(Color.white);
			emae.setMnemonic('E');
			emae.addActionListener(this);
			oth.add(emae);}
			setJMenuBar(menuBar);
		menuBar.add(st);
		menuBar.add(bill);
		menuBar.add(rep);
		menuBar.add(oth);
		
		c.add(menuBar);
			
		}
		else
		if(pe.equals("admin"))
		{
			
		
		*/ImageIcon coll = new ImageIcon("ifill.JPG");
		JLabel LogoColl = new JLabel(coll);
		LogoColl.setBounds(0,25,850,550);
		c.add(LogoColl);
			menuBar = new JMenuBar(); 	
		st = new JMenu("Stock");
		st.setBackground(Color.white);
		st.setMnemonic('S');	
		bill = new JMenu("Bill");	
		bill.setBackground(Color.white);
		bill.setMnemonic('B');
		rep = new JMenu("Reports"); 	
		rep.setMnemonic('R');	
		rep.setBackground(Color.white);
		oth = new JMenu("Other"); 	
		oth.setMnemonic('O');	
		oth.setBackground(Color.white);
			adi = new JMenuItem("Add Item"); 
			adi.setBackground(Color.white);
			adi.setMnemonic('A');
			adi.addActionListener(this);
			st.add(adi);
			edi = new JMenuItem("Edit Item"); 
			edi.setBackground(Color.white);
			edi.setMnemonic('E');
			edi.addActionListener(this);
			st.add(edi);
			ade = new JMenuItem("Add Empolyee"); 
			ade.setBackground(Color.white);
			ade.setMnemonic('d');
			ade.addActionListener(this);
			st.add(ade);
			ede = new JMenuItem("Edit Empolyee"); 
			ede.setBackground(Color.white);
			ede.setMnemonic('i');
			ede.addActionListener(this);
			st.add(ede);
			gbil = new JMenuItem("Generate Bill"); 
			gbil.setBackground(Color.white);
			gbil.setMnemonic('G');
			gbil.addActionListener(this);
			bill.add(gbil);
			cbil = new JMenuItem("Cancel Bill"); 
			cbil.setBackground(Color.white);
			cbil.setMnemonic('C');
			cbil.addActionListener(this);
			bill.add(cbil);
			bpay = new JMenuItem("Bill Payment"); 
			bpay.setBackground(Color.white);
			bpay.setMnemonic('B');
			bpay.addActionListener(this);
			bill.add(bpay);
			days = new JMenuItem("Day Wise Sale"); 
			days.setBackground(Color.white);
			days.setMnemonic('D');
			days.addActionListener(this);
			rep.add(days);
			bals = new JMenuItem("Balence Stock"); 
			bals.setBackground(Color.white);
			bals.setMnemonic('B');
			bals.addActionListener(this);
			rep.add(bals);
			dds = new JMenuItem("Day To Day Sale"); 
			dds.setBackground(Color.white);
			dds.setMnemonic('T');
			dds.addActionListener(this);
			rep.add(dds);
			nils = new JMenuItem("Nil Stock"); 
			nils.setBackground(Color.white);
			nils.setMnemonic('N');
			nils.addActionListener(this);
			rep.add(nils);
			empa = new JMenuItem("Employee Attendence"); 
			empa.setBackground(Color.white);
			empa.setMnemonic('E');
			empa.addActionListener(this);
			rep.add(empa);
			emae = new JMenuItem("Employee Attendence Entry"); 
			emae.setBackground(Color.white);
			emae.setMnemonic('E');
			emae.addActionListener(this);
			oth.add(emae);
			cp = new JMenuItem("Change Password"); 
		cp.setBackground(Color.white);
		cp.setMnemonic('C');
		cp.addActionListener(this);
		per = new JMenuItem("Permissions"); 
		per.setBackground(Color.white);
		per.setMnemonic('P');
		oth.add(cp);
		oth.add(per);
		setJMenuBar(menuBar);
		menuBar.add(st);
		menuBar.add(bill);
		menuBar.add(rep);
		menuBar.add(oth);
		cp.addActionListener(this);
		per.addActionListener(this);
		c.add(menuBar);
		//}
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		
		

		if(source==adi)
		{
			this.dispose();
			aitem u1=new aitem();
			u1.n1();
		}
		if(source==edi)
		{
			this.dispose();
			eitem u2=new eitem();
			u2.n2();
		}
		
		
		if(source==ade)
		{
			this.dispose();
			aemp u3=new aemp();
			u3.n3();
		}	
		if(source==ede)
		{	this.dispose();
			eemp u4=new eemp();
			u4.n4();
		}	
		
		
 		
		if(source==gbil)
		{	this.dispose();
			gen u5=new gen();
			u5.n5();
			
 		}
		
		if(source==cbil)
		{	this.dispose();
			canbill u6=new canbill();
			u6.n6();
 		}
		
		if(source==bpay)
		{	this.dispose();
			paybill u7=new paybill();
			u7.n7();
			
 		}	
		
		if(source==days)
		{	this.dispose();
			daysale u8=new daysale();
			u8.n8();
			
 		}
		if(source==bals)
		{	//this.dispose();
			bal u9=new bal();
			u9.n9();
		}
		if(source==dds)
		{	this.dispose();
			day2day u10=new day2day();
			u10.n10();
 		}
		if(source==nils)
		{	//this.dispose();
			nil u11=new nil();
			u11.n11();
 		}	
		if(source==empa)
		{	this.dispose();
			emprep u12=new emprep();
			u12.n12();
		
		}	
		if(source==emae)
		{	this.dispose();
			empatt u13=new empatt();
			u13.n13();
 		}
		
		
		if(source==cp)
		{	this.dispose();
			cpass u19=new cpass();
			u19.n19();
 		}
		
		
		if(source==per)
		{this.dispose();
			perm u15=new perm();
			u15.n15();
 		}
		
		
		if(str1.equals("Exit"))
		{
			System.exit(0);
		}
	  }	
	public void nn(String p,String un,String pa,String id)//public static void main(String arg[])
 	{
		
		pe=p;
 		home u=new home();
		//u.setResizable(false);
		u.setBounds(0,0,850,590);
		u.show();
		if(p.equals("other"))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringTestDatabase","root","practice");
				Statement stm = c.createStatement();
				t=0;in=0;
				ResultSet rs = stm.executeQuery("select * from PERM where id="+id);
				while(rs.next())
				{	
					t=1;	
					pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		pr[in]=rs.getInt(in+3);in++;
			   		
					
			        
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
		
		
		} 
	}
}