package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.flipturnapps.kevinLibrary.helper.ListenerHelper;

public abstract class EnterKeyListener implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(ListenerHelper.getText(e).equalsIgnoreCase("enter"))
			enterPress();
		
	}

	protected abstract void enterPress();

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
