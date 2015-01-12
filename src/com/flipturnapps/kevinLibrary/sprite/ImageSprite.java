package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.awt.Image;


public class ImageSprite extends PositionSprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6230951401179786591L;
	private Image image = null;
	public ImageSprite(Image i) {
		super();
		image = i;
	}
	public void setImage(Image i)
	{
		image = i;
	}
	public Image getImage()
	{
		return image;
	}

	
	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height) 
	{
		g.drawImage(image,
				x,
				y,
				width,
				height,
				null);
	}

}
