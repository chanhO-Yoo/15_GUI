package kh.java.gui.swing.event.low.level;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseEventTest2 extends JFrame{
	private JPanel panel;
	private JLabel label;
	
	
	public MouseEventTest2(int width, int height) {
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		label = new JLabel("Mouse Event Test...");
		
		//리스너 객체 등록
		panel.addMouseListener(new MyMouseListener());
		
		panel.add(label);
		add(panel);
		
		setVisible(true);
	}
	
//	public class MyMouseListener implements MouseListener { //5개의 추상메서드를 모두 구현해야 한다. -> 어댑터 클래스 상속
	public class MyMouseListener extends MouseAdapter { //인터페이스들의 메서드를 추상클래스로 구현. -> 사용할 메서드만 오버라이드해 사용
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
			panel.setBackground(Color.CYAN);
			label.setText("in");
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
			panel.setBackground(Color.GRAY);
			label.setText("out");
		}
	}
	
	public static void main(String[] args) {
		
		new MouseEventTest2(300,200);
	}
}
