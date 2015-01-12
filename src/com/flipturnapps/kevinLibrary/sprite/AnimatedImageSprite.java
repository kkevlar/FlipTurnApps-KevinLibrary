package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Image;

import com.flipturnapps.kevinLibrary.helper.ThreadHelper;


public class AnimatedImageSprite extends ImageSprite {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2250844336600413352L;
	private Image[] images;
	private boolean end = true;
	private int pause;
	private int i;
	public AnimatedImageSprite(Image[] image) {
		super(image[0]);
		images = image;
		new Thread(new Spinner()).start();
		i = 0;
	}
	public void end()
	{
		end = false;
	}
	public void setPause(int i)
	{
		pause = i;
	}
	public int getPause()
	{
		return pause;
	}
	public void setImages(Image[] image)
	{
		images = image;
	}
	public Image[] getImages()
	{
		return images;
	}
	private class Spinner implements Runnable
	{

		@Override
		public void run() {
			while (end == true)			
			{
				ThreadHelper.sleep(pause);
				i++;
				try
				{
					setImage(images[i]);
				}
				catch (RuntimeException ex)
				{
					i = 0;
					setImage(images[0]);
				}
			}
		}
		
	}

}
