package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**
 * 软件业务层实现
 * */
public class ExamServiceImpl implements ExamService{
     private int score;
     private boolean finish=false;
     private EntityContext entityContext;//数据层
     
     //依赖注入
     public void setEntityContext(
    		 EntityContext entityContext){
    	 this.entityContext=entityContext;
     }
     
     /**
      * 实现软件核心业务功能login方法
      * */
     public User login(int id,String pwd)
          throws IdOrPwdException{//覆盖接口中的方法
    	 User user=entityContext.findUserById(id);
    	 //按照id号在数据层查找用户，如果存在，返回User对象，如果
    	 //不存在返回null
    	 if(user==null){
    		 throw new IdOrPwdException("木有人呀！");
    	 }
    	 if(user.getPasswd().equals(pwd)){
    		 loginUser=user;//保留用户的登录状态
    		 return user;
    	 }
    	 throw new IdOrPwdException("密码错了吧！");
     }
     
     /**  考卷,考卷是考题的线性表集合  */
     private List<QuestionInfo> paper=
    	 new ArrayList<QuestionInfo>();
     private User loginUser;
     //抽题逻辑（将原题集合复制一边，在新集合中对其
     //进行操作（抽出题后将其删除）），复制集合的目的：在
     //删除题的同时不会影响到原题集合
     private void createPaper(){
    	 Random random=new Random();
    	 int i=0;
    	 for(int level=Question.LEVEL1;
    	 level<=Question.LEVEL10;level++){
    		 List<Question> list=
    			 entityContext.findQuestions(level);
    		 //复制集合
    		 Question q1=list.remove(
    				 random.nextInt(list.size()));
    		 //remove（）的返回值是集合中删除的元素
    		 Question q2=list.remove(
    				 random.nextInt(list.size()));
    		 paper.add(new QuestionInfo(i++,q1));
    		 paper.add(new QuestionInfo(i++,q2));
    		 //每个level中抽取两道题，放到paper集合中
    	 }
     }
     
     public ExamInfo start(){
    	 if(finish){
    		 throw new RuntimeException("考试已经结束！");
    	 }
    	//组织考卷
    	 createPaper();
    	//创建考试信息对象，组织考试信息
    	 ExamInfo examInfo=new ExamInfo();
    	 examInfo.setQuestionCount(paper.size());
    	 examInfo.setTimeLimit(entityContext.getTimeLimit());
    	 examInfo.setTitle(entityContext.getTitle());
    	 examInfo.setUser(loginUser);
    	 //返回考试信息
    	 return examInfo;
     }
	
     public QuestionInfo getQuestion(int index){
    	 return paper.get(index);
     }

	@Override
	public void saveUserAnswer(int index, 
			List<Integer> userAnswers) {
		QuestionInfo q=paper.get(index);
		q.getUserAnswers().clear();
		q.getUserAnswers().addAll(userAnswers);		
	}

	@Override
	public int send() {
		if(finish){
			throw new RuntimeException("考试已经结束！");
		}
		score=0;
		for(QuestionInfo info:paper){
			Question q=info.getQuestion();
			List<Integer> answers =q.getAnswers();
			List<Integer> userAnswers=info.getUserAnswers();
			if(answers.equals(userAnswers)){
				score +=q.getScore();
			}
		}
		finish=true;
		return score;
	}

	@Override
	public int getScore() {
		if(!finish){
			throw new RuntimeException("还没有考试！");
		}
		return score;
	}

	@Override
	public String examRule() {
		String i=entityContext.getStr();
		return i;
	}
}
