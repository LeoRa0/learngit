package com.tarena.elts.entity;

import java.io.Serializable;

/**
 * 考试信息值对象。
 * 是值对象
 * @author 饶龙
 * */
public class ExamInfo implements Serializable{
	private static final long 
	serialVersionUID = -5555553953638661258L;
	/** 考试科目 */
	private String title;
	/** 考生*/
	private User user;
	/** 考试时间（单位：分钟）*/
	private int timeLimit;
	private int questionCount;
	
	public ExamInfo(){
	}
	
	public ExamInfo(String title,User user,int timeLimit,
			int questionCount){
		super();
		this.title=title;
		this.user=user;
		this.timeLimit=timeLimit;
		this.questionCount=questionCount;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setTimeLimit(int timeLimit){
		this.timeLimit=timeLimit;
	}
	
	public int getTimeLimit(){
		return timeLimit;
	}
	
	public void setQuestionCount(int questionCount){
		this.questionCount=questionCount;
	}
	
	public int getQuestionCount(){
		return questionCount;
	}
	
	@Override
	public String toString(){
		if(user==null){
			return "无信息！";
		}
		return "姓名："+user.getName()+"   编号："+user.getId()+
		        "   考试时间："+timeLimit+"分钟"+"   考试科目："+title+
		        "   题目数量："+questionCount;
	}
}
