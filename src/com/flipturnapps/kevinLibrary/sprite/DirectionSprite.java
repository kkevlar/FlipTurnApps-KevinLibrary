package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.awt.Point;

import com.flipturnapps.kevinLibrary.helper.Trig;

public abstract class DirectionSprite extends PositionSprite {


	private static final long serialVersionUID = -1299591564835272046L;
	private boolean autoMove;
	private double direction;
	private double perfectX;
	private double perfectY;
	private double speed;
	private long lastTimeMoved;
	
	public DirectionSprite() {
		this.setSpeed(0);
		this.setAutoMove(true);
		this.setLastTimeMoved();
	}
	@Override
	public void setX(int x)
	{
		this.perfectX = x;
		super.setX(x);
	}
	@Override
	public void setY(int y)
	{
		this.perfectY = y;
		super.setY(y);
	}
	private void setLastTimeMoved()
	{
		lastTimeMoved = this.getCurrentTimeMillis();
	}
	private void shouldAutoMove(boolean b)
	{
		this.autoMove = b;
	}
	private void setAutoMove(boolean b)
	{
		this.autoMove = b;
	}
	private void toggleAutoMove()
	{
		this.autoMove = !this.autoMove;
	}
	private boolean isAutoMove()
	{
		return this.autoMove;
	}
	private boolean isAutoMoveing()
	{
		return this.autoMove;
	}
	private boolean getAutoMove()
	{
		return this.autoMove;
	}
	private boolean autoMove()
	{
		return this.autoMove;
	}

	public void pointRandom()
	{
		this.setDirection(Math.random() * 360);
	}
	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height) {
		if(this.getAutoMove())
			this.move();
		this.drawDirectionShape(g, s, x, y, width, height, this.getDirection());

	}
	protected abstract void drawDirectionShape(Graphics g, SpritePanel s, int x, int y, int width, int height, double dir);
	public void move() 
	{
		double speed = 0;
		speed = ((((this.getCurrentTimeMillis() - this.lastTimeMoved) - 0.0)/100.0) * this.getSpeed());
		double xMotion = 0;
		double yMotion = 0;
		if(this.getDirection() < 90)
		{
			xMotion = (this.getDirection());
			yMotion = ((90-this.getDirection()));
			
		}
		else if(this.getDirection() < 180)
		{
			xMotion = (180-this.getDirection());
			yMotion = (this.getDirection() - 90);
			xMotion *= -1;
		}
		else if(this.getDirection() < 270)
		{
			xMotion = (this.getDirection()-180);
			yMotion = ((90-this.getDirection())+180);
			xMotion *= -1;
			yMotion *= -1;
		}
		else if(this.getDirection() < 360)
		{
			xMotion = (360-this.getDirection());
			yMotion = (this.getDirection()-270);
			yMotion *= -1;
		}
		xMotion /= 90;
		yMotion /= 90;
		xMotion *= speed;
		yMotion *= speed;
		perfectX += xMotion;
		perfectY += yMotion;
		int roundx = (int) Math.round(perfectX);
		int roundy = (int) Math.round(perfectY);
		this.setX(roundx);
		this.setY(roundy);
		if(roundx != this.getX())
		{
			this.perfectX = this.getX();
		}
		if(roundy != this.getY())
		{
			this.perfectY = this.getY();
		}
		this.setLastTimeMoved();
	}
	protected long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
	
	public void pointTowards(int x, int y)
	{
		pointTowards(new Point(x,y));
	}
	public void pointTowardsMouse()
	{
		int x;
		int y;
		try
		{
			x = (int) this.getParent().getMouseX();
			y = (int) this.getParent().getMouseY();
		}
		catch(Exception ex)
		{
			return;	
		}
		this.pointTowards(x,y);
		
	}	
	
	public void pointTowardsSprite(PositionSprite sprite)
	{
		this.pointTowards(sprite.getPosition());
	}
	public void pointTowardsSpriteCenters(PositionSprite sprite)
	{
		this.pointTowards(sprite.getCenterPosition());
	}
	public void pointTowards(Point point) 
	{
		this.setDirection(Trig.getAbsoluteAngle(point.getX(), point.getY()));
	}
		
	public double getDirection() {

		return direction;
	}

	
	public void setDirection(double direction) {
		if(direction >=0)
			this.direction = (direction%360);
		else
		{
			while(direction <0)
			{
				direction += 360;
			}
			this.direction = direction;
		}
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
