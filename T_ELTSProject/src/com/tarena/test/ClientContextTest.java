package com.tarena.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.util.Config;

public class ClientContextTest {
	private static List<QuestionInfo> paper=
   	 new ArrayList<QuestionInfo>();

	public static void main(String[] args) {
		ExamServiceImpl examService=new ExamServiceImpl();
		Config config=new Config("client.properties");
		EntityContext entityContext=new EntityContext(config);
		
		
		
		examService.setEntityContext(entityContext);
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
   		
	}
   	 System.out.println(paper.toString());
//		System.out.println(ec.findQuestions(Question.LEVEL3).toString());
		//System.out.println(examService.entityContext.findQuestions(1));
	}
}
