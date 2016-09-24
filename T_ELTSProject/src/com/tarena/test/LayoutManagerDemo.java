package com.tarena.test;

import java.awt.*;
import javax.swing.*;

public class LayoutManagerDemo {
	public static void main(String[] args) {
		JFrame frame=new JFrame("布局管理测试");
		JPanel content=new JPanel(new BorderLayout());
		JPanel bottom=new JPanel(new BorderLayout());
		JPanel right=new JPanel(new FlowLayout());
		JPanel center=new JPanel(new FlowLayout());
		JButton ok=new JButton("OK");
		JButton canel=new JButton("Canel");
		JButton help=new JButton("Help");
		right.add(ok);
		right.add(canel);
		center.add(help);
		bottom.add(BorderLayout.EAST,right);
		bottom.add(BorderLayout.CENTER,center);
		content.add(BorderLayout.SOUTH,bottom);
		frame.setContentPane(content);
		frame.setSize(600,400);
		frame.setVisible(true);
	}

}
