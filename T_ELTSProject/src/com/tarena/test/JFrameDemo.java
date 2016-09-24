package com.tarena.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.*;

public class JFrameDemo {
	public static void main(String[] args) {
		//"14.jpg"是相对路径，也可以使用绝对路径：
		///home/jsd1112/Desktop/javacode/T_ELTSProject/src/com/tarena/test/14.jpg
	URL url=JFrameDemo.class.getResource("14.jpg");
	ImageIcon img=new ImageIcon(url);
	JFrame frame=new JFrame("照片加载");
	JPanel panel=new JPanel();
	JLabel label=new JLabel(img);
	panel.add(label);
	frame.setContentPane(panel);
	frame.setSize(400,300);
	frame.setVisible(true);
	
	
	}

}
