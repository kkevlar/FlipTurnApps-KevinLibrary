package com.flipturnapps.kevinLibrary.gui;

import javax.swing.*;

import com.flipturnapps.kevinLibrary.helper.KevinChars;
import com.flipturnapps.kevinLibrary.helper.ListenerHelper;

import java.awt.event.*;
import java.awt.*;


public class KJPanel extends JPanel {
	private boolean leftKeyDown;
	private boolean rightKeyDown;
	private boolean upKeyDown;
	private boolean downKeyDown;
	private boolean mouseIn;
	private boolean leftMouseDown;
	private boolean centerMouseDown;
	private boolean rightMouseDown;
	private boolean spaceKeyDown;
	private boolean[] letterKeyDown = new boolean[26];
	private boolean controlKeyDown;
	private boolean shiftKeyDown;
	

	public KJPanel() {
		super();
		startListeners();
	}
	private void startListeners()
	{
		this.addKeyListener(new Listener());
		this.addMouseListener(new Listener());
	}
	public boolean leftKeyDown()
	{
		return leftKeyDown;
	}
	public boolean[] letterKeyDown()
	{
		return letterKeyDown;
	}
	public boolean downKeyDown()
	{
		return downKeyDown;
	}
	
	public boolean rightKeyDown()
	{
		return rightKeyDown;
	}
	public boolean upKeyDown()
	{
		return upKeyDown;
	}
	public boolean leftMouseDown()
	{
		return leftMouseDown;
	}
	public boolean mouseDown()
	{
		return leftMouseDown;
	}
	public boolean spaceKeyDown()
	{
		return spaceKeyDown;
	}
	public boolean controlKeyDown()
	{
		return controlKeyDown;
	}
	public boolean shiftKeyDown()
	{
		return shiftKeyDown;
	}
	public boolean centerMouseDown()
	{
		return centerMouseDown;
	}
	public boolean rightMouseDown()
	{
		return rightMouseDown;
	}
	public boolean mouseIn()
	{
		return mouseIn;
	}
	private class Listener implements KeyListener, MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			mouseIn = true;
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			mouseIn = false;
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getModifiers() == InputEvent.BUTTON1_MASK)
				leftMouseDown = true;
			if (e.getModifiers() == InputEvent.BUTTON2_MASK)
				centerMouseDown = true;
			if (e.getModifiers() == InputEvent.BUTTON3_MASK)
				rightMouseDown = true;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			if (e.getModifiers() == InputEvent.BUTTON1_MASK)
				leftMouseDown = false;
			if (e.getModifiers() == InputEvent.BUTTON2_MASK)
				centerMouseDown = false;
			if (e.getModifiers() == InputEvent.BUTTON3_MASK)
				rightMouseDown = false;
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == e.VK_LEFT)
				leftKeyDown = true;
			if (e.getKeyCode() == e.VK_RIGHT)
				rightKeyDown = true;
			if (e.getKeyCode() == e.VK_UP)
				upKeyDown = true;
			if (e.getKeyCode() == e.VK_DOWN)
				downKeyDown = true;
			if (e.getKeyCode() == e.VK_SPACE)
				spaceKeyDown = true;
			if(e.getKeyCode() == e.VK_CONTROL)
				controlKeyDown = true;
			if(e.getKeyCode() == e.VK_SHIFT)
				shiftKeyDown = true;
			for(int i = 0; i < letterKeyDown.length; i++)
			{
				if (ListenerHelper.getText(e).equalsIgnoreCase(KevinChars.upalphabet[i] + ""))
					letterKeyDown[i] = true;
			}
			//System.out.println(e.getKeyText(e.getKeyCode()));
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == e.VK_LEFT)
				leftKeyDown = false;
			if (e.getKeyCode() == e.VK_RIGHT)
				rightKeyDown = false;
			if (e.getKeyCode() == e.VK_UP)
				upKeyDown = false;
			if (e.getKeyCode() == e.VK_DOWN)
				downKeyDown = false;
			if (e.getKeyCode() == e.VK_SPACE)
				spaceKeyDown = false;
			if(e.getKeyCode() == e.VK_CONTROL)
					controlKeyDown = false;
			if(e.getKeyCode() == e.VK_SHIFT)
				shiftKeyDown = false;
			for(int i = 0; i < letterKeyDown.length; i++)
			{
				if (ListenerHelper.getText(e).equalsIgnoreCase(KevinChars.upalphabet[i] + ""))
					letterKeyDown[i] = false;
			}
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	public double getMouseY()
	{
		Point p;
		try
		{
		p = getMousePosition();
		return p.getY();
		}
		catch (NullPointerException ex)
		{
			return -1;
		}
	}
	public double getMouseX()
	{
		Point p;
		try
		{
		p = getMousePosition();
		return p.getX();
		}
		catch (NullPointerException ex)
		{
			return -1;
		}
		
	}

}
