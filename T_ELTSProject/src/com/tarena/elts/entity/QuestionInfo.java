package com.tarena.elts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 问题和用户答案的值对象，表示界面上的一道题和对应的用户答案
 * 是值对象
 * */
public class QuestionInfo implements Serializable{
	private static final long 
	serialVersionUID = -955582434530401064L;
	private Question question;
	/** 在试卷（paper）中的序号 0，1，2 */
	private int questionIndex;
	/** 用户答案 */
	private List<Integer> userAnswers=
		new ArrayList<Integer>();
    
	public QuestionInfo(){
	}
	
	public QuestionInfo(int questionIndex,Question question){
		this.questionIndex=questionIndex;
		this.question=question;
	}
	
	public QuestionInfo(int questionIndex,Question question,
			List<Integer> userAnswers){
		super();
		this.questionIndex=questionIndex;
		this.question=question;
		this.userAnswers=userAnswers;
	}
	
	public void setQuestion(Question question){
		this.question=question;
	}
	
	public Question getQuestion(){
		return question;
	}
	
	public void setQuestionIndex(int questionIndex){
		this.questionIndex=questionIndex;
	}
	
	public int getQuestionIndex(){
		return questionIndex;
	}
	
	public void setUserAnswers(List<Integer> userAnswers){
		this.userAnswers=userAnswers;
	}
	
	public List<Integer> getUserAnswers(){
		return userAnswers;
	}
	
	@Override
	public String toString(){
		return question.toString();
	}
}
