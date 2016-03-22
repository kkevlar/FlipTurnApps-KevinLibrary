package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.helper.ArrayHelper;
import com.flipturnapps.kevinLibrary.helper.KevinChars;
import com.flipturnapps.kevinLibrary.sprite.Sprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.GravitationalForce;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class PhysicsSpritePanel extends SpritePanel 
{

	private boolean mouseWasDown;
	private Point startCoords;
	private ArrayList<GravitySprite> sprites;
	private long lastSpace;
	private double mouseStore;
	private long bounceStart;
	private double gravStore;

	public PhysicsSpritePanel(ArrayList<GravitySprite> testSprites)
	{
		this.add(new ArrowSprite());
		this.sprites = testSprites;
		this.setFocusable(true);
		this.requestFocus();
		
	}
	public void refresh()
	{
		super.refresh();
		if(this.mouseDown() && !mouseWasDown)
		{
			startCoords = this.getMousePosition();
			if(startCoords != null)
				mouseWasDown = true;
		}
		else if(!this.mouseDown() && mouseWasDown)
		{
			mouseWasDown = false;
			int startX = (int) startCoords.getX();
			int startY = (int) startCoords.getY();
			int mX = (int) getMouseX();
			int mY = (int) getMouseY();
			double distance = Math.sqrt(Math.pow(startX-mX,2) + Math.pow(startY-mY, 2));
			double angle = Math.atan2(mY-startY, startX-mX);
			GravitySprite sprite = new GravitySprite();
			for (int i = 0; i < sprites.size(); i++) 
			{
				TestFrame2.makeGForce(sprite, sprites.get(i));
			}
			sprite.setNetVelDir(angle);
			sprite.setX(startX);
			sprite.setY(startY);
			sprite.setNetVelMagnitude(distance/100);
			sprites.add(sprite);
			this.add(sprite);
		}
		if(this.downKeyDown() && !this.controlKeyDown())
		{
			GravitationalForce.setGravitationalConstant(GravitationalForce.getGravitationalConstant() - 1);
		}
		if(this.upKeyDown() && !this.controlKeyDown())
		{
			GravitationalForce.setGravitationalConstant(GravitationalForce.getGravitationalConstant() + 1);
		}
		if(this.downKeyDown() && this.controlKeyDown())
		{
			MouseForce.setGravitationalConstant(MouseForce.getGravitationalConstant() - .25);
		}
		if(this.upKeyDown() && this.controlKeyDown())
		{
			MouseForce.setGravitationalConstant(MouseForce.getGravitationalConstant() + .25);
		}
		
		if(this.leftKeyDown() && !this.controlKeyDown())
		{
			GravitationalForce.setGravitationalConstant(GravitationalForce.getGravitationalConstant() - 10);
		}
		if(this.rightKeyDown() && !this.controlKeyDown())
		{
			GravitationalForce.setGravitationalConstant(GravitationalForce.getGravitationalConstant() + 10);
		}
		if(this.leftKeyDown() && this.controlKeyDown())
		{
			MouseForce.setGravitationalConstant(MouseForce.getGravitationalConstant() - 10);
		}
		if(this.rightKeyDown() && this.controlKeyDown())
		{
			MouseForce.setGravitationalConstant(MouseForce.getGravitationalConstant() + 10);
		}
		if(this.spaceKeyDown() && !this.controlKeyDown() && System.currentTimeMillis() - lastSpace > 500)
		{
			lastSpace = System.currentTimeMillis();
			for(int i = 0; i < sprites.size(); i++)
			{
				GravitySprite sprite = sprites.get(i);
				sprite.setFrozen(!sprite.isFrozen());
			}
		}
		if(this.spaceKeyDown() && this.controlKeyDown() && System.currentTimeMillis() - lastSpace > 500)
		{
			lastSpace = System.currentTimeMillis();
			for(int i = 0; i < sprites.size(); i++)
			{
				GravitySprite sprite = sprites.get(i);
				sprite.setNetVelDir(sprite.getNetAccelDir() + Math.PI * .5);
			}
		}
		if(shiftKeyDown() && GravitySprite.getConstant() == 0)
		{
			bounceStart = System.currentTimeMillis();
			mouseStore = MouseForce.getGravitationalConstant();
				MouseForce.setGravitationalConstant(0);
			gravStore = GravitationalForce.getGravitationalConstant();
					GravitationalForce.setGravitationalConstant(0);
			GravitySprite.setConstant(3);
			for(int i = 0; i < sprites.size(); i++)
			{
				GravitySprite sprite = sprites.get(i);
				sprite.setFrozen(false);
			}
		}
		if(System.currentTimeMillis() - bounceStart > 10000 && bounceStart != 0)
		{
			MouseForce.setGravitationalConstant(mouseStore);
			GravitationalForce.setGravitationalConstant(gravStore);
			GravitySprite.setConstant(0);
			bounceStart = 0;
		}
		if(this.letterKeyDown()[ArrayHelper.indexof('s',KevinChars.lowalphabet)]  && System.currentTimeMillis() - lastSpace > 500)
		{
			//lastSpace = System.currentTimeMillis();
			for(int i = 0; i < sprites.size(); i++)
			{
				GravitySprite sprite = sprites.get(i);
				sprite.setNetVelMagnitude(sprite.getNetVelMagnitude() * .5);
			}
		}
		if(this.letterKeyDown()[3]  && System.currentTimeMillis() - lastSpace > 500)
		{
			//lastSpace = System.currentTimeMillis();
			for(int i = 0; i < sprites.size(); i++)
			{
				GravitySprite sprite = sprites.get(i);
				sprite.setNetVelMagnitude(sprite.getNetVelMagnitude() * 2);
			}
		}
	}
	private class ArrowSprite extends Sprite
	{

		@Override
		protected void display(Graphics gf, SpritePanel s) 
		{
			Graphics2D g = (Graphics2D) gf;
			g.setColor(Color.red);
			g.setFont(new Font("Monospaced",Font.PLAIN, 16));
			g.drawString("Grav Constant = " + ((int)GravitationalForce.getGravitationalConstant()), 20, 20);
			g.drawString("Mouse Force C = " + ((int)MouseForce.getGravitationalConstant()), 20, 50);
			if (mouseWasDown)
			{
				
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.CYAN);
				int startX = (int) startCoords.getX();
				int startY = (int) startCoords.getY();
				int mX = (int) getMouseX();
				int mY = (int) getMouseY();
				g.drawLine(startX, startY,mX, mY);
				double angle = Math.atan2(mY-startY, startX-mX);
				double x1 = startX - (Math.sin(angle)*10);
				double x2 = startX + (Math.sin(angle)*10);
				double x3 = startX + Math.cos(angle)*10;
				double y1 = startY - (Math.cos(angle)*10);
				double y2 = startY + (Math.cos(angle)*10);
				double y3 = startY - Math.sin(angle)*10;
				g.fillPolygon(
						new int[] {(int) x1,(int) x2, (int) x3},
						new int[] {(int) y1,(int) y2,(int) y3},
						3);
			}
		}
		
	}

}
