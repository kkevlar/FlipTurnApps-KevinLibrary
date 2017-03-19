package com.flipturnapps.kevinLibrary.sprite.physics;

public interface Force 
{
	public static final double DIR_LEFT = Math.PI;
	public static final double DIR_RIGHT = 0;
	public static final double DIR_UP = Math.PI / (2.00+0.0);
	public static final double DIR_DOWN = Math.PI / (-2.00+0.0);
	
	public double getMagnitude(PhysicsSprite s);
	public double getDirection(PhysicsSprite s);
}
