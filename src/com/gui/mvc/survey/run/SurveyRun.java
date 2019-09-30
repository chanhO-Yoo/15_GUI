package com.gui.mvc.survey.run;

import com.gui.mvc.survey.controller.SurveyController;
import com.gui.mvc.survey.view.Survey;

public class SurveyRun {
	public static void main(String[] args) {
		//survey객체에서 사용할 surveyController 객체를 주입,전달
		new Survey(new SurveyController());
	}
}
