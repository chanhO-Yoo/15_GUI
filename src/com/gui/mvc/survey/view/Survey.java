package com.gui.mvc.survey.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.gui.mvc.survey.controller.SurveyController;
import com.gui.mvc.survey.model.vo.SurveyVO;

public class Survey extends JFrame {
	//컨트롤러 클래스에 대한 참조형 필드
//	private SurveyController sc = new SurveyController();//1)방법
	private SurveyController sc;
	private JPanel rootPanel;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JRadioButton radioMale;
	private JRadioButton radioFemale;
	private JTextField textFieldEtc;
	private JTextArea textAreaEtc;
	private JCheckBox chkFood;
	private JCheckBox chkMusic;
	private JCheckBox chkTV;
	private JCheckBox chkFitness;
	private JCheckBox chkEtc;
	
	
	private List<String> interest = new ArrayList<>();
	private char gender;
	
	public Survey(SurveyController sc) {//방법2
		this.sc = sc;
		configureFrame();//프레임설정(size, location, title등)
		addRootPanel();//부분패널을 담을 전체패널 rootPanel 생성 및 설정
		addPanelA();//이름, 나이 TextFiled까지
		addPanelB();//성별
		addPanelC();//관심사
		addPanelD();//기타사항 및 전송/취소 버튼
		
		add(rootPanel);
		setVisible(true);
		
	}

	private void addRootPanel() {
		//rootPanel생성
		rootPanel = new JPanel(); 				// Root 패널 생성
		rootPanel.setBackground(Color.GRAY);	// Panel의 default색상은 라이트 그레이
		rootPanel.setBounds(0,0,500,500);
		rootPanel.setLayout(null);
	}

	private void configureFrame() {
		//프레임설정
		setTitle("설문조사");
		setBounds(400, 100, 500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임에는 setBackground가 작동하지 않는다.
		//프레임내부 패널을 가져와 setBackground처리함.
//		setBackground(Color.GRAY);//작동안함
		getContentPane().setBackground(Color.GRAY);
		
		//프레임 아이콘 추가(파비콘)
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("search.png");
		setIconImage(img);
	}

	private void addPanelA() {
		JPanel panelA = new JPanel();
		panelA.setBounds(10, 10, 480, 40);
		panelA.setBackground(Color.white);
		
		//보더추가
		TitledBorder titledBorderA = new TitledBorder(new LineBorder(Color.black), null);
		panelA.setBorder(titledBorderA);
		
		JLabel title = new JLabel("20~30대를 대상으로 진행하는 설문입니다", JLabel.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		panelA.add(title);
		add(panelA);
		
		//이름, 나이 TextFiled 추가
		JLabel name = new JLabel("이름 : ", JLabel.RIGHT);
		JLabel age = new JLabel("나이 : ", JLabel.RIGHT);
		textFieldName = new JTextField(6);
		textFieldAge = new JTextField(6);
		
		//위치를 직접 좌표로 지정
		name.setBounds(50, 60, 60, 30);
		textFieldName.setBounds(120, 60, 60, 30);
		age.setBounds(250, 60, 60, 30);
		textFieldAge.setBounds(320, 60, 60, 30);
		
		rootPanel.add(name);
		rootPanel.add(textFieldName);
		rootPanel.add(age);
		rootPanel.add(textFieldAge);
	}

	private void addPanelB() {
		JPanel panelB = new JPanel();
		panelB.setBounds(10, 100, 480, 70);
		panelB.setBackground(Color.white);
		panelB.setLayout(new BoxLayout(panelB,BoxLayout.Y_AXIS));
		
		//제목이 있는 border추가
		TitledBorder titledBorderB = new TitledBorder(new LineBorder(Color.BLACK), "1번 당신의 성별은?");
		panelB.setBorder(titledBorderB);
		
		radioMale = new JRadioButton("남성");
		//이벤트 리스너 등록
		radioMale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gender = ((JRadioButton)e.getSource()).getText().charAt(0);
			}
		});
		radioFemale = new JRadioButton("여성");
		radioFemale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gender = ((JRadioButton)e.getSource()).getText().charAt(0);
			}
		});
		ButtonGroup bg = new ButtonGroup();
		//버튼그룹에 추가
		bg.add(radioMale);
		bg.add(radioFemale);
		//라디오버튼 기본백그라운드컬러 변경 : LightGray=>White
		radioMale.setBackground(Color.white);
		radioFemale.setBackground(Color.white);
		
		//패널에는 각 라디오버튼을 추가
		panelB.add(radioMale);
		panelB.add(radioFemale);
		
		rootPanel.add(panelB);
	}

	private void addPanelC() {
		JPanel panelC = new JPanel();
		panelC.setBounds(10, 190, 480, 70);
		panelC.setBackground(Color.white);
		
		TitledBorder titledBorderC = new TitledBorder(new LineBorder(Color.BLACK), "2번 당신의 관심사는? (다중선택가능)");
		panelC.setBorder(titledBorderC);
		
		chkFood = new JCheckBox("음식");
		chkFood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chkFood.isSelected()) {
					interest.add(chkFood.getText());
				}
			}
		});
		chkMusic = new JCheckBox("음악");
		chkMusic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chkMusic.isSelected()) {
					interest.add(chkMusic.getText());
				}
			}
		});
		chkTV = new JCheckBox("TV");
		chkTV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chkTV.isSelected()) {
					interest.add(chkTV.getText());
				}
			}
		});
		chkFitness = new JCheckBox("운동");
		chkFitness.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chkFitness.isSelected()) {
					interest.add(chkFitness.getText());
				}
			}
		});
		chkEtc = new JCheckBox("기타");
		textFieldEtc = new JTextField(10);
		
		//체크박스기본백그라운드컬러: LightGray => White
		chkFood.setBackground(Color.white);
		chkMusic.setBackground(Color.white);
		chkTV.setBackground(Color.white);
		chkFitness.setBackground(Color.white);
		chkEtc.setBackground(Color.white);
		
		panelC.add(chkFood);
		panelC.add(chkMusic);
		panelC.add(chkTV);
		panelC.add(chkFitness);
		panelC.add(chkEtc);
		panelC.add(textFieldEtc);
		
		rootPanel.add(panelC);
		
		chkEtc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chkEtc.isSelected()) {
					interest.add(textFieldEtc.getText());
				}
			}
		});
		
	}

	private void addPanelD() {
		//기타사항 라벨 추가
		JLabel etc = new JLabel("기타사항");
		etc.setBounds(10, 260, 60, 50);
		etc.setFont(new Font("San-serif", Font.BOLD, 15));
		rootPanel.add(etc);
		
		JPanel panelD = new JPanel();
		panelD.setBounds(10, 300, 480, 110);
		panelD.setBackground(Color.white);
		
		//javax.swing.JTextArea.JTextArea(String text, int rows, int columns)
		textAreaEtc = new JTextArea("기타사항을 작성해주세요", 6, 42);
		JScrollPane scr = new JScrollPane(textAreaEtc);
		panelD.add(scr);
		//textAreaEtc.selectAll();

		rootPanel.add(panelD);
		
		//전송/취소버튼 
		JButton btnSubmit = new JButton("전송");
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//콘솔에 출력
				SurveyVO s = new SurveyVO();
				s.setName(textFieldName.getText());
				s.setAge(Integer.parseInt(textFieldAge.getText()));
				s.setGender(gender);
				s.setInterest(interest);
				s.setEtc(textAreaEtc.getText());
				
				sc.printSurvey(s);
				
				sc.saveSurvey(s);
				
				 initSurvey();
			}
		});
		
		JButton btnLoad = new JButton("불러오기");
		btnLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(null);
				File file = jfc.getSelectedFile();
				String fileName = file.getPath();
				System.out.println(fileName);
				setSurvey(sc.loadSurvey(fileName));
			}
		});
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSubmit.setBounds(120, 430, 60, 30);
		btnLoad.setBounds(200,430,100,30);
		btnCancel.setBounds(320, 430, 60, 30);
		
		rootPanel.add(btnSubmit);
		rootPanel.add(btnLoad);
		rootPanel.add(btnCancel);
		
	}
	
	private void initSurvey() {
		textFieldName.setText("");
		textFieldAge.setText("");
		
		radioMale.setSelected(true);
		radioFemale.setSelected(false);		
		
		chkFood.setSelected(true);
		chkMusic.setSelected(false);
		chkTV.setSelected(false);
		chkFitness.setSelected(false);
		chkEtc.setSelected(false);
		textFieldEtc.setText("");
		
		textAreaEtc.setText("");
	}
	
	
	public void setSurvey(SurveyVO vo) {
		textFieldName.setText(vo.getName());
		textFieldAge.setText(Integer.toString(vo.getAge()));
		if(vo.getGender()=='남') {
			radioMale.setSelected(true);
		}
		if(vo.getGender()=='여') {
			radioFemale.setSelected(true);
		}
		if(vo.getInterest().contains("음식")) {
			chkFood.setSelected(true);
		}
		if(vo.getInterest().contains("음악")) {
			chkMusic.setSelected(true);
		}
		if(vo.getInterest().contains("TV")) {
			chkTV.setSelected(true);
		}
		if(vo.getInterest().contains("운동")) {
			chkFitness.setSelected(true);
		}
		if(vo.getInterest().contains("기타")) {
			chkEtc.setSelected(true);
		}
		
		textAreaEtc.setText(vo.getEtc());
	}
}
