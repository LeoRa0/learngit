package com.tarena.test;

import javax.swing.*;

public class NullLayoutDemo {
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton ok=new JButton("OK");
		JButton canel=new JButton("Cancel");
		panel.setLayout(null);//设置布局为null，自定义管理布局
		ok.setLocation(325,308);//绝对布局
		ok.setSize(92,22);
		canel.setLocation(425,308);
		canel.setSize(92,22);
		frame.setContentPane(panel);
		panel.add(ok);
		panel.add(canel);
		frame.setSize(533,373);
		frame.setVisible(true);
	}

}
