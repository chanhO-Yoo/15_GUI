package com.gui.mvc.survey.model.vo;

import java.io.Serializable;
import java.util.List;

/*
 * 사용자가 입력한 설문조사 데이터
 * 이름,나이,성별 ...
 * 
 */
public class SurveyVO implements Serializable {
	//field
	private String name;
	private int age;
	private char gender;
	private List<String> interest;
	private String etc;
	
	//constructor
	public SurveyVO() {
		
	}
	public SurveyVO(String name, int age, char gender, List<String> interest, String etc) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.interest = interest;
		this.etc = etc;
	}
	
	//getter & setter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public List<String> getInterest(){
		return interest;
	}
	public String getEtc() {
		return etc;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	@Override
	public String toString() {
		return name+", "+age+", "+gender+", "+interest+", "+etc;
	}
}
