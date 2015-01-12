package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public abstract class PositionSprite extends Sprite {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5318288985690748989L;
	private boolean outsideAllowed;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private int prelimTest = -1;
	public static final int RECTANGLE = 1;
	public static final int RECT = 1;
	public static final int CIRCLE = 0;
	private boolean solid = false;
	
	public PositionSprite() {
		super();
		this.setAll(0,0,50,50);
		setUp();
	}
	public void setSolidPreliminaryTestDistance(int i)
	{
		prelimTest = i;
	}
	public int getSolidPreliminaryTestDistance()
	{
		return prelimTest;
	}
	public int guessSolidPreliminaryTestDistance()
	{
		return (int) (2*(Math.sqrt(getHeight()) * getHeight() + getWidth() * getWidth()));
	}
	private void setUp() 
	{
		this.setIsPositionSprite(true);
		
	}
	public PositionSprite(int x , int y, int width, int height)
	{
		super();
		this.setAll(x, y, width, height);
		setUp();
	}
	public void setSolid(boolean solid)
	{
		this.solid = solid;
	}
	public boolean isSolid()
	{
		return solid;
	}
	public boolean getSolid()
	{
		return solid;
	}
	public boolean isCollidingWith(PositionSprite sprite, int boxType)
	{
		return collidingWith(sprite, boxType);
	}
	public boolean collidingWith(PositionSprite sprite, int boxType)
	{
		if(boxType == RECT)
			return collidingWithRects(sprite);
		else if(boxType == CIRCLE)
			return collidingWithCircles(sprite);
		else
			return false;
			
	}
	public boolean collidingWithCircles(PositionSprite sprite)
	{
		if(this.distanceToCenters(sprite) <= ((sprite.getWidth() + sprite.getHeight() + this.getWidth() + this.getWidth())/ 4))
			return true;
		else
			return false;
	}
	public boolean collidingWithRects(PositionSprite sprite)
	{
		boolean thisWithinX  =this.getX() > sprite.getX() && this.getX() < sprite.getWidth() + sprite.getX();
		boolean spriteWithinX = sprite.getX() > this.getX() && sprite.getX() < this.getX() + this.getWidth();
		boolean thisWithinY = this.getY() > sprite.getY() && this.getY() < sprite.getHeight() + sprite.getY();
		boolean spriteWithinY = sprite.getY() > this.getY() && sprite.getY() < this.getY() + this.getHeight();
		boolean onSameX = this.getX() == sprite.getX() && this.getWidth() + this.getX()== sprite.getWidth() + sprite.getX();
		boolean onSameY = this.getY() == sprite.getY() && this.getHeight() +this.getY()== sprite.getHeight() +sprite.getY();
		boolean xGood = thisWithinX || spriteWithinX || onSameX;
		boolean yGood=  thisWithinY || spriteWithinY || onSameY;
		boolean good = xGood && yGood;
		return good;
	}
	public boolean getLeftOn()
	{
		return getMouseIn() && getPanel().leftMouseDown();
	}
	public boolean getRightOn()
	{
		return getMouseIn() && getPanel().rightMouseDown();
	}
	public boolean getCenterOn()
	{
		return getMouseIn() && getPanel().centerMouseDown();
	}
	public boolean getMouseIn()
	{
		boolean xGood = getPanel().getMouseX() > getX();
		boolean yGood = getPanel().getMouseY() > getY();
		boolean wGood = getPanel().getMouseX() < getX() + getWidth();
		boolean hGood = getPanel().getMouseY() < getY() + getHeight();
		boolean mouseIn = xGood && yGood && wGood && hGood;
		return mouseIn;
	}

	public void positionForScrolling(double xpos,double ypos, double scrollx, double scrolly, boolean centered)
	{
		if(centered)
		{
			this.setCenterX((int) ((xpos) - scrollx));
			this.setCenterY((int) ((ypos) - scrolly));
		}
		else
		{
			this.setX((int) ((xpos) - scrollx));
			this.setY((int) ((ypos) - scrolly));
		}
	}
	
	
	public void setOutsideAllowed(boolean b)
	{
		outsideAllowed = b;
	}
	public boolean getOutsideAllowed()
	{
		return outsideAllowed;
	}
	@Override
	protected void display(Graphics g, SpritePanel s)
	{
		if (outsideAllowed == false)
		{
			if (getX() + getWidth() > s.getWidth())
				setX(s.getWidth() - getWidth(),true);
			if (y + height > s.getHeight())
				setY(s.getHeight() - height,true);
			if (y < 0)
				setY(0,true);
			if (x < 0)
				setX(0,true);
			
		}
		drawShape(g,s,getX(),getY(),getWidth(),getHeight());
		
	}
	protected abstract void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height);
	public int getCenterX()
	{
		return (getX() + getX() + getWidth()) /2;
	}
	public int getCenterY()
	{
		return (getY() + getY() + getHeight()) /2;
	}
	public void setCenterX(int i)
	{
		setX(i - (getWidth() / 2));
	}
	public void setCenterY(int i)
	{
		
		setY(i - (getHeight() / 2));
	}
	public void setAll(int x, int y, int width, int height)
	{
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}
	public void setX(int i)
	{
		setX(i,false);
	}
	void setX(int num, boolean bypass)
	{
		if(bypass == true || getSolid() == false)
			x = num;
		else
		{
			
			ArrayList<PositionSprite> sprites = new ArrayList<PositionSprite>();
			
			for(int i = 0; i < getPanel().getSprites().size(); i++)
			{
				try
				{
					
					PositionSprite sprite = (PositionSprite) getPanel().getSprites().get(i);
					if(this.distanceToCenters(sprite) < this.getSolidPreliminaryTestDistance())
					sprites.add(sprite);
				}
				catch(Exception ex)
				{
					
				}
			}
			boolean[] boos = new boolean[sprites.size()];
			for(int i = 0; i < sprites.size(); i++)
			{
				if(sprites.get(i).getSolid() == true && this.collidingWithRects(sprites.get(i)))
					boos[i] = true;
			}
			int prevx = x;
			x = num;
			for(int i = 0; i < sprites.size(); i++)
			{
				
				if(sprites.get(i).getSolid() == true && this.collidingWithRects(sprites.get(i)) && boos[i] == false)
					x = prevx;
			}
		}
	}
	void setY(int num, boolean bypass)
	{
		if(bypass == true || getSolid() == false)
			y = num;
		else
		{
			
			ArrayList<PositionSprite> sprites = new ArrayList<PositionSprite>();
			
			for(int i = 0; i < getPanel().getSprites().size(); i++)
			{
				try
				{
					PositionSprite sprite = (PositionSprite) getPanel().getSprites().get(i);
					if(this.distanceToCenters(sprite) < this.getSolidPreliminaryTestDistance())
					sprites.add(sprite);
				}
				catch(Exception ex)
				{
					
				}
			}
			boolean[] boos = new boolean[sprites.size()];
			for(int i = 0; i < sprites.size(); i++)
			{
				if(sprites.get(i).getSolid() == true && this.collidingWithRects(sprites.get(i)))
					boos[i] = true;
			}
			int prevx = getY();
			y = num;
			for(int i = 0; i < sprites.size(); i++)
			{
				
				if(sprites.get(i).getSolid() == true && this.collidingWithRects(sprites.get(i)) && boos[i] /*false*/ == false)
					y = prevx;
			}
		}
	}
	public void setY(int i)
	{
		setY(i,false);
	}
	public void setWidth(int i)
	{
		width = i;
	}
	public void setHeight(int i)
	{
		height = i;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public double distanceTo(PositionSprite sprite)
	{
		double xdif = Math.abs((getX()+0.0) - (sprite.getX()+0.0));
		double ydif = Math.abs((getY()+0.0) - (sprite.getY()+0.0));
		return (Math.sqrt((xdif * xdif) + (ydif * ydif)));
	}
	public double distanceTo(Point point)
	{
		double xdif = Math.abs((getX()+0.0) - (point.getX()+0.0));
		double ydif = Math.abs((getY()+0.0) - (point.getY()+0.0));
		return (Math.sqrt((xdif * xdif) + (ydif * ydif)));
	}
	public double distanceTo(int x, int y)
	{
		return distanceTo(new Point(x,y));
	}
	public double distanceTo(double x, double y)
	{
		return distanceTo((int)x,(int)y);
	}
	public double distanceToCenters(PositionSprite sprite)
	{
		double xdif = Math.abs((this.getCenterX()+0.0) - (sprite.getCenterX()+0.0));
		double ydif = Math.abs((this.getCenterY()+0.0) - (sprite.getCenterY()+0.0));
		return (Math.sqrt((xdif * xdif) + (ydif * ydif)));
		
	}
	public Point getPosition()
	{
		return new Point(this.getX(),this.getY());
	}
	public Point getCenterPosition()
	{
		return new Point(this.getCenterX(),this.getCenterY());
	}
}
	