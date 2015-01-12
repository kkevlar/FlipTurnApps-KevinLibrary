package com.flipturnapps.kevinLibrary.newgui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KDialog 
{
	public static void showMessage(String message)
	{
		KDialog.showMessage(message, null);
	}
	public static void showMessage(String message, JFrame frame)
	{
		KDialog.showMessage(message, "Message", frame, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void showMessage(String message, JFrame frame, int messageIcon)
	{
		KDialog.showMessage(message, "Message", frame, messageIcon);
	}
	public static void showMessage(String message, int messageIcon)
	{
		KDialog.showMessage(message, null, messageIcon);
	}
	public static void showMessage(String message, String title, JFrame frame)
	{
		KDialog.showMessage(message, title, frame, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void showMessage(String message, String title, JFrame frame, int messageIcon)
	{
		JOptionPane.showMessageDialog(frame, message, title, messageIcon);
	}
	public static boolean confirmMessage(String message, String title, JFrame frame)
	{
		int n = JOptionPane.showConfirmDialog(
				frame,
				message,
				title,
				JOptionPane.YES_NO_OPTION);
		return n == 0;
	}
	public static boolean confirmMessage(String message, JFrame frame)
	{
		return KDialog.confirmMessage(message, "Question", frame);
	}
	
}
