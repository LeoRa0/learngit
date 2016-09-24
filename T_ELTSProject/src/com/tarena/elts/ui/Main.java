package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.util.Config;

/**  软件入口 类   * */
public class Main {
	public static void main(String[] args) {
		LoginFrame loginFrame=new LoginFrame();
		MenuFrame menuFrame=new MenuFrame();
		ExamFrame examFrame=new ExamFrame();
		ExamRuleFrame ruleFrame=new ExamRuleFrame();
		WelcomeWindow welcomeWindow=new WelcomeWindow();
		
		ClientContext clientContext=new ClientContext();
		
		ExamServiceImpl examService=new ExamServiceImpl();
		
		Config config=new Config("client.properties");
		EntityContext entityContext=new EntityContext(config);
		
		//相互建立连接
		loginFrame.setClientContext(clientContext);
		menuFrame.setClientContext(clientContext);
		examFrame.setClientContext(clientContext);
		ruleFrame.setClientContext(clientContext);
		
		clientContext.setLoginFrame(loginFrame);
		clientContext.setExamService(examService);
		clientContext.setMenuFrame(menuFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setWelcomeWindow(welcomeWindow);
		clientContext.setExamRuleFrame(ruleFrame);
		
		examService.setEntityContext(entityContext);
		
		clientContext.show();
	}

}
