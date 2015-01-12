package com.flipturnapps.kevinLibrary.helper;
import javax.swing.*;

public class JFrameHelper
{
	public static JFrame setUpDefaultFrame(JFrame frame, String title)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setTitle(title);
		frame.setVisible(true);
		
		return frame;
	}
	public static JFrame setUpDefaultFrame(JFrame frame)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setTitle("");
		frame.setVisible(true);
		
		return frame;
	}
	public static JFrame makeUnclosable (JFrame frame)
	{
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		return frame;
	}
	public static JFrame makeClosable (JFrame frame)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
}
