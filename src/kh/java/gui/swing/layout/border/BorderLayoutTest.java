package kh.java.gui.swing.layout.border;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest(int x, int y, int width, int height) {
		super("BorderLayoutTest");
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(getLayout());
		
		//버튼만들기
		JButton n = new JButton("북");
		JButton s = new JButton("남");
		JButton e = new JButton("동");
		JButton w = new JButton("서");
		JButton m = new JButton("중앙");

		JPanel ePanel = new JPanel();
		JButton e1 = new JButton("동1");
		JButton e2 = new JButton("동2");
		ePanel.add(e1);
		ePanel.add(e2);
		//요소를 추가시에는 해당 위치를 함께 지정
		//기본값은 CENTER
		//하나의 방위에는 하나의 컴포넌트만 추가 가능
//		add(n,BorderLayout.NORTH);
//		add(s,BorderLayout.SOUTH);
//		add(e,BorderLayout.EAST);
//		add(w,BorderLayout.WEST);
		add(e1,BorderLayout.EAST);
		add(e2,BorderLayout.EAST);

		add(m,BorderLayout.CENTER);
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutTest(100,100,500,400);
	}
}
