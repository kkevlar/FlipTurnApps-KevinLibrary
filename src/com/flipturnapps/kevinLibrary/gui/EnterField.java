package com.flipturnapps.kevinLibrary.gui;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import com.flipturnapps.kevinLibrary.helper.ListenerHelper;

public class EnterField extends JTextField {

	private String lastText;
	public EnterField() {
		super();
		enterFieldSetUp();
	}

	private void enterFieldSetUp() {
		this.addKeyListener(new EnterListener());
		
	}

	public EnterField(String string) {
		super(string);
		enterFieldSetUp();
	}

	public EnterField(int columns) {
		super(columns);
		enterFieldSetUp();
	}
	private class EnterListener implements java.awt.event.KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e) {
			if(ListenerHelper.keyEquals(e, "enter"))
			{
				enterrPressed();
			}
			
		}

		

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public String getLastText()
	{
		return lastText;
	}
	protected void enterrPressed()
	{
		lastText = this.getText();
		this.setText("");
	}

	

}
