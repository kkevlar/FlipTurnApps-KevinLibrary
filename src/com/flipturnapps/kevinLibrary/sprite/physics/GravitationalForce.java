package com.flipturnapps.kevinLibrary.sprite.physics;

public class GravitationalForce extends ForceSprite
{
	private PhysicsSprite major;
	private PhysicsSprite minor;
	private double gravitationalConstant = 1;

	public GravitationalForce(PhysicsSprite major, PhysicsSprite minor) 
	{
		this.major = major;
		this.minor = minor;
	}
	@Override
	public double getMagnitude(PhysicsSprite s)
	{
		double numerator = gravitationalConstant * major.getMass() * minor.getMass();
		double x = deltaX(); 
		double y = deltaY(); 
		double denominator = Math.max(x*x+y*y,5000);
		return numerator/denominator;
	}
	private double deltaY() 
	{
		return major.getY() + major.getComY() - minor.getY() - minor.getComY();
	}
	private double deltaX()
	{
		return major.getX() + major.getComX() - minor.getX() - minor.getComX();
	}

	@Override
	public double getDirection(PhysicsSprite s)
	{
		double mod = 0;
		if (s == major)
		{
			mod -= Math.PI;
			//System.out.println("hi");
		}
		return Math.atan2(-deltaY(), deltaX()) + mod;
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
