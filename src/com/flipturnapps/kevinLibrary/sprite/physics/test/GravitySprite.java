package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class GravitySprite extends PhysicsSprite implements Force
{
	private static int idCount = 0;
	private int id;
	private Color color;
	private long lastResize;
	public GravitySprite()
	{
		this.id = idCount++;
		this.setMass(Math.random() * 20 + 1);
		this.setX(50 *(id+1));
		this.setY(50 * (id+1));
		//this.getForces().add(this);
		this.getForces().add(new MouseForce());
		//this.setNetVelDir(Math.PI*.5);
		this.setOutsideAllowed(true);
		//this.setNetVelMagnitude(2);
		this.color = new Color(Color.HSBtoRGB(id*.1f, 1, 1));
		
		this.setNetVelDir(Math.random() * Math.PI * 2);
		this.setNetVelMagnitude(Math.random()*10);
	}
	@Override
	public void setMass(double m)
	{
		super.setMass(m);
		this.setLayer((int) ((int) 1000-m));
		this.setWidth(((int) (Math.pow(this.getMass(),1)+2) * 5));
		this.setHeight(((int) (Math.pow(this.getMass(),1)+2)* 5 ));
	}
	public double getMagnitude(PhysicsSprite s)
	{
		return s.getMass() * 0;
	}

	@Override
	public double getDirection(PhysicsSprite s)
	{
		return -1 * 0.5 * Math.PI;
	}

	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height)
	{
		if(this.getRightOn() && System.currentTimeMillis() - lastResize > 100)
		{
			this.lastResize = System.currentTimeMillis();
			this.setFrozen(!this.isFrozen());
			this.setNetVelMagnitude(0);
		}
		if(this.getCenterOn() && System.currentTimeMillis() - lastResize > 100)
		{
			this.lastResize = System.currentTimeMillis();
			double change = (this.getCenterY()- this.getPanel().getMouseY())/10;
			this.setMass(Math.abs(this.getMass() + change));
		}
		if (y + height > this.getPanelHeight() && Math.sin(this.getNetVelDir()) < 0)
		{
			this.setNetVelDir(this.getNetVelDir() * -1);
			this.cutSpeed();
		}
		if (y  < 0 && Math.sin(this.getNetVelDir()) > 0)
		{
			this.setNetVelDir(this.getNetVelDir() * -1);
			this.cutSpeed();
		}
		if (x < 0 && Math.cos(this.getNetVelDir()) < 0)
		{
			this.setNetVelDir(Math.atan2(Math.sin(this.getNetVelDir()), -1 * Math.cos(this.getNetVelDir())));
			this.cutSpeed();
		}
		if (x + width > this.getPanelWidth() && Math.cos(this.getNetVelDir()) > 0)
		{
			this.setNetVelDir(Math.atan2(Math.sin(this.getNetVelDir()), -1 * Math.cos(this.getNetVelDir())));
			this.cutSpeed();
		}
		//this.setNetVelMagnitude(this.getNetVelMagnitude() );
		g.setColor(color);
		g.fillOval(x, y, width, height);
		
	}
	private void cutSpeed() {
		this.setNetVelMagnitude(this.getNetVelMagnitude() * .9);
		
	}
	
	
}
