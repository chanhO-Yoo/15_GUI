package kh.java.gui.swing.container.jpanel;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelTest extends JFrame {
	public JPanelTest() {
//		setTitle("title");
		super("JPannel Test");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LayoutManager설정하기
		//컨테이너 객체들은 자식요소를 배치하는 설정
		//LayoutManager객체를 지정해야함
		//JFrame : borderLayout
		//JPanel : FlowLayout
//		setLayout(new FlowLayout());
		setLayout(null); //NullLayout 선언 : 일일히 내가 좌표를 지정하겠다.
		
		//JPanel객체 생성
		JPanel p1 = new JPanel();
		p1.setBackground(Color.green);
		p1.setSize(100,100);
		p1.setLocation(50,50);
		p1.setLayout(null);
		
		//JPanel을 프레임(container)에 추가
		add(p1);
		
		//JPanel(컴포넌트)에 JLabel객체 추가
		JLabel l1 = new JLabel("패널 1");
//		l1.setLocation(100, 100);
//		l1.setSize(100,15);
		l1.setBounds(10,10,100,15);
		JLabel l2 = new JLabel("패널 22");
//		l2.setLocation(100, 300);
//		l1.setSize(100,15);
		l2.setBounds(10,30,100,15);
		p1.add(l1);
		p1.add(l2);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JPanelTest();
	}
}
