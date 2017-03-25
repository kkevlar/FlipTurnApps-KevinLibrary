package com.flipturnapps.kevinLibrary.sprite.physics;

public class SimpleFrictionForce implements Force 
{

	@Override
	public double getMagnitude(PhysicsSprite s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDirection(PhysicsSprite s) {
		// TODO Auto-generated method stub
		return 0;
	}
  ///NEEED TO STRIP THIS
	
	//UNFINISHED UNFINISHED UNFINISHED
	
	/*
	private double u;
	private boolean enabled;
	private boolean normalForceDirIsY = true;
	public SimpleFrictionForce(double u) 
	{
		this.setCoefficient(u);
	}
	

	@Override
	public double getMagnitude(PhysicsSprite s) 
	{
		if(this.isEnabled() && (Math.cos(s.getNetVelDir() + Math.PI)  != 0) && Math.abs(Math.cos(s.getNetVelDir()) * s.getNetVelMagnitude()) > 0.00001)
			if(this.isNormalForceDirIsY())
				return s.getyNormalForce() * this.getCoefficient();
			else
				return s.getxNormalForce() * this.getCoefficient();
		else
			return 0;
	}

	@Override
	public double getDirection(PhysicsSprite s) 
	{
		if(this.isEnabled())
			if(this.isNormalForceDirIsY())
				if(Math.cos(s.getNetVelDir() + Math.PI) <= 0)
					return Math.PI;
				else
					return 0;
			else
				if(Math.sin(s.getNetVelDir() + Math.PI) < 0)
					return - ((Math.PI+0.0) / (2+0.0));
				else
					return ((Math.PI+0.0) / (2+0.0));
		else
			return 0;
	}
	public double getCoefficient() {
		return u;
	}
	public void setCoefficient(double u) {
		this.u = u;
	}
	
	//Children should override this method for custom friction logic
	public boolean isEnabled() 
	{
		return enabled;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	public boolean isNormalForceDirIsY() {
		return normalForceDirIsY;
	}
	public void setNormalForceDirIsY(boolean normalForceDirIsY) {
		this.normalForceDirIsY = normalForceDirIsY;
	}
	*/

}
