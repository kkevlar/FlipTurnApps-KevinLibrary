package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class ArrowKeysListener implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("right"))
			ArrowKeys.RIGHT = true;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("left"))
			ArrowKeys.LEFT = true;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("up"))
			ArrowKeys.UP = true;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("down"))
			ArrowKeys.DOWN = true;


	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("right"))
			ArrowKeys.RIGHT = false;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("left"))
			ArrowKeys.LEFT = false;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("up"))
			ArrowKeys.UP = false;
		if (KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("down"))
			ArrowKeys.DOWN = false;



	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}