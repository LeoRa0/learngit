package com.tarena.elts.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
/**
 * Question对象代表一道试题。
 * 包含题干和四个选项以及正确答案
 * */
public class Question implements Serializable{
	private static final long 
	serialVersionUID = 4282935183995815438L;
	//试题难度等级
	public static final int LEVEL1=1;
    public static final int LEVEL2=2;
    public static final int LEVEL3=3;
    public static final int LEVEL4=4;
    public static final int LEVEL5=5;
    public static final int LEVEL6=6;
    public static final int LEVEL7=7;
    public static final int LEVEL8=8;
    public static final int LEVEL9=9;
    public static final int LEVEL10=10;
    
    //单选还是多选
    public static final int SINGLE_SELECTION=0;
    public static final int MULTI_SELECTION=1;
    
    private int id;
    private String title;//题干
    private List<String> options=
    	new ArrayList<String>();//若干选项
    private List<Integer> answers=
    	new ArrayList<Integer>();//正确答案
    private int score;
    private int level;
    private int type;//类型：单选（SINGLE_SELECTION）
    //多选（MULTI_SELECTION）
    
    public Question(){
    }
    
    public void setId(int id){
    	this.id=id;
    }
    
    public int getId(){
    	return id;
    }
    
    public void setTitle(String title){
    	this.title=title;
    }
    
    public String getTitle(){
    	return title;
    }
    
    public void setOptions(List<String> options){
    	this.options=options;
    }
    
    public List<String> getOptions(){
    	return options;
    }
    
    public void setAnswers(List<Integer> answers){
    	this.answers=answers;
    }
    
    public List<Integer> getAnswers(){
    	return answers;
    }
    
    public void setScore(int score){
    	this.score=score;
    }
    
    public int getScore(){
    	return score;
    }
    
    public void setLevel(int level){
    	this.level=level;
    }
    
    public int getLevel(){
    	return level;
    }
    
    public void setType(int type){
    	this.type=type;
    }
    
    public int getType(){
    	return type;
    }
    @Override
    public String toString(){//以字符串形式返回一道题的题目和四个选项
    	StringBuffer sb=new StringBuffer(title+"\n");
    	for(int i=0;i<options.size();i++){
    		sb.append((char)(i+'A')+"."+options.get(i)+"\n");
    	}
    	sb.append("\n");
    	return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj){
    	if(obj==null){
    		return false;
    	}
    	if(this==obj){
    		return true;
    	}
    	if(obj instanceof Question){
    		Question other=(Question)obj;
    		return this.id==other.id;
    	}
    	return false;
    }
    @Override
    public int hashCode(){
    	return id;
    }
}
