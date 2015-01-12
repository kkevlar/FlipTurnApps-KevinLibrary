package com.flipturnapps.kevinLibrary.gui;

import java.awt.*;
import javax.swing.*;

import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class KJFrame extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6093685340888527692L;
	public KJFrame()
	{
		super();
	}
	public void setUp()
	{
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("");
		this.getContentPane().setBackground(KevinColor.kwhite);
	}
	public void setUp(Dimension d, String title)
	{
		this.setSize(d);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.getContentPane().setBackground(KevinColor.kwhite);
	}
	public void fillUp()
	{
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void fillUpWin()
	{
		this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 35) );
	}
	
}
