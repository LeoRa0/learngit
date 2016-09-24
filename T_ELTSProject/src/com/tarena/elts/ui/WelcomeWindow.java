package com.tarena.elts.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**  闪屏  */
public class WelcomeWindow extends JWindow{
	private static final long 
	serialVersionUID = 8464481258492664503L;

public WelcomeWindow(){
	   init();
   }
   
   private void init(){
	   setSize(430,300);
//	   setLocation(500,350);
	   setLocationRelativeTo(null);
	   JPanel pane=new JPanel(new BorderLayout());
	   ImageIcon ico=new ImageIcon(
			   this.getClass().getResource("Images/welcome.png"));
	   JLabel label=new JLabel(ico);
	   pane.add(BorderLayout.CENTER,label);
	   pane.setBorder(new LineBorder(Color.GRAY));
	   setContentPane(pane);
   }
}
