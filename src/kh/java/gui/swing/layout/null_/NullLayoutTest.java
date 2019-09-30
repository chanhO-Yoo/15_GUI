package kh.java.gui.swing.layout.null_;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NullLayoutTest extends JFrame{
	public NullLayoutTest(int x, int y, int width, int height) {
		super("NullLayoutTest");
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);//NullLayout
		
		//컴포턴트의 좌표값을 개별적으로 지정해야한다.
		setLayout(null);
		
		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setBounds(50,100,150,50);
		
		JTextField id = new JTextField();
		id.setBounds(110,100,200,50);
		
		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setBounds(50,160,150,50);
		
		JTextField pw = new JTextField();
		pw.setBounds(110,160,200,50);
		
		JButton btn = new JButton("로그인");
		btn.setBounds(330,100,100,110);

		
		add(idLabel);
		add(id);
		add(pwLabel);
		add(pw);
		add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullLayoutTest(200,200,500,500);
	}
}
