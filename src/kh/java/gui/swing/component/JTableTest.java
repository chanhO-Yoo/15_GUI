package kh.java.gui.swing.component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class JTableTest extends JFrame {
	public JTableTest() {
		setSize(500,200);;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//테이블 생성 준비
		//컬럼정보 : String[]
		//실제데이터 : Object[][]
		String[] columns = {"이름", "주소", "나이", "결혼여부"};
		Object[][] rowData = {{"김철수","서울",24,false},{"김영희","경기",34,true},{"이예수","부산",28,false}};
		
		JTable table = new JTable(rowData, columns);
		JScrollPane scr = new JScrollPane(table);
		
		//실제 테이블이 차지하고있는 영역을 표시
		table.setPreferredScrollableViewportSize(table.getSize());
		//컬럼을 클릭하면, 해당컬럼의 데이터를 기준으로 자동정렬
		table.setAutoCreateRowSorter(true);
		
		//주소값 변경시, 선택박스(ComboBox) 제공
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("서울");
		comboBox.addItem("부산");
		comboBox.addItem("광주");
		comboBox.addItem("대구");
		comboBox.addItem("대전");
		
		TableColumn addrColumn = table.getColumnModel().getColumn(1);
		addrColumn.setCellEditor(new DefaultCellEditor(comboBox));
		
		//셀 변경 이벤트 처리
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				//변경된 셀의 행렬 정보 가져오기
				int row = e.getFirstRow();
				int column = e.getColumn();
				
				//테이블 모델 가져오기
				TableModel model = table.getModel();
				
				//변경된 셀 데이터
				Object data = model.getValueAt(row, column);
				
				System.out.println(row+"행"+column+"열의 정보가 ["+data+"]로 변경되었습니다.");
			}
		});
		
//		add(table);
		add(scr);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableTest();
	}
}
