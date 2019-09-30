package kh.java.gui.swing.event.low.level;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * swing 이벤트
 * 1. 저수준 이벤트(low-level)
 *  - 마우스클릭, 키보드 입력
 *  - MouseEvent, KeyEvent, FocusEvent, ... 
 * 
 * 2. 고수준 이벤트(semantic)
 *  - 저수준 이벤트가 여러개 결합된 형태
 *  - 버튼클릭(마우스가 버튼컴포넌트 위로 이동, 클릭, release), 메뉴선택, 체크박스 checked/unchecked, 스크롤
 *  - ActionEvent, ItemEvent, ...
 * 
 */
public class MouseEventTest extends JFrame {
	
	public MouseEventTest(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Mouse Event 테스트...");
		panel.setBackground(Color.cyan);
		
		//컴포넌트별 리스너 객체 등록
		MyMouseListener listener = new MyMouseListener();
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);
		
		panel.add(label);
		add(panel);
		
		setVisible(true);
	}
	
	//현재 발생한  마우스 이벤트 정보 출력
	public void display(String s, MouseEvent e) {
		System.out.println(s+"x:"+e.getX()+" y:"+e.getY());
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			display("mouseClicked(click-count:"+e.getClickCount()+")",e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			display("mousePressed(click-count:"+e.getClickCount()+")",e);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			display("mouseReleased",e);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			display("mouseEntered",e);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			display("mouseExited",e);
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			display("mouseDragged",e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			display("mouseMoved",e);	
		}
		
	}
	
	public static void main(String[] args) {
		new MouseEventTest("MouseEventTest",300,200);
	}
}
