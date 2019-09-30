package kh.java.gui.swing.container.jframe;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 * JFrame객체 생성하기2
 * 
 *  - new JFrame()객체를 직접 생성하고,
 *    reference를 통해 제어하기.
 */
public class JFrameTest2 {
	public static void main(String[] args) {
		JFrame f = new JFrame("hi.Swing~");//생성자에 파라미터로 setTitle() 처리가능
//		f.setSize(500,400);
//		f.setLocation(300,200);
		f.setBounds(300,200,500,400); //setSize와 setLocation을 동시에 처리
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임 상단 아이콘 변경
		f.setIconImage(new ImageIcon("images/icon.png").getImage()); 
//		Image img = new ImageIcon("images/icon.png").getImage();
//		f.setIconImage(img);

		//화면 가운데 배치
		//1.스크린 사이즈
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		System.out.println(screenSize.getWidth()+"*"+screenSize.getHeight());
		System.out.println(screenSize.width+"*"+screenSize.height);
		//2.offset값 구하기 : x,y
		int width = 500;
		int height = 500;
		int x = (screenSize.width-width)/2;
		int y = (screenSize.height-height)/2;
		
		f.setBounds(x,y,width,height);
		
		
		f.setVisible(true);
	}

}
