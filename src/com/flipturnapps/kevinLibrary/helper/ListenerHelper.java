package com.flipturnapps.kevinLibrary.helper;

import java.awt.event.KeyEvent;

public class ListenerHelper {
	public static String getText(KeyEvent e)
	{
		return KeyEvent.getKeyText(e.getKeyCode());
	}
	public static boolean keyEquals(KeyEvent e, String text)
	{
		return KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase(text);
	}
	

}
