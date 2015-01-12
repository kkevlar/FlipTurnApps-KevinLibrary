package com.flipturnapps.kevinLibrary.newgui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class OutputWindow {

	private JFrame frame;
	private JScrollPane pane;
	private KJTextArea area;
	public OutputWindow(String title, boolean exitOnClose) 
	{
		frame = new JFrame();
		frame.setSize(600,300);
		if(exitOnClose == true)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		else
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle(title);
		frame.getContentPane().setBackground(KevinColor.kblack);
		area = new KJTextArea();
		area.setBackground(KevinColor.kblack);
		area.setForeground(KevinColor.kwhite);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		pane =new JScrollPane(area);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.setContentPane(pane);
		frame.setVisible(true);
	}
	public void println(String text)
	{
		area.println(text);
	}
	public void print(String text)
	{
		area.print(text);
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public JScrollPane getScrollPane()
	{
		return pane;
	}
	public KJTextArea getTextArea()
	{
		return area;
	}

}
