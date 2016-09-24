package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tarena.elts.entity.User;

public class MenuFrame extends JFrame {
	private static final long 
	serialVersionUID = -1796834130339697339L;

	private JLabel userInfo;
	private ClientContext clientContext;
	Font font=new Font("宋体",Font.PLAIN,16);

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public MenuFrame() {
		init();
	}

	private void init() {
		setTitle("达内在线测评");
		setSize(600, 400);
//		setLocation(450, 300);
		setLocationRelativeTo(null);
		setResizable(false);// 是否可由用户调整大小。
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				clientContext.exit(MenuFrame.this);
			}
		});
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"Images/title.png"));
		p.add(BorderLayout.NORTH, new JLabel(icon));
		p.add(BorderLayout.CENTER, createMenuPane());
		p.add(BorderLayout.SOUTH, new JLabel("达内科技—版权所有，盗版必究", JLabel.RIGHT));
		return p;
	}

	private JPanel createMenuPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(30,0,0,0));
		JLabel info = new JLabel("欢迎:XXX同学！", JLabel.CENTER);
		info.setFont(font);
		this.userInfo = info;
		p.add(BorderLayout.NORTH, info);
		p.add(BorderLayout.CENTER, createBtnPane());
		return p;
	}

	private JPanel createBtnPane() {
		JPanel p = new JPanel(new FlowLayout());
		p.setBorder(new EmptyBorder(15,0,0,0));
		JButton start = createImgBtn("Images/exam.png", "开始考试");
		JButton result = createImgBtn("Images/result.png", "获取分数");
		JButton msg = createImgBtn("Images/message.png", "考试规则");
		JButton exit = createImgBtn("Images/exit.png", "离开系统");
		p.add(start);
		p.add(result);
		p.add(msg);
		p.add(exit);

		getRootPane().setDefaultButton(start);// 设置界面打开时的默认按钮

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.start();
			}
		});
		
		result.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.result();
			}
		});
		
		msg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.examRule();
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.exit(MenuFrame.this);
			}
		});
		
		return p;
	}

	// 创建图片按钮
	private JButton createImgBtn(String img, String txt) {
		ImageIcon ico = new ImageIcon(this.getClass().getResource(img));
		JButton button = new JButton(txt, ico);
		// 垂直文本对齐位置
		button.setVerticalTextPosition(JButton.BOTTOM);
		// 水平文本对齐位置
		button.setHorizontalTextPosition(JButton.CENTER);
		return button;
	}

	// 更新登录后欢迎语句
	public void updateView(User loginUser) {
		userInfo.setText("欢迎  " + loginUser.getName() + " 童鞋！");
	}
}
