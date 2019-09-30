package kh.java.gui.swing.container.jframe;

import javax.swing.JFrame;

/**
 * JFrame 객체만들기1
 *  - jFrame을 상속한 사용자 클래스 정의, 객체화 한다.
 */
public class JFrameTest1 extends JFrame {
	//생성자 안에서 jframe관련 코드 작성
	public JFrameTest1() {
		//크기 설정
		setSize(800, 500);
		
		//위치 설정
		setLocation(300, 200);
		
		//프레임에 이름 설정
		setTitle("Hello Swing");
		
		//프레임 사이즈 조정여부(기본값 : true)
		setResizable(true);
		
		//닫기버튼 -> 프로그램 종료로 바인딩
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//프레임 시각화 (true면 보이고, false면 안보임)
		//자식 컴포넌트, 프레임 관련 설정을 모두 마친후
		//true값 전달하여 메소드 실행
		setVisible(true);
	}
	public static void main(String[] args) {
		new JFrameTest1();
	}
}
