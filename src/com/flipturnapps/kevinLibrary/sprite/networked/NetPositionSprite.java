package com.flipturnapps.kevinLibrary.sprite.networked;

import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.PositionSprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public abstract class NetPositionSprite extends PositionSprite 
{
	private boolean netEnabled = false;
	private boolean netEnabledSet = false;
	private NetworkedSpritePanel netPanel;
	public NetPositionSprite()
	{
		
	}
	public boolean isNetEnabled() 
	{
		return netEnabled;
	}
	public void setNetEnabled(boolean netEnabled) 
	{
		if(netPanel != null)
		{
			this.netEnabled = netEnabled;
			this.netEnabledSet = true;
		}
	}
	public void setPanel(SpritePanel panel)
	{
		super.setPanel(panel);
		if(panel instanceof NetworkedSpritePanel)
		{
			this.netPanel = (NetworkedSpritePanel) panel;
			if(!netEnabledSet)
				netEnabled = true;
		}
		else
		{
			netEnabled = false;
		}
	}
	public void setXFromCommand(int x)
	{
		super.setX(x);
	}
	public void setYFromCommand(int y)
	{
		super.setY(y);
	}
	public void setWidthFromCommand(int w)
	{
		super.setWidth(w);
	}
	public void setHeightFromCommand(int h)
	{
		super.setHeight(h);
	}
	
	public void setX(int x)
	{
		super.setX(x);
		if(this.isNetEnabled())
			netPanel.sendUnpackedInstruction(NetSpriteCommandSet.NAME + NetworkedSpritePanel.instructionParseSeparator + "x" + this.getX());
			
	}
	public void setY(int y)
	{
		super.setY(y);
		if(this.isNetEnabled())
			netPanel.sendUnpackedInstruction(NetSpriteCommandSet.NAME + NetworkedSpritePanel.instructionParseSeparator + "y" + this.getY());
			
	}
	public void setWidth(int w)
	{
		super.setWidth(w);
		if(this.isNetEnabled())
			netPanel.sendUnpackedInstruction(NetSpriteCommandSet.NAME + NetworkedSpritePanel.instructionParseSeparator + "w" + this.getWidth());
			
	}
	public void setHeight(int h)
	{
		super.setHeight(h);
		if(this.isNetEnabled())
			netPanel.sendUnpackedInstruction(NetSpriteCommandSet.NAME + NetworkedSpritePanel.instructionParseSeparator + "h" + this.getHeight());
			
	}

}

