package com.flipturnapps.kevinLibrary.sprite.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.flipturnapps.kevinLibrary.sprite.Sprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public abstract class ForceSprite extends Sprite implements Force
{

	private Color color;
	private PhysicsSprite sprite;
	public ForceSprite() 
	{
		this.setColor(Color.black);
	}

	@Override
	protected void display(Graphics g, SpritePanel s) 
	{
		if(sprite != null)
		{
			g.setColor(color);
		int startX = (int) (sprite.getX() + sprite.getComX());
		int startY = (int) (sprite.getY() + sprite.getComY());
		int deltaX = (int) (Math.cos(this.getDirection(sprite)) * this.getMagnitude(sprite) * 1000);
		int deltaY = (int) (Math.sin(this.getDirection(sprite)) * this.getMagnitude(sprite) * 1000);
		g.drawLine(startX, startY, deltaX + startX, startY - deltaY);
		}
	}

	public Color getColor() 
	{
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
	}

	public PhysicsSprite getSprite() 
	{
		return sprite;
	}

	public void setSprite(PhysicsSprite sprite) 
	{
		this.sprite = sprite;
	}

}
