package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.gui.KJPanel;
import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class SpritePanel extends KJPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2069993305609211627L;
	private ArrayList<Sprite> arr = new ArrayList<Sprite>();





	public SpritePanel() 
	{
		super();
		this.setBackground(KevinColor.kwhite);
		
	}

	
	public ArrayList<Sprite> getSprites()
	{
		return arr;
	}
	public void add(Sprite i)
	{
		arr.add(i);
		if (this != null)
			i.setPanel(this);
	}
	public void remove(Sprite i)
	{
		arr.remove(i);
	}
	public void add(Sprite i, int layer)
	{
		arr.add(layer,i);
		if (this != null)
			i.setPanel(this);
	}


	public void refresh()
	{


		this.repaint();
	}


	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		ArrayList<Sprite> s = new ArrayList<Sprite>();
		for (int i = 0; i < arr.size(); i++)
		{
			s.add(arr.get(i));
		}
		ArrayList<Sprite> paintSprites = new ArrayList<Sprite>();
		while(s.size() > 0)
		{
			int bestIndex = -1;
			int bestLayer = 0;
			boolean gotBestLayer = false;
			for(int i = 0; i < s.size(); i++)
			{
				if(s.get(i).getLayer() < bestLayer || gotBestLayer == false)
				{
					bestLayer = s.get(i).getLayer();
					bestIndex = i;
					gotBestLayer = true;
					
				}
				
			}
			if(bestLayer != -1 && gotBestLayer == true)
			{
				paintSprites.add(s.get(bestIndex));
				s.remove(bestIndex);
			}
		}
		for (int i = 0; i < paintSprites.size(); i++)
		{
			if (paintSprites.get(i).isVisible())
				paintSprites.get(i).display(g, this);

		}

	}
	public void deleteSprites()
	{
		arr = new ArrayList<Sprite>();

	}
	public void removeSprites()
	{
		arr = new ArrayList<Sprite>();

	}
	

}
