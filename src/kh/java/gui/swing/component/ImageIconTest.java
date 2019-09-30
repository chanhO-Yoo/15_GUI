package kh.java.gui.swing.component;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageIconTest extends JFrame {
	public ImageIconTest() {
		setSize(250,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		//이미지 크기 조정하기
		//Image -> ImageIcon -> JLabel 순
		Image img = new ImageIcon("images/user.png").getImage().getScaledInstance(150, 150, 0);
		JLabel label = new JLabel(new ImageIcon(img));
//		JLabel label = new JLabel(new ImageIcon("images/user.png"));//이미지 크기가 조절 X, 원본 사이즈 그대로 사용
		
		//버튼을 통한 이미지 변경
		JButton btn = new JButton("이미지 변경");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Image img = new ImageIcon("images/dog.png").getImage().getScaledInstance(150, 150, 0);
				
				//이미지변경
				label.setIcon(new ImageIcon(img));
			}
		});
		p.add(label);
		p.add(btn, BorderLayout.SOUTH);
		//컴포넌트를 기준으로 딱 맞게 frame의 크기 조정
		pack();
		add(p);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageIconTest();
	}
}
