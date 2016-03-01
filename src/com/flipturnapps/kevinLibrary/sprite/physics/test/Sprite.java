package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class Sprite extends PhysicsSprite implements Force
{
	private static int idCount = 0;
	private int id;
	private Color color;
	public Sprite()
	{
		this.id = idCount++;
		this.setMass((id*100)+.1);
		this.setX(50 *(id+1));
		this.setY(50 * (id+1));
		//this.getForces().add(this);
		this.getForces().add(new MouseForce());
		this.getForces().add(new MouseForce2());
		//this.setNetVelDir(Math.PI*.5);
		this.setOutsideAllowed(true);
		//this.setNetVelMagnitude(2);
		this.color = new Color(Color.HSBtoRGB(id*.1f, 1, 1));
		this.setWidth(((int) (Math.pow(this.getMass(),.1)+2) * 30));
		this.setHeight(((int) (Math.pow(this.getMass(),.1)+2)* 30 ));
		this.setNetVelDir(Math.random() * Math.PI * 2);
		this.setNetVelMagnitude(Math.random()*10);
	}
	@Override
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
			this.setNetVelDir(this.getNetVelDir() * 3);
			this.cutSpeed();
		}
		if (x + width > this.getPanelWidth() && Math.cos(this.getNetVelDir()) > 0)
		{
			this.setNetVelDir(this.getNetVelDir() * 3);
			this.cutSpeed();
		}
		this.setNetVelMagnitude(this.getNetVelMagnitude() * .999);
		g.setColor(color);
		g.fillOval(x, y, width, height);
		
	}
	private void cutSpeed() {
		this.setNetVelMagnitude(this.getNetVelMagnitude() * .75);
		
	}
	private class MouseForce implements Force 
	{
		private double gravitationalConstant = 1;

		public double getMagnitude(PhysicsSprite s)
		{
			double numerator = gravitationalConstant * s.getMass() * 0;
			double x = deltaX(s); 
			double y = deltaY(s); 
			double denominator = x*x+y*y;
			return numerator/denominator;
		}
		private double deltaY(PhysicsSprite s) 
		{
			return s.getY() + s.getComY() - s.getPanel().getMouseY();
		}
		private double deltaX(PhysicsSprite s)
		{
			return s.getX() + s.getComX() - s.getPanel().getMouseX();
		}

		@Override
		public double getDirection(PhysicsSprite s)
		{
			double mod = Math.PI;
			return Math.atan2(-deltaY(s), deltaX(s)) + mod;
		}
		public double getGravitationalConstant() 
		{
			return gravitationalConstant;
		}
		public void setGravitationalConstant(double gravitationalConstant) 
		{
			this.gravitationalConstant = gravitationalConstant;
		}
		

	}
	private class MouseForce2 implements Force 
	{
		private double gravitationalConstant = 0;

		public double getMagnitude(PhysicsSprite s)
		{
			double numerator = gravitationalConstant * s.getMass() * 0;
			double x = deltaX(s); 
			double y = deltaY(s); 
			double denominator = Math.pow(x*x+y*y,2);
			return numerator/denominator;
		}
		private double deltaY(PhysicsSprite s) 
		{
			return s.getY() + s.getComY() - s.getPanel().getMouseY();
		}
		private double deltaX(PhysicsSprite s)
		{
			return s.getX() + s.getComX() - s.getPanel().getMouseX();
		}

		@Override
		public double getDirection(PhysicsSprite s)
		{
			double mod = 0;
			return Math.atan2(-deltaY(s), deltaX(s)) + mod;
		}
		public double getGravitationalConstant() 
		{
			return gravitationalConstant;
		}
		public void setGravitationalConstant(double gravitationalConstant) 
		{
			this.gravitationalConstant = gravitationalConstant;
		}
		

	}
	
	
}
