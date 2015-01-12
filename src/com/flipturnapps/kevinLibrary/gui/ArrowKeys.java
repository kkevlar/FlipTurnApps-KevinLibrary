package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.*;


public class ArrowKeys 
{
	public static boolean RIGHT = false;
	public static boolean LEFT = false;
	public static boolean UP = false;
	public static boolean DOWN = false;
	
	public static KeyListener getListener()
	{
		return new ArrowKeysListener();
	}
	
}
