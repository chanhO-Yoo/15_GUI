package kh.java.gui.common;

import javax.swing.JPanel;

import kh.java.gui.swing.change.panel.MainFrame;

public class MyUtil {
	public static void changePanel(MainFrame f, JPanel currentPanel, JPanel nextPanel) {
		
		f.remove(currentPanel);
		f.add(nextPanel);
		
		f.repaint();//화면에 다시 그리기 메서드
	}
}
