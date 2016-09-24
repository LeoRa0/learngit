package com.tarena.test;

import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamRuleFrame;

public class RuleTest {
	
	
	public static void main(String[] args) {
		ClientContext clientContext=new ClientContext();
		ExamRuleFrame ruleFrame=new ExamRuleFrame();
		
		ruleFrame.setClientContext(clientContext);
		clientContext.setExamRuleFrame(ruleFrame);
		//因为ExamRuleFrame类和ClientContext类中的方法和属性除一个public(set...)方法
		//外，其他都是private的（都被封装在类里面了）,这两个类创建的对象之间，要想建立联系，
		//必须通过set方法相互注入,才能进行相互之间方法或属性的调用。
		ruleFrame.setVisible(true);
	}

}
