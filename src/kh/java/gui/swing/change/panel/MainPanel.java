package kh.java.gui.swing.change.panel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kh.java.gui.common.MyUtil;

public class MainPanel extends JPanel {
	
	private MainFrame f;
	private SubPanel sp;
	
	public MainPanel(MainFrame f) {
		this.f = f;
		sp = new SubPanel(f, this);
		setSize(300,200);
		setBackground(Color.blue);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//내부클래스에서 외부클래스 현재 객체를 가져오기 위해 MainPanel.this 사용
				MyUtil.changePanel(f,MainPanel.this, sp);
			}
		});
		
	}
	
	
	
}
