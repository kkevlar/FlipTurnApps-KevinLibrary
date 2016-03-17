package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class GravitySprite extends PhysicsSprite implements Force
{
	private static int idCount = 0;
	private int id;
	private Color color;
	private long lastResize;
	private long lastSound;
	private static double constant;
	public GravitySprite()
	{
		this.id = idCount++;
		this.setMass(Math.random() * 20 + 1);
		this.setX(50 *(id+1));
		this.setY(50 * (id+1));
		this.getForces().add(this);
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
		return s.getMass() * getConstant();
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
	private void cutSpeed()
	{
		this.setNetVelMagnitude(this.getNetVelMagnitude() * .9);
		long timeDelta = System.currentTimeMillis() - lastSound;
		if(timeDelta  > 50)
		{
			try {
				lastSound = System.currentTimeMillis();
				File yourFile = new File("bounce.wav");
				AudioInputStream stream;
				AudioFormat format;
				DataLine.Info info;
				Clip clip;

				stream = AudioSystem.getAudioInputStream(yourFile);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				clip = AudioSystem.getClip();
				clip.open(stream);
				FloatControl gainControl = 
						(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				double num = Math.pow(this.getNetVelMagnitude(),1.5);
				double div = -1/num;
				gainControl.setValue((float) Math.max(div, -25)); // Reduce volume by 10 decibels.

				clip.start();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			lastSound = System.currentTimeMillis();
		}

	}
	public static double getConstant() {
		return constant;
	}
	public static void setConstant(double constant) {
		GravitySprite.constant = constant;
	}
	
	
}
