package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;

public class ExamFrame extends JFrame {
	private static final long serialVersionUID = -5355432125621015300L;
	// 选项集合，方便答案读取的处理
	private Option[] options = new Option[4];
	private JLabel examInfo;
	private JTextArea questionArea;
	private JLabel questionCount;
	private JLabel timer;
	private JButton prev;
	private JButton next;
	private JButton send;
	// 客户端界面控制器
	private ClientContext clientContext;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public ExamFrame() {
		init();
	}

	private void init() {
		setTitle("达内科技在线测评");
		setSize(600, 380);
//		setLocation(450, 300);
		setLocationRelativeTo(null);
		//setResizable(false);// 是否可由用户调整大小。
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				JOptionPane.showMessageDialog(
						ExamFrame.this,"交卷后才能离开！");
			}
		});
		setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(6, 6, 6, 6));
		//在Border的四周（上、左、下、右（逆时针））
		ImageIcon ico = new ImageIcon(getClass().getResource(
				"Images/exam_title.png"));
		p.add(BorderLayout.NORTH, new JLabel(ico));
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH, createToolsPane());
		return p;
	}

	private JPanel createCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		examInfo = new JLabel(// 不能在重复定义examInfo，否则
				// 更新信息时会发生错误
				"姓名：xxx编号：xxxx考试时间：xxxx" +
				"考试科目:xxxx题目数量：xxxx", JLabel.CENTER);
		p.add(BorderLayout.NORTH, examInfo);
		p.add(BorderLayout.CENTER, createQuestionPane());
		p.add(BorderLayout.SOUTH, createOptionsPane());
		return p;
	}

	private JScrollPane createQuestionPane() {
		JScrollPane p = new JScrollPane();
		p.setBorder(new TitledBorder("题目"));// 标题框
		// 注意
		questionArea = new JTextArea();
		questionArea.setText("问题\nA.\nB.");
		questionArea.setLineWrap(true);// 允许折行显示
		questionArea.setEditable(false);// 不允许编辑内容
		// JTextArea必须放到JScrollPane的视图区域中（ViewPort）
		p.getViewport().add(questionArea);
		return p;
	}

	private JPanel createOptionsPane() {
		JPanel p = new JPanel();
		Option a = new Option(0, "A");
		Option b = new Option(1, "B");
		Option c = new Option(2, "C");
		Option d = new Option(3, "D");
		options[0] = a;
		options[1] = b;
		options[2] = c;
		options[3] = d;
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		return p;
	}

	private JPanel createToolsPane() {
		JPanel p = new JPanel(new BorderLayout());
		questionCount = new JLabel("题目：20的第1题");
		timer = new JLabel("剩余时间：222秒");
		p.add(BorderLayout.WEST, questionCount);
		p.add(BorderLayout.CENTER, createBtnPane());
		p.add(BorderLayout.EAST, timer);
		return p;
	}

	private JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		prev = new JButton("上一题");
		next = new JButton("下一题");
		send = new JButton("交卷");
		pane.add(prev);
		pane.add(next);
		pane.add(send);

		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.prev();
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.next();
			}
		});

		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.send();
			}
		});

		return pane;
	}

	/** 使用内部类扩展JCheckBox,增加了val属性，代表答案值 */
	class Option extends JCheckBox {
		private static final long serialVersionUID = -5357210068923979044L;
		int value;

		public Option(int val, String txt) {
			super(txt);
			this.value = val;
		}
	}

	public void updateView(ExamInfo examInfo, QuestionInfo questionInfo) {
		this.examInfo.setText(examInfo.toString());
		questionArea.setText(questionInfo.toString());

		updateButtons(examInfo.getQuestionCount(),
				questionInfo.getQuestionIndex());
		updateQuestionCount(examInfo.getQuestionCount(),
				questionInfo.getQuestionIndex());
		updateOptions(questionInfo.getUserAnswers());
	}

	private void updateButtons(int questionCount, int questionIndex) {
		prev.setEnabled(questionIndex!=0);
		next.setEnabled((questionCount-1)!=questionIndex);
	}

	private void updateQuestionCount(int questionCount, int questionIndex) {
		String str="题目："+questionCount+"  的"+(questionIndex+1)+"  题";
        this.questionCount.setText(str);
	}

	private void updateOptions(List<Integer> userAnswers) {
       for(Option option:options){
    	   option.setSelected(
    			   userAnswers.contains(option.value));
       }
	}

	public List<Integer> getUserAnswers() {
		List<Integer> list = new ArrayList<Integer>();
		for (Option option : options) {
			if (option.isSelected()) {
				list.add(option.value);
			}
		}
		return list;
	}

	// 更新考试倒计时
	public void updateTime(long h, long m, long s) {
		String time = h + ":" + m + ":" + s;
		if (h==0&&m < 5) {
			timer.setForeground(new Color(0xc85848));
		} else {
			timer.setForeground(Color.blue);
		}
		timer.setText(time);
	}
}
