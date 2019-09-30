package kh.java.gui.swing.layout.card;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame {
	//여러 메서드(내부 클래스)에서 공유할 수 있도록 필드처리
	private CardLayout cardLayout = new CardLayout();
	
	public CardLayoutTest(int x, int y, int width, int height) {
		super("CardLayoutTest");
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//필드에 선언한 CardLayout객체를 layoutManager로 지정
		setLayout(cardLayout);
		
		//패널만들기
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		JPanel card3 = new JPanel();
		
		//배경화면 지정
		card1.setBackground(Color.cyan);
		card2.setBackground(Color.magenta);
		card3.setBackground(new Color(50,80,34));
		
		//라벨추가
		card1.add(new JLabel("Card1"));
		card2.add(new JLabel("Card2"));
		card3.add(new JLabel("Card3"));
		
		//패널에 리스너 등록/연결
		MyMouseListener listener = new MyMouseListener();
		card1.addMouseListener(listener);
		card2.addMouseListener(listener);
		card3.addMouseListener(listener);
		
		//컨테이너에 추가
		add(card1);
		add(card2);
		add(card3);
		
		setVisible(true);
	}
	
	/*
	 * 이벤트 처리를 위한 리스너클래스를 내부클래스 선언
	 */
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			//이벤트가 발생한 객체를 역으로 출력
			JPanel source = (JPanel)e.getSource();
			System.out.println(source);
			
			//패널의 부모컴포넌트 가져오기
			Container parent = source.getParent();
			System.out.println(parent);
			
			//좌클릭/우클릭 분기
			if(e.getButton() == MouseEvent.BUTTON1) { //BUTTON1 - 좌클릭
//				System.out.println("좌클릭!");
				cardLayout.next(parent);
			}
			else if(e.getButton() == MouseEvent.BUTTON3) { //BUTTON3 - 우클릭
//				System.out.println("우클릭!");
				cardLayout.previous(parent);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new CardLayoutTest(300,200,800,500);
	}
}
