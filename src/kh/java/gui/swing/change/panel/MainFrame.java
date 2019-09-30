package kh.java.gui.swing.change.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new MainPanel(this);
		add(mainPanel);
		
		setVisible(true);
	}
	
}
