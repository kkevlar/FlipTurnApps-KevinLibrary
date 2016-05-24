package com.flipturnapps.kevinLibrary.sprite.physics;

import java.awt.Toolkit;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.sprite.PositionSprite;

public abstract class PhysicsSprite extends PositionSprite 
{
	private ArrayList<Force> forces = new ArrayList<Force>();
	private double netAccelMagnitude;
	private double netAccelDir;
	private double netVelMagnitude;
	private double netVelDir;
	private long lastUpdate;
	private double speedMult = 1;
	private double mass = 1;
	private double comX;
	private double comY;
	private boolean comSet = false;
	private double deltaX;
	private double deltaY;
	private boolean frozen;
	public PhysicsSprite ()
	{
		lastUpdate = System.currentTimeMillis();
		//System.out.println((Toolkit.getDefaultToolkit().getScreenResolution())+"");
		speedMult = Toolkit.getDefaultToolkit().getScreenResolution() * 12 * 3;
		this.setOutsideAllowed(true);
	}
	private void sumForces()
	{
		double xComp = 0;
		double yComp = 0;
		for (int i = 0; i < forces.size(); i++) 
		{
			Force force = forces.get(i);
			double magnitude = force.getMagnitude(this);
			double direction = force.getDirection(this);
			xComp += magnitude * Math.cos(direction);
			yComp += magnitude * Math.sin(direction);
		}
		setNetAccelMagnitude(Math.sqrt(xComp*xComp + yComp*yComp)/this.getMass());
		setNetAccelDir(Math.atan2(yComp, xComp));
	}
	public void update()
	{
		if(!this.isFrozen())
		{
			long millisDelta = System.currentTimeMillis() - lastUpdate;

			double timeMult = (millisDelta+0.0)/(1000+0.0);
			sumForces();
			double vXComp = getNetVelMagnitude() * Math.cos(getNetVelDir());
			double vYComp = getNetVelMagnitude() * Math.sin(getNetVelDir());
			double aXComp = getNetAccelMagnitude() * Math.cos(getNetAccelDir());
			double aYComp = getNetAccelMagnitude() * Math.sin(getNetAccelDir());
			vXComp += aXComp * timeMult;
			vYComp += aYComp * timeMult;
			setNetVelMagnitude(Math.sqrt(vXComp*vXComp + vYComp*vYComp));
			setNetVelDir(Math.atan2(vYComp, vXComp));

			double magmult = timeMult * getSpeedMult();
			deltaX += vXComp * magmult;
			deltaY += vYComp * magmult;

			int moveX = (int) Math.round(deltaX);
			int moveY = (int) Math.round(deltaY);
			deltaX -= moveX;
			deltaY -= moveY;
			this.setX(this.getX() + moveX);
			this.setY(this.getY() - moveY);
		}
		lastUpdate = System.currentTimeMillis();
	}
	public ArrayList<Force> getForces()
	{
		return forces;
	}

	public void setForces(ArrayList<Force> forces) 
	{
		this.forces = forces;
	}
	public double getSpeedMult() {
		return speedMult;
	}
	public void setSpeedMult(double speedMult) {
		this.speedMult = speedMult;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getComX() {
		return comX;
	}
	public void setComX(double comX) 
	{
		this.comSet = true;
		this.comX = comX;
	}
	public double getComY() {
		return comY;
	}
	public void setComY(double comY)
	{
		this.comSet = true;
		this.comY = comY;
	}
	public void setWidth(int w)
	{
		super.setWidth(w);
		if(!comSet && w != 0)
			comX = (w+0.0)/(2+0.0);
	}
	public void setHeight(int h)
	{
		super.setHeight(h);
		if(!comSet && h != 0)
			comY = (h+0.0)/(2+0.0);
	}
	public double getNetAccelMagnitude() {
		return netAccelMagnitude;
	}
	public void setNetAccelMagnitude(double netAccelMagnitude) {
		this.netAccelMagnitude = netAccelMagnitude;
	}
	public double getNetAccelDir() {
		return netAccelDir;
	}
	public void setNetAccelDir(double netAccelDir) {
		this.netAccelDir = netAccelDir;
	}
	public double getNetVelMagnitude() {
		return netVelMagnitude;
	}
	public void setNetVelMagnitude(double netVelMagnitude) {
		this.netVelMagnitude = netVelMagnitude;
	}
	public double getNetVelDir() {
		return netVelDir;
	}
	public void setNetVelDir(double netVelDir) {
		this.netVelDir = netVelDir;
	}
	public boolean isFrozen() {
		return frozen;
	}
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
}
