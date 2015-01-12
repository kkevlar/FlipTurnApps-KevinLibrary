package com.flipturnapps.kevinLibrary.newgui;
import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.gui.KJPanel;
import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class ProgressBar extends KJPanel
{
	
	private static final long serialVersionUID = -3975181113042710520L;
	double size;
	
	Color color;
	double value;
	Color barcolor;
	double wantvalue;
	double increment;
	
	public ProgressBar ()
	{
		super();
		value = 0;
		color = KevinColor.kred;
		barcolor = KevinColor.kblack;
		repaint();
	}
	public ProgressBar (double vvalue)
	{
		super();
		value = vvalue;
		color = KevinColor.kred;
		barcolor = KevinColor.kblack;
		repaint();
	}
	@Override
	public void paintComponent (Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(color);
		g.fillRect(0, (int)(getHeight() * size), (int) (getWidth() * value), (int) ((getHeight() * (1 -size) - (getHeight() * size))));
		g.setColor(barcolor);
		g.drawRect(0, (int)(getHeight() *size), getWidth(), (int) ((getHeight() * (1 -size) - (getHeight() * size))));
	}
	public void setBarSize(double d)
	{
		size = d;
		this.refresh();
	}
	public double getBarSize()
	{
		return size;
		
	}
	
	public void refresh()
	{
		repaint();
	}
	
	public void setValueColor (Color c)
	{
		color = c;
		this.refresh();
	}
	public void setBarColor (Color c)
	{
		barcolor = c;
		this.refresh();
	}
	public void setValue (double d)
	{
		value = d;
		this.refresh();
	}
	
	public Color getValueColor ()
	{
		return color;
	}
	public Color getBarColor ()
	{
		return barcolor;
	}
	public double getValue ()
	{
		return value;
	}
	
	
		
	
}
