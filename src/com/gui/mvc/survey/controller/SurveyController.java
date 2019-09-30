package com.gui.mvc.survey.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

import com.gui.mvc.survey.model.vo.SurveyVO;

/*
 * 어플리케이션의 주요 업무를 담당
 *  - 1) 콘솔 출력
 *  - 2) 파일 저장
 *  - 3) 파일 불러오기
 */
public class SurveyController implements Serializable {
	
	//콘솔 출력 메서드
	public void printSurvey(SurveyVO vo) {
		System.out.println(vo);
	}
	//파일 저장 메서드
	public void saveSurvey(SurveyVO vo) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showSaveDialog(null);
		File file = jfc.getSelectedFile();
		String path = file.getPath();
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		//ObjectOutputStream 보조스트림 제어
		
		try {
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			/*oos.writeObject(u1);
			oos.writeObject(u2);*/
			
			//객체배열로 저장
			oos.writeObject(vo);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
//		//파일로 저장
//		JFileChooser jfc = new JFileChooser();
//		int returnVal = jfc.showSaveDialog(null);
//		File file = jfc.getSelectedFile();
//		FileOutputStream fos = null;
//		if(returnVal == JFileChooser.APPROVE_OPTION) {
//			 try {
//	                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//	                bw.write(vo.toString());
//	                bw.flush();
//	                bw.close();
//	                 
//	            } catch(Exception e) {
//	            	e.printStackTrace();
//	            }
//			
//		}
	}
	
	//파일 불러오기 메서드
	public SurveyVO loadSurvey(String fileName) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		SurveyVO vo = null;
		
		try {
			ois = new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream(fileName)));
			

			vo = (SurveyVO)ois.readObject();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
}
