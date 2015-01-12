package com.flipturnapps.kevinLibrary.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.flipturnapps.kevinLibrary.helper.KevinColor;
import com.flipturnapps.kevinLibrary.newgui.KJTextArea;


public class ErrorWindow 
{
	public ErrorWindow (String text)
	{
		JFrame frame = new JFrame();
		KJTextArea label = new KJTextArea();
		label.setBackground(KevinColor.kwhite);
		label.setForeground(KevinColor.kred);
		frame.add(label.setUpDefault());
		label.print(text);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Message From Program");
		
		
	}
}
