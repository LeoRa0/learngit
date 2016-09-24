package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/**ClientContext：客户端上下文，作为客户端界面控制器*/
	private ClientContext clientContext;
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel message;
	Font font=new Font("行楷",Font.PLAIN,16);
	
	public void setClientContext(
			ClientContext clientContext){
		//clientContext的实例通过setClientContext()注入到
		//当前对象的属性this.clientContext中
		//这一过程叫依赖注入：IOC
		this.clientContext=clientContext;
	}
	
		public LoginFrame(){
			init();
		}
	
		/**初始化，登录窗口中的组件和布局*/
		private void init(){
			setTitle("登录考试系统");
			setSize(320,240);
			setResizable(false);//是否可由用户调整大小。
//			setLocation(550,400);//setLocation(Point p)将组件
//			//移到新位置。通过点 p 来指定新位置的左上角。
			setLocationRelativeTo(null);
			setContentPane(createContentPane());
			//创建并添加内容面板
			this.setDefaultCloseOperation(
					DO_NOTHING_ON_CLOSE);//接管操作
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					clientContext.exit(LoginFrame.this);
				}
			});
		}
		
		private JPanel createContentPane(){
			JPanel p=new JPanel(new BorderLayout());
			JLabel label=new JLabel("登录系统",JLabel.CENTER);
			label.setFont(font);
			p.setBorder(new EmptyBorder(20,15,20,15));
			p.add(BorderLayout.NORTH,label);			
			p.add(BorderLayout.CENTER,createCenterPane());
			p.add(BorderLayout.SOUTH,createBottomPane());
			return p;
		}
	
		private JPanel createCenterPane(){
			JPanel p=new JPanel(new BorderLayout());
			p.setBorder(new EmptyBorder(10,0,0,0));
			p.add(BorderLayout.NORTH,createIdPwdPane());				
			message=new JLabel("",JLabel.CENTER);
			p.add(BorderLayout.CENTER,message);
			return p;
		}
		
		private JPanel createIdPwdPane(){
			JPanel p=new JPanel(new GridLayout(2,1,0,15));
			p.add(createIdPane());
			p.add(createPwdPane());
			return p;
		}
		
		private JPanel createIdPane(){
			JPanel p=new JPanel(new BorderLayout());			
			JLabel label=new JLabel("编号");
			label.setFont(font);			
			p.add(BorderLayout.WEST,label);
			JTextField idField=new JTextField();
			idField.setFont(font);
			this.idField=idField;//*****漏写的话，会出现空指针异常
			p.add(BorderLayout.CENTER,idField);
			return p;
		}
		
		private JPanel createPwdPane(){
			JPanel p=new JPanel(new BorderLayout());
			JLabel label=new JLabel("密码");
			label.setFont(font);
			p.add(BorderLayout.WEST,label);
			JPasswordField pwdField=new JPasswordField();
			this.pwdField=pwdField;//*****漏写的话，会出现空指针异常
			pwdField.enableInputMethods(true);//Linux bug
			p.add(BorderLayout.CENTER,pwdField);
			return p;
		}
		
		private JPanel createBottomPane(){
			JPanel p=new JPanel(new FlowLayout());
			JButton login=new JButton("登录");
			JButton cancel=new JButton("取消");
			login.setFont(font);
			cancel.setFont(font);
			p.add(login);
			p.add(cancel);
			
			getRootPane().setDefaultButton(login);
		     //设置登录界面的默认按钮
			//login事件监听器
			login.addActionListener(new ActionListener(){
				//当按钮对象被点击时，会执行方法actionPerformed()
				//ActionListener()监听login按钮何时被点击
				//ActionEvent e是按钮点击的时候，场景信息（点击位置）
				//点击了那个对象（那个按钮）等
				public void actionPerformed(ActionEvent e){
					//System.out.println("点击了login"+e.getWhen());
				//访问控制器提供的登录方法，完成登录流程
					//clientContext.login()依赖ClientContext实例
					clientContext.login();
				}
			});
			//cancel事件监听器
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					clientContext.exit(LoginFrame.this);
				}
			});
			
			return p;
			}
				
		public int getUserId(){
			return Integer.parseInt(idField.getText());
		}
		
		public String getPwd(){
			return new String(pwdField.getPassword());
			//Sun公司认为：密码存放在字符数组中比字符串类型安全，
			//所以Java中的JPasswordField中存放的是字符数组，
			//但在此要将其转化为字符串，因为处理字符串比处理字符数组更加方便
		}
		
		public void showMessage(String message){
			this.message.setText(message);
		}
		
		
}
