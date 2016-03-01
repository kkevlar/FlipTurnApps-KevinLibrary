package com.flipturnapps.kevinLibrary.sprite.physics.test;

import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class MouseForce implements Force 
{
	private static double gravitationalConstant = 1;

	public double getMagnitude(PhysicsSprite s)
	{
		try
		{
			double numerator = gravitationalConstant * s.getMass() * 500;
			double x = deltaX(s); 
			double y = deltaY(s); 
			double denominator = Math.max(x*x+y*y,1000);
			return numerator/denominator;
		}
		catch(Exception ex)
		{
			return 0;
		}
	}
	private double deltaY(PhysicsSprite s) throws MouseOutOfFrameException 
	{
		return s.getY() + s.getComY() - getMouseY(s);
		
	}
	private double getMouseY(PhysicsSprite s) throws MouseOutOfFrameException 
	{
		double y =  s.getPanel().getMouseY();
		testCoord(y);
		return y;
	}
	private void testCoord(double y) throws MouseOutOfFrameException
	{
		if(y < 0)
			throw new MouseOutOfFrameException();
	}
	private double deltaX(PhysicsSprite s) throws MouseOutOfFrameException
	{
		return s.getX() + s.getComX() - getMouseX(s);
	}
	private double getMouseX(PhysicsSprite s) throws MouseOutOfFrameException {
		double x =  s.getPanel().getMouseX();
		testCoord(x);
		return x;
	}

	@Override
	public double getDirection(PhysicsSprite s)
	{
		double mod = Math.PI;
		try {
			return Math.atan2(-deltaY(s), deltaX(s)) + mod;
		} catch (MouseOutOfFrameException e) 
		{
			return mod;
		}
	}
	public static double getGravitationalConstant() 
	{
		return gravitationalConstant;
	}
	public static void setGravitationalConstant(double g) 
	{
		gravitationalConstant = g;
	}
	

}
