package com.tarena.elts.service;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/** 软件的核心功能的抽象(业务接口)，核心业务功能：登录，开始考试... */
public interface ExamService {
	User login(int id, String pwd) throws IdOrPwdException;

	ExamInfo start();

	QuestionInfo getQuestion(int index);

	void saveUserAnswer(int index, 
			List<Integer> userAnswers);

	int send();

	int getScore();

	String examRule();

}
