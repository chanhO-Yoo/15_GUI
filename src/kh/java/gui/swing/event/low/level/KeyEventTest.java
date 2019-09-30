package kh.java.gui.swing.event.low.level;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


/*
 * keyEvent
 * 사용자가 키보드를 통한 입력시 발생함.
 * 해당 컴포넌트가 반드시  focus를 가지고 있어야한다.
 * (requestFocus()를 통해 focus획득가능)
 * 
 * keyListener 인터페이스 구현을 통해 리스너클래스 작성
 * keyAdapter추상클래스를 통해 간결히 리스너클래스 구현 가능
 * 
 */
public class KeyEventTest extends JFrame {
	private JTextField tf;
	
	public KeyEventTest(int width, int height) {
		super("KeyEventTest");
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		tf = new JTextField(20);
		tf.addKeyListener(new MyKeyListener());
		tf.addKeyListener(new MyKeyListener2());
		
		add(tf);
		
		setVisible(true);
	}
	
	public void display(String s, KeyEvent e) {
		char keyChar = e.getKeyChar(); // 입력문자
		int keyCode = e.getKeyCode(); // 입력문자의 아스키 코드값
		System.out.println(s+"["+keyChar+"] ["+keyCode+"]");
	}
	
	public class MyKeyListener2 extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 10) {
				System.out.println(tf.getText());
				tf.setText("");//초기화
			}
		}
	}
	
	public class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			display("keyTyped",e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			display("keyPressed",e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			display("keyReleased",e);
		}
		
	}
	
	public static void main(String[] args) {
		new KeyEventTest(300,200);
	}
}
