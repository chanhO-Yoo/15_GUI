package kh.java.gui.swing.change.panel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kh.java.gui.common.MyUtil;

public class SubPanel extends JPanel {

	private MainFrame f;
	private MainPanel mp;
	
	public SubPanel(MainFrame f, MainPanel p) {
		this.f = f;
		this.mp = p;
		
		setSize(300,200);
		setBackground(Color.pink);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//내부클래스에서 외부클래스 현재 객체를 가져오기 위해 MainPanel.this 사용
				MyUtil.changePanel(f,SubPanel.this, mp);
			}
		});
	}
	
	
}
