package com.flipturnapps.kevinLibrary.gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class KJButtonPackage extends JPanel
{
	private JButton[] buttons;
	private Listener[] listeners;
	private int totalnumber = 0;
	public KJButtonPackage(int number)
	{
		super();
		totalnumber = number;
		buttons = new JButton[number];
		listeners = new Listener[number];
		for (int i = 0; i < number; i++)
		{
			buttons[i] = new JButton();
			add(buttons[i]);
			
			listeners[i] = new Listener(i);
			buttons[i].addActionListener(listeners[i]);
		}
	}
	public JButton getButton (int x)
	{
		return buttons[x];
	}
	public int getButtonCount()
	{
		return totalnumber;
	}
	private void clicked(int x)
	{
		buttonClicked(x);
	}
	
	public abstract void buttonClicked (int x);
	private class Listener implements ActionListener
	{
		int mynumber = -1;
		public Listener (int x)
		{
			mynumber = x;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			clicked(mynumber);
			
		}
		
	}
	
	public void performedAction() {
		buttonClicked(0);
		
	}
}
