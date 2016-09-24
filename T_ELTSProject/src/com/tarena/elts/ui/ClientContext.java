package com.tarena.elts.ui;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

public class ClientContext implements Serializable{
	private static final long 
	serialVersionUID = -4939898234029810140L;
	
	private LoginFrame loginFrame;
    private MenuFrame menuFrame;
    private ExamFrame examFrame;
    private WelcomeWindow welcomeWindow;
    private ExamRuleFrame ruleFrame;
    private ExamService examService;
    private QuestionInfo currentQuestionInfo;
    private ExamInfo examInfo;
    private Timer timer;
    
    //依赖注入
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	
	public void setMenuFrame(MenuFrame menuFrame){
		this.menuFrame=menuFrame;
	}
	
	public void setExamFrame(ExamFrame examFrame){
		this.examFrame=examFrame;
	}
	
	public void setWelcomeWindow(WelcomeWindow welcomeWindow){
		this.welcomeWindow=welcomeWindow;
	}
	
	public void setExamRuleFrame(ExamRuleFrame ruleFrame){
		this.ruleFrame=ruleFrame;
	}
	
	public void setExamService(ExamService examService){
		this.examService=examService;
	}
	
	public void login(){
		try{
		//从登录界面获取ID和Pwd
		int id=loginFrame.getUserId();
		String pwd=loginFrame.getPwd();
		//调用业务模型的登录功能
		User loginUser=examService.login(id,pwd);
		//此处的login方法的声明是抽象的。但运行期间绑定到具体的方法上
		/*用户如果不存在或者密码错误，ExamServiceImpl中的login方法
		  会抛出自定义异常，并将异常抛到调用层（此方法）中，若底层抛出
		  异常，此方法会在此处直接跳到catch语句，开始处理异常，下面的更新界面
		  的语句就不在执行，如果用户存在且密码正确，则底层login方法会将一个User对象
		  返回到此处，程序开始执行下面的语句，开始更新界面；*/
		
		//更新menuFrame界面,显示登录用户信息
		menuFrame.updateView(loginUser);
		//如果登录成功就关闭登录界面，打开菜单界面
		loginFrame.setVisible(false);
		menuFrame.setVisible(true);
		}catch(IdOrPwdException e){
		//如果登录失败就留在登录界面，并且在界面上提示错误信息
		   loginFrame.showMessage(e.getMessage());
		}catch(NumberFormatException e){
//			e.printStackTrace();
			loginFrame.showMessage("编号必须是数字！");
		}catch(Exception e){
//			e.printStackTrace();
			loginFrame.showMessage(e.getMessage());
		}
	}
	
	public void exit(JFrame source){
		int value=JOptionPane.showConfirmDialog(source, 
				"亲，离开吗？", "", JOptionPane.YES_NO_OPTION);
		if(value==JOptionPane.YES_OPTION){
			//source.setVisible(false);//此句只是将当前窗口设置
			                              //为比可见，程序并未关闭
			//System.exit(0)结束当前Java进程
			System.exit(0);
		}
	}

	public void show(){
		welcomeWindow.setVisible(true);
		final Timer timer=new Timer();
		timer.schedule(new TimerTask(){//闪屏
			public void run(){
				welcomeWindow.setVisible(false);
				loginFrame.setVisible(true);	
				timer.cancel();
			}
		}, 2000);		
	}

	public void start(){
		try{
		//调用业务层方法开始考试，返回考试详细信息
		   ExamInfo examInfo=examService.start();	
		//调用业务层方法取回第一道题
		   QuestionInfo questionInfo=
			   examService.getQuestion(0);
		//保持当前题状态
		   currentQuestionInfo=questionInfo;
		//保持考试信息状态
		   this.examInfo=examInfo;
		//更新ExamFrame，显示考试信息和第一道题
			examFrame.updateView(examInfo,questionInfo);
		//关闭菜单界面
			menuFrame.setVisible(false);
		//打开考试界面
			examFrame.setVisible(true);
			startTimer();
		}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(
					menuFrame, e.getMessage());
			//高级的异常处理
		}
	}
	
	public void next(){
		try{
			//取得当前题号
			int index=currentQuestionInfo.getQuestionIndex();
			//保存当前考题的用户答案到业务层
			List<Integer> userAnswers=examFrame.getUserAnswers();
			examService.saveUserAnswer(index,userAnswers);
			//取得下一题
			QuestionInfo questionInfo=
				examService.getQuestion(index+1);
			currentQuestionInfo=questionInfo;
			//更新考试界面，显示下一题目
			examFrame.updateView(examInfo, questionInfo);
			}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(
					examFrame, e.getMessage());
		}
	}

	public void prev(){
		try{
			int index=currentQuestionInfo.getQuestionIndex();
			List<Integer> userAnswers=examFrame.getUserAnswers();
			examService.saveUserAnswer(index, userAnswers);
			QuestionInfo questionInfo=examService.getQuestion(index-1);
			currentQuestionInfo=questionInfo;
			examFrame.updateView(examInfo, questionInfo);
		}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(
					examFrame, e.getMessage());
		}
	}
	
	/**交卷*/
	public void send(){
		int val=JOptionPane.showConfirmDialog(
				examFrame, "有木有打算交卷？","",JOptionPane.YES_NO_OPTION);
		if(val!=JOptionPane.YES_OPTION){
			return ;
		}
		gameOver();
	}
	
	public void gameOver(){
		try{
			int index=
				currentQuestionInfo.getQuestionIndex();
			//获取最后的用户答案
			List<Integer> userAnswers=
				examFrame.getUserAnswers();
			//保存用户答案
			examService.saveUserAnswer(
					index, userAnswers);
			//交卷处理
			int score=examService.send();
			//显示分数
			timer.cancel();
			JOptionPane.showMessageDialog(
					examFrame, "分数："+score);
			//关闭考试界面
			examFrame.setVisible(false);
			//返回菜单界面
			menuFrame.setVisible(true);
		}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(
					examFrame, e.getMessage());
		}
	}
	
	public void result(){
		try{
			int score=examService.getScore();
			JOptionPane.showMessageDialog(
					menuFrame, "分数："+score);
		}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(
					menuFrame, e.getMessage());
		}
	}
	
	public void examRule() {
		String ruleString=examService.examRule();
		ruleFrame.updateView(ruleString);
		menuFrame.setVisible(false);
		ruleFrame.setVisible(true);		
	}
	
	private void startTimer(){
		timer=new Timer();
		long start=System.currentTimeMillis();
		final long end=
			examInfo.getTimeLimit()*60*1000+start;
		timer.schedule(new TimerTask(){
			public void run(){
				long show=end-System.currentTimeMillis();
				long h=show/1000/60/60;
				long m=show/1000/60%60;
				long s=show/1000%60;
				examFrame.updateTime(h,m,s);
			}
		}, 0,1000);
		//时间到自动交卷
		timer.schedule(new TimerTask(){
			public void run(){
				gameOver();
			}
		}, new Date(end));
	}

	//ExamRuleFrame中调用的方法：
	public void agree() {
		ruleFrame.setVisible(false);
		menuFrame.setVisible(true);
		
	}

	public void disagree() {	
		int value=JOptionPane.showConfirmDialog(
				ruleFrame, "您是要离开考试系统吗？", "", JOptionPane.YES_NO_OPTION);
		if(value==JOptionPane.YES_OPTION){
		System.exit(0);
		}
	}

	
}
