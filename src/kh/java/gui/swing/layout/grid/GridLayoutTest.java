package kh.java.gui.swing.layout.grid;

import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * GridLayout
 * 컴포넌트를 가로/세로 일정수만큼 배치가능한 레이아웃
 * Layout 지정시  가로줄(행), 세로줄(열)를 지정
 * 컴포넌트 추가시 위에서 아래로, 좌에서 우로 컴포넌트를 배치
 * 
 * 
 */
public class GridLayoutTest extends JFrame {
	public GridLayoutTest(int x, int y, int width, int height, String title) {
		super(title);
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gridLayout 지정
		setLayout(new GridLayout(6,5));
		for(int i=1;i<=30;i++) {
			add(new JButton(i+"번"));
		}
		
		setVisible(true);
	}
	
	public GridLayoutTest(String title, int x, int y, int width, int height, int row, int col) {
		super(title);
		setBounds(x,y,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(row,col));
		
//		//배열이용 중복없는 난수
//		int[] num = new int[row*col];
//		Random rnd = new Random();
//		for(int i=0;i<row*col;i++) {
//			num[i] = rnd.nextInt(25)+1;
//			for(int j=0;j<i;j++) {
//				if(num[j]==num[i]) {
//					i--;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(num));
//		for(int i=0;i<row*col;i++) {
//			add(new JButton(num[i]+""));
//		}
		//해쉬셋 이용
		Set<Integer> nums = new HashSet<>();
		while(nums.size()<25) {
			nums.add(new Random().nextInt(100)+1);
		}
		for(Integer i : nums) {
			add(new JButton(i.toString()));
		}
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		new GridLayoutTest(100,100,500,400,"GridLayoutTest");

		//@실습문제
		//1~100까지 중복되지 않는 난수를 가진 5*5빙고판만들기
		new GridLayoutTest("Bingo",100,100,500,500,5,5);
	}
}
