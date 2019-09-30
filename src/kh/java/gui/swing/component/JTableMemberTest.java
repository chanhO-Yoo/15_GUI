package kh.java.gui.swing.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class JTableMemberTest extends JFrame {
	private List<Member> memberList = new ArrayList<>();
	{
		memberList.add(new Member("김철수","서울", 24, false));
		memberList.add(new Member("김영희","경기", 25, true));
		memberList.add(new Member("이혜정","광주", 38, false));
		memberList.add(new Member("한여름","부산", 45, true));
		memberList.add(new Member("한겨울","대전", 60, true));
		
		//프로그램 시작시 출력 확인
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	
	public JTableMemberTest() {
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] columns = {"이름","주소","나이","결혼여부"};
		Object[][] rowData = new Object[memberList.size()][columns.length];
		
		for(int i=0;i<memberList.size();i++) {
			Member m = memberList.get(i);
//			rowData[i] = new Object[columns.length];
			rowData[i][0] = m.getName();
			rowData[i][1] = m.getAddr();
			rowData[i][2] = m.getAge();
			rowData[i][3] = m.isMarried();
		}
		
		JTable table = new JTable(rowData,columns);
		JScrollPane scr = new JScrollPane(table);
		
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setAutoCreateRowSorter(true);
		
		//갱신된 회원목록 가져오기 버튼
		JButton btn = new JButton("저장");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableModel model = table.getModel();
				int rowLen = model.getRowCount();
				int colLen = model.getColumnCount();
				System.out.println("테이블 정보 : "+rowLen+"X"+colLen);
				
				//memberList에 갱신된 정보 반영
				memberList.clear();
				for(int i=0;i<rowLen;i++) {
					String name = "";
					String addr = "";
					int age = 0;
					boolean married = false;
					
					for(int j=0;j<colLen;j++) {
						switch(j) {
						case 0:
							name = (String)model.getValueAt(i, j);
							break;
						case 1:
							addr = model.getValueAt(i, j).toString();
							break;
						case 2:
							age = Integer.parseInt(model.getValueAt(i, j).toString());
							break;
						case 3:
							married = (boolean)model.getValueAt(i, j);
							break;
						}
						
					}
					
					Member m = new Member(name,addr,age,married);
					memberList.add(m);
				}
				//출력확인
				for(Member m : memberList) {
					System.out.println(m);
				}
			}
		});
		
		add(scr);
		add(btn,BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	class Member{
		private String name;
		private String addr;
		private int age;
		private boolean married;
		
		public Member() {
			
		}
		public Member(String name, String addr, int age, boolean married) {
			this.name = name;
			this.addr = addr;
			this.age = age;
			this.married = married;
		}
		
		public String getName() {
			return name;
		}
		public String getAddr() {
			return addr;
		}
		public int getAge() {
			return age;
		}
		public boolean isMarried() {
			return married;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void setMarried(boolean married) {
			this.married = married;
		}
		
		@Override
		public String toString() {
			return name+", "+addr+", "+age+", "+married;
		}
	}
	
	
	public static void main(String[] args) {
		new JTableMemberTest();
	}
}
