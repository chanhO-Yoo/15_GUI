package kh.java.gui.swing.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxTest extends JFrame {
	private JLabel result;
	
	public CheckBoxTest() {
		super("체크박스 테스트");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setCheckBoxPanel();
		
		setResultPanel();
		
		setVisible(true);
	}
	
	public void setCheckBoxPanel() {
		JPanel p = new JPanel();
		String[] fruits = {"사과","오렌지","바나나"};
		JCheckBox[] chkArr = new JCheckBox[fruits.length];
		for(int i=0;i<fruits.length;i++) {
			JCheckBox chk = new JCheckBox(fruits[i]);
			chkArr[i] = chk;
			p.add(chk);
			
			//이벤트 리스너 추가하기
			chk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String r = "";
					
					for(JCheckBox chk : chkArr) {
						//체크여부
						if(chk.isSelected()) {
							r += chk.getText()+" ";
						}
					}
					if("".equals(r)) {
						r = "선택한 과일이 없습니다.";
					}
					
					result.setText(r);
				}
			});
		}
		
		add(p);
		
		
	}
	
	public void setResultPanel() {
		JPanel p = new JPanel();
		result = new JLabel("과일을 선택하세요.");
		
		p.add(result);
		add(p,BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		new CheckBoxTest();
	}
}
