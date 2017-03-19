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
	
	//maybe will delete these
	private boolean xNormaled = false;
	private boolean yNormaled = false;
	private double xNormalForce = 0;
	private double yNormalForce = 0;
	
	
 	public PhysicsSprite()
	{
		lastUpdate = System.currentTimeMillis();
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
		
		//If X has normal force applied, then sum of forces will be zero
		if(this.isxNormaled())
		{
			this.setxNormalForce(-xComp);
			xComp = 0;
		}
		else
			this.setxNormalForce(0);
		
		if(this.isyNormaled())
		{
			this.setyNormalForce(-yComp);
			yComp = 0;
		}
		else
			this.setyNormalForce(0);
		
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
			
			
			changeXBy(moveX);
			changeYBy(-moveY);
		}
		lastUpdate = System.currentTimeMillis();
	}
	protected void changeYBy(int moveY) {
		this.setY(this.getY() + moveY);
	}
	protected void changeXBy(int moveX) {
		this.setX(this.getX() + moveX);
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
	
	public void add(Force f)
	{
		this.getForces().add(f);
	}
	
//probs gonna delete
	public boolean isxNormaled() {
		return xNormaled;
	}
	public void setxNormaled(boolean xNormaled) {
		this.xNormaled = xNormaled;
	}
	public boolean isyNormaled() {
		return yNormaled;
	}
	public void setyNormaled(boolean yNormaled) {
		this.yNormaled = yNormaled;
	}
	public double getxNormalForce() {
		return xNormalForce;
	}
	private void setxNormalForce(double xNormalForce) {
		this.xNormalForce = xNormalForce;
	}
	public double getyNormalForce() {
		return yNormalForce;
	}
	private void setyNormalForce(double yNormalForce) {
		this.yNormalForce = yNormalForce;
	}
}
