package kh.java.gui.swing.event.semantic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CountDownTest extends JFrame {
	private JPanel panel;
	private JButton btn;
	
	public CountDownTest() {
		super("CountDownTest");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		btn = new JButton("10");
//		btn.setSize(150,150);
		btn.setPreferredSize(new Dimension(150,150));
		btn.setFont(new Font("Arial", Font.BOLD, 100));
		
		//2안
		btn.addActionListener(new ActionListener() {
			
			private int count = 10;
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				if(count==0) {
					btn.setEnabled(false);
				}
				btn.setText(count+"");
			}
		});
		
		panel.add(btn);
		add(panel);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CountDownTest();
	}
}
