package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.io.Serializable;


public abstract class Sprite implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3707725221471108338L;
	private SpritePanel panel;
	private boolean visible = true;
	private int layer;
	private boolean isPositionSprite;
	public Sprite()
	{
		this.setIsPositionSprite(true);
	}
	void setPanel(SpritePanel p)
	{
		panel = p;
	}
	public SpritePanel getPanel()
	{
		return panel;
	}
	protected void setIsPositionSprite(boolean b)
	{
		isPositionSprite = b;
	}
	boolean getIsPositionSprite()
	{
		return isPositionSprite;
	}
	boolean isPositionSprite()
	{
		return isPositionSprite;
	}
	public void setLayer(int layer)
	{
		this.layer = layer;
	}
	public int getLayer()
	{
		return layer;
	}
	public SpritePanel getParent()
	{
		return panel;
	}
	public int getPanelWidth()
	{
		return panel.getWidth();
	}
	public int getPanelHeight()
	{
		return panel.getHeight();
	}
	/*
	public void addKeyListener(KeyListener listener)
	{
		panel.addKeyListener(listener);
	}
	*/
	public void setVisible (boolean b)
	{
		visible = b;
	}
	public boolean getVisible() {

		return visible;
	}
	public boolean isVisible() {

		return visible;
	}
	
	protected abstract void display(Graphics g, SpritePanel s);
	
	
	


}
