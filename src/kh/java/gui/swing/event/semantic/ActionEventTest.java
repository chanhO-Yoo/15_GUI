package kh.java.gui.swing.event.semantic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionEventTest extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton btn;
	
	
	public ActionEventTest() {
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		b1 = new JButton("노란색");
		b2 = new JButton("분홍색");
		b3 = new JButton("랜덤");
		
		//컴포넌트별 리스너 등록
		MyActionListener listener = new MyActionListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		
		JTextField tf = new JTextField(20);
		JLabel label = new JLabel();
		
		//익명클래스로 리스너클래스 작성 - 일회용
		//익명클래스 - 추상클래스,인터페이스에 new 연산자르 사용해서 일회용 객체 생성
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getSource());
				
				System.out.println(((JTextField)e.getSource()).getText());
				System.out.println(tf.getText());
				System.out.println(e.getActionCommand());
				
				label.setText(tf.getText()); //라벨에 사용자 입력값 대입
				tf.setText(""); //textfield 초기화
			}
		});
		
		btn = new JButton("클릭");
		//리스너 등록
		btn.addActionListener(this);
		
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
		panel.add(tf);
		panel.add(label);

		panel.add(btn);
		
		add(panel);
		
		setVisible(true);
	}
	
	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//소스 분기하기
			if(e.getSource() == b1) {
				System.out.println("b1");
				panel.setBackground(Color.YELLOW);
			}
			else if(e.getSource() == b2) {
				System.out.println("b2");
				panel.setBackground(Color.pink);
			}
			else if(e.getSource() == b3) {
				System.out.println("b3");
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				panel.setBackground(new Color(r,g,b));
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new ActionEventTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setText("변경");
	}
}
