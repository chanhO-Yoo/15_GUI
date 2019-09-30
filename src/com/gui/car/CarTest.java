package com.gui.car;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarTest extends JFrame {
	
	private JLabel car1;
	private JLabel car2;
	private JLabel car3;
	private int rank;
	
	public CarTest() {
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		car1 = new JLabel(new ImageIcon("images/car1.gif"));
		car2 = new JLabel(new ImageIcon("images/car2.gif"));
		car3 = new JLabel(new ImageIcon("images/car3.gif"));
		
		
		car1.setBounds(10,10,100,100);
		car2.setBounds(10,60,100,100);
		car3.setBounds(10,110,100,100);
		
		add(car1);
		add(car2);
		add(car3);
	}
	
	public static void main(String[] args) {
		new CarTest().setVisible(true);;
	}
}
