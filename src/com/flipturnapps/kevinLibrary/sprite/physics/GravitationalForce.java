package com.flipturnapps.kevinLibrary.sprite.physics;

public class GravitationalForce extends ForceVectorSprite
{
	private PhysicsSprite major;
	private PhysicsSprite minor;
	private static double gravitationalConstant = 1;
	private int minDenom;

	public GravitationalForce(PhysicsSprite major, PhysicsSprite minor) 
	{
		this.major = major;
		this.minor = minor;
		setMinDenom(5000);
	}
	@Override
	public double getMagnitude(PhysicsSprite s)
	{
		double numerator = gravitationalConstant * major.getMass() * minor.getMass();
		double x = deltaX(); 
		double y = deltaY(); 
		
		double denominator = Math.max(x*x+y*y,getMinDenom());
		
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
	public static double getGravitationalConstant() 
	{
		return gravitationalConstant;
	}
	public static void setGravitationalConstant(double g) 
	{
		gravitationalConstant = g;
	}
	public int getMinDenom() {
		return minDenom;
	}
	public void setMinDenom(int minDenom) {
		this.minDenom = minDenom;
	}
	

}
