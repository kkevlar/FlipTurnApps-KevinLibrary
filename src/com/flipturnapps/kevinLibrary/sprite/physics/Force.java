package com.flipturnapps.kevinLibrary.sprite.physics;

public interface Force 
{
	public double getMagnitude(PhysicsSprite s);
	public double getDirection(PhysicsSprite s);
}
