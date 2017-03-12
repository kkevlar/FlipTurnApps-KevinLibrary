package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.flipturnapps.kevinLibrary.gui.KJPanel;
import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class SpritePanel extends KJPanel 
{
	private static final long serialVersionUID = -2069993305609211627L;
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	//offsets for scrolling. if the children posistionsprites choose to obey
	private int xOffset;
	private int yOffset;
	public SpritePanel() 
	{
		super();
		this.setBackground(KevinColor.kwhite);
		
	}	
	public ArrayList<Sprite> getSprites()
	{
		orderSprites();
		return sprites;
		
	}
	public void add(Sprite i)
	{
		sprites.add(i);
		if (this != null)
			i.setPanel(this);
		orderSprites();
	}
	public void remove(Sprite i)
	{
		sprites.remove(i);
		orderSprites();
	}
	public void add(Sprite i, int layer)
	{
		if(i != null)
		{
			i.setLayer(layer);
			sprites.add(i);
		}
		if (this != null)
			i.setPanel(this);
		orderSprites();
	}
	public void refresh()
	{
		this.repaint();
	}
	
	private void orderSprites()
	{
		Collections.sort(sprites, new Comparator<Sprite>() 
		{
			public int compare(Sprite s1, Sprite s2)
			{
				return (1) * ( s1.getLayer() - s2.getLayer() );
			}
		});
	}


	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (int i = 0; i < sprites.size(); i++)
		{
			if (sprites.get(i).isVisible())
				sprites.get(i).display(g, this);
		}

	}
	
	
	public void deleteSprites()
	{
		sprites = new ArrayList<Sprite>();

	}
	public void removeSprites()
	{
		sprites = new ArrayList<Sprite>();

	}
	public int getxOffset() {
		return xOffset;
	}
	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}
	public int getyOffset() {
		return yOffset;
	}
	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}
	

}
