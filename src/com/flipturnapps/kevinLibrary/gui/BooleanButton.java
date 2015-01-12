package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BooleanButton  extends JButton
{
	public boolean pressed = false;
	public BooleanButton()
	{
		super();
		addActionListener(new Listener());
	}
	
	private class Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pressed = true;
			
		}
		
	}
}
