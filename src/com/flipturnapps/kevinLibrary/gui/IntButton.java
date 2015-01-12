package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IntButton extends JButton{

	public static int currId;
	public int id;
	public IntButton(int id)
	{
		super();
		this.id = id;
		this.addActionListener(new Listener());
	}
	public IntButton(int id, String text)
	{
		super();
		this.id = id;
		this.setText(text);
		this.addActionListener(new Listener());
	}
	private class Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			currId = id;
			
		}
		
	}
}
