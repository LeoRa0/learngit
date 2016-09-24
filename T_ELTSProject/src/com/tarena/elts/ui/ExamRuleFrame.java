package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ExamRuleFrame extends JFrame {
	private static final long 
	serialVersionUID = 5947771840901111344L;
	private JTextArea ruleArea;
	private JButton agree;
	private JButton disagree;
	private ClientContext clientContext;
	
	public void setClientContext(ClientContext clientContext){
		this.clientContext=clientContext;
	}

	public ExamRuleFrame() {
		init();
	}

	private void init() {
		setTitle("考试规则");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
//				clientContext.exit(ExamRuleFrame.this);
				JOptionPane.showMessageDialog(
						ExamRuleFrame.this, "返回菜单界面，请选择“同意”；" +
								"离开本系统，请选择“不同意”！");
			}
		});
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"Images/title.png"));
		pane.add(BorderLayout.NORTH, new JLabel(icon));
		pane.add(BorderLayout.CENTER, createCenterPane());
		pane.add(BorderLayout.SOUTH, createSouthPane());
		return pane;
	}

	private JScrollPane createCenterPane() {
		JScrollPane pane = new JScrollPane();
		pane.setBorder(new TitledBorder("考试规则："));
		ruleArea = new JTextArea();
		ruleArea.setText("考试对则");
//		this.ruleArea.setFont(
//				new Font("Courier New",Font.PLAIN,18));
		ruleArea.setLineWrap(true);
		ruleArea.setEditable(false);
		pane.getViewport().add(ruleArea);
		return pane;
	}

	private JPanel createSouthPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.CENTER, createBtnPane());
		pane.add(BorderLayout.SOUTH, new JLabel(
				"达内科技—版权所有，盗版必究", JLabel.RIGHT));
		return pane;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		agree = new JButton("同 意");
		disagree=new JButton("不同意");
		pane.add(agree);
		pane.add(disagree);
		getRootPane().setDefaultButton(agree);
		
		agree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.agree();
			}
		});
		
		disagree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.disagree();
			}
		});
		
		return pane;
	}
	
	public void updateView(String ruleString){
		this.ruleArea.setText(ruleString);
	}
}
