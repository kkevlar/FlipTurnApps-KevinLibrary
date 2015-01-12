package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

import com.flipturnapps.kevinLibrary.helper.KevinColor;


public abstract class ShapeSprite extends Sprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162174384588641072L;
	private Paint color = KevinColor.kblack;
	private boolean fill = false;
	public ShapeSprite() {
		super();
	}
	public void setPaint(Paint c)
	{
		color = c;
	}
	public Paint getPaint()
	{
		return color;
	}
	public void setFill(boolean b)
	{
		fill = b;
	}
	public boolean getFill()
	{
		return fill;
	}
	public static Paint getSolidPaint (Color c)
	{
		GradientPaint paint = new GradientPaint(0,0,c,0,0,c);
		return paint;
	}

	
}
