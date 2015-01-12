package com.flipturnapps.kevinLibrary.gui;

import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WindowsProgressBar extends JProgressBar{
	public WindowsProgressBar()
	{
		
		LookAndFeel look = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setUI(UIManager.getUI(this));
		try {
			UIManager.setLookAndFeel(look);
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.setStringPainted(true);
		this.setPreferredSize(new Dimension(200,50));
	}
}
