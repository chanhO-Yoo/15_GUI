package kh.java.gui.swing.layout.flow;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {
	public FlowLayoutTest(int x, int y, int width, int height) {
		super("FlowLayoutTest");
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout()); //borderLayout에서 flowLayout으로 변경
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		//반복문을 통한 컴포넌트 추가
		for(int i=1;i<=15;i++) {
			add(new JButton(i+"번"));
		}
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest(10, 10, 1000, 1000);
	}
}
