package kh.java.gui.swing.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/*
 * RadioButton
 * 복수개의 옵션중에서 택일하는 경우
 * 
 */
public class RadioButtonTest extends JFrame {
	private JLabel result;
	public RadioButtonTest() {
		super("커피 사이즈 선택하기");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//1.제목패널
		setPanel1();
		//2.선택패널
		setPanel2();
		//3.결과패널
		setPanel3();
		
		
		setVisible(true);
	}
	
	public void setPanel1() {
		JPanel p = new JPanel();
		JLabel title = new JLabel("커피 사이즈를 선택하세요");
		p.add(title);
		add(p,BorderLayout.NORTH);
	}
	
	public void setPanel2() {
		JPanel p = new JPanel();
		JRadioButton s = new JRadioButton("Small Size");
		JRadioButton m = new JRadioButton("Medium Size");
		JRadioButton l = new JRadioButton("Large Size");
		
		//라디오의 택일 기능을 위해 그룹처리
		ButtonGroup sizeBtnGroup = new ButtonGroup();
		sizeBtnGroup.add(l);
		sizeBtnGroup.add(m);
		sizeBtnGroup.add(s);
		
		//리스너 등록
		class MySelectListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String size = ((JRadioButton)e.getSource()).getText();
				System.out.println(size);
				result.setText(size+"를 선택하셨습니다.");
			}
		}
		ActionListener listener = new MySelectListener();
		s.addActionListener(listener);
		m.addActionListener(listener);
		l.addActionListener(listener);
		
		p.add(s);
		p.add(m);
		p.add(l);
		add(p,BorderLayout.CENTER);
	}
	
	public void setPanel3() {
		JPanel p = new JPanel();
		result = new JLabel("사이즈를 선택하세요.");
		
		p.add(result);
		add(p,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new RadioButtonTest();
	}
}
