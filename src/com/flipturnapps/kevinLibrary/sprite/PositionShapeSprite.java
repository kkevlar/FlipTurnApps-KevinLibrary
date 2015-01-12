package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Paint;

import com.flipturnapps.kevinLibrary.helper.KevinColor;


public abstract class PositionShapeSprite extends PositionSprite
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3716321956154928623L;
	public PositionShapeSprite() {
		super();
	}

	public PositionShapeSprite(int i, int j, int k, int l) {
		super(i,j,k,l);
	}

	private Paint color = KevinColor.kblack;
	private boolean fill = false;
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
	public  GradientPaint getGPaint(GStartPoints p, Color a, Color b)
	{
		
		if (p == GStartPoints.TOPRIGHT)
			return new GradientPaint(getX() + getWidth(),getY(),a,getX(),getY() + getHeight(),b);
		else if (p == GStartPoints.TOPLEFT)
			return new GradientPaint(getX(),getY(),a,getX() + getWidth(),getY() + getHeight(),b);
		else if (p == GStartPoints.TOPCENTER)
			return new GradientPaint((int) ((getX() + getWidth() + getX()) * 0.5),getY(),a,(int) ((getX() + getWidth() + getX()) * 0.5),getY() + getHeight(),b);
		else if (p == GStartPoints.BOTTOMCENTER)
			return new GradientPaint((int) ((getX() + getWidth() + getX()) * 0.5),getY() + getHeight(),a,(int) ((getX() + getWidth() + getX()) * 0.5),getY(),b);
		else if (p == GStartPoints.BOTTOMLEFT)
			return new GradientPaint(getX(),getY() + getWidth(),a,getX() + getWidth(),getY(), b);
		else if (p == GStartPoints.BOTTOMRIGHT)
			return new GradientPaint(getX() + getWidth(),getY() + getWidth(),a,getX(),getY(), b);
		else if (p == GStartPoints.LEFTCENTER)
			return new GradientPaint(getX(),(int) ((getY() + getWidth() + getY()) * 0.5),a,getX() + getWidth(),(int) ((getY() + getWidth() + getY()) * 0.5), b);
		else if (p == GStartPoints.RIGHTCENTER)
			return new GradientPaint(getX() + getWidth(),(int) ((getY() + getWidth() + getY()) * 0.5),a,getX(),(int) ((getY() + getWidth() + getY()) * 0.5), b);
		else 
			return null;
	}
	
	@Override
	protected abstract void drawShape(Graphics g, SpritePanel s, int x, int y,int width, int height);
		

	



}
