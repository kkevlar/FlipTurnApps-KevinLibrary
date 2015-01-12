package com.flipturnapps.kevinLibrary.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class KJComponent extends JComponent {

	public KJComponent() 
	{
		enableInputMethods(true);
	}
	@Override
	public Dimension getPreferredSize()
	{
		return this.kGetPreferredSize();
	}
	protected abstract Dimension kGetPreferredSize();
	@Override
	public Dimension getMinimumSize()
	{
		return this.kGetMinimumSize();
	}
	protected abstract Dimension kGetMinimumSize();  
	@Override
	public Dimension getMaximumSize()
	{
		return this.kGetMaximumSize();
	}
	protected abstract Dimension kGetMaximumSize();

	protected abstract void  kPaintComponent(Graphics g);
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.kPaintComponent(g);
	}

}
