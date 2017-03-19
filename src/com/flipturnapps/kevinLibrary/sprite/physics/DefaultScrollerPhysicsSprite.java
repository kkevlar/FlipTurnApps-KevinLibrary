package com.flipturnapps.kevinLibrary.sprite.physics;

public abstract class DefaultScrollerPhysicsSprite extends PhysicsSprite 
{
	private int screenWidth;
	private int screenHeight;
	private double leftScroll = .2;
	private double rightScroll = .6;
	private double topScroll = .2;
	private double botScroll = .9;
	
	public void guessDimensions()
	{
		try
		{
		this.setScreenWidth(this.getPanel().getWidth());
		this.setScreenHeight(this.getPanel().getHeight());
		}
		catch(Exception ex)
		{
			
		}
	}
	public void moveToCenter()
	{
		this.setCenterX(screenWidth/2);
		this.setCenterY(screenHeight/2);
	}
	protected void changeXBy(int dx)
	{
		int tryIt = this.getX() + dx;
		if((tryIt >= (this.getScreenWidth() * leftScroll)) && tryIt <= this.getScreenWidth() * rightScroll)
		{
			this.setX(tryIt);
			return;
		}
		if(tryIt > this.getScreenWidth() * rightScroll)
		{
			int amountOver = (int) (tryIt - (this.getScreenWidth() * rightScroll));
			this.setX((dx - amountOver) + this.getX());
			this.getPanel().setxOffset(this.getPanel().getxOffset() + amountOver);
		}
		if(tryIt < this.getScreenWidth() * leftScroll)
		{
			int amountOver = (int) (tryIt - (this.getScreenWidth() * leftScroll));
			this.setX((dx - amountOver) + this.getX());
			this.getPanel().setxOffset(this.getPanel().getxOffset() + amountOver);
		}
	}
	protected void changeYBy(int dy)
	{
		//unfinished
		this.setY((this.getY() + dy));
	}
	public double getBotScroll() {
		return botScroll;
	}
	public void setBotScroll(double botScroll) {
		this.botScroll = botScroll;
	}
	public double getTopScroll() {
		return topScroll;
	}
	public void setTopScroll(double topScroll) {
		this.topScroll = topScroll;
	}
	public double getRightScroll() {
		return rightScroll;
	}
	public void setRightScroll(double rightScroll) {
		this.rightScroll = rightScroll;
	}
	public double getLeftScroll() {
		return leftScroll;
	}
	public void setLeftScroll(double leftScroll) {
		this.leftScroll = leftScroll;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
}
