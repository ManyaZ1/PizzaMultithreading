package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Main;
public class MainScreen extends JFrame implements ActionListener{
	private int clients;
	private int time;
	static int width;
	static int height;
	static JTextField txtfield;
	static JTextField txtfield2;
	public MainScreen(int width, int height) {
		MainScreen.width=width;
		MainScreen.height=height;
		this.setSize(width, height);	
		this.setTitle("PIZZA simulation");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null); 		
		this.setFocusable(true);
		setResizable(false);
		
		 	
		JPanel p1 = new JPanel();  
	    p1.setLayout(new GridLayout(2, 2));
	    JPanel p2 = new JPanel();
	    p2.setLayout(new FlowLayout());
		
		JLabel s2=new JLabel("Enter time of operation in hours: ");
		JLabel s1=new JLabel("Enter number of clients: ");
		txtfield=new JTextField();
		txtfield2=new JTextField();
		p1.add(s1);
		p1.add(txtfield);
		p1.add(s2);
		p1.add(txtfield2);
		//p1.setBackground(new java.awt.Color(181,250,216));
		
		JButton jButton1 = new JButton ("Start Simulation");
		jButton1.addActionListener ( this );
		jButton1.setVisible(true);
		p2.add(jButton1);
		//p2.setBackground(new java.awt.Color(181,250,216));
	
	
		this.add(p1,"North");
	    this.add(p2,"South");
	    //this.setBackground();
	    this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clients=Integer.parseInt(txtfield.getText());
	
		time = Integer.parseInt(txtfield2.getText());
		Main.simulate(time*60, clients);
	}
	public int getTime() {return this.time;}
	public int getClients() {return this.clients;}

}
