package com.flipturnapps.kevinLibrary.newgui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.flipturnapps.kevinLibrary.helper.ThreadHelper;

public class VideoPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int BUFFER = 30;
	private int buffer = BUFFER;
	private ArrayList<Image> images = new ArrayList<Image>();
	private Image[] arrImages = null;
	private int fps;
	private int currentFrame = 0;
	private VideoPanelImageStream stream = null;
	public boolean readFinished;
	public VideoPanel (Image[] img)
	{
		this.setImages(img);
	}
	public VideoPanel (VideoPanelImageStream stream)
	{
		this.stream  = stream;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		System.out.println("xsaaa " + currentFrame);
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if(!images.isEmpty())
			g.drawImage(images.remove(0),0,0,this.getWidth(), this.getHeight(), null);
	}
	public void animate()
	{
		currentFrame = 0;
		
		if(this.getFps() != 0)
		{
			
			new Thread(new Bufferer()).start();
			while(images.size() <this.getBuffer())
			{
				ThreadHelper.sleep(50);
			}
			while(!images.isEmpty())
			{
				currentFrame++;
				if(images.size() < this.getBuffer() / 10)
				{
					while(!readFinished && images.size() < this.getBuffer())
					{
						ThreadHelper.sleep(50);
					}
				}
				this.repaint();
				ThreadHelper.sleep(1000 / (this.getFps()));
			}

		}
	}

	public Image[] getImages() {
		return arrImages;
	}
	public void setImages(Image[] images)
	{
		this.arrImages = images;
	}
	public int getFps() {
		return fps;
	}
	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}
	public int getBuffer() {
		return buffer;
	}
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	
	private class Bufferer implements Runnable
	{
		private static final int STRIKE_COUNT_MAX = 10;

		@Override
		public void run() 
		{
			readFinished = false;
			boolean useStream = false;
			int strikeCount = 0;
			int readCount = -1;
			if(stream != null)
				useStream = true;
			else if(getImages() == null)
				return;
			while(strikeCount < STRIKE_COUNT_MAX)
			{
				readCount++;
				
				Image img = null;
				
				if(useStream)
					img = stream.getImage(readCount);
				else if(readCount > getImages().length)
					strikeCount++;
				else					
					img = getImages()[readCount];
				
				if(img == null)
				{
					strikeCount++;
					ThreadHelper.sleep(50);
				}
				else
				{
					images.add(img);
				}
				ThreadHelper.sleep(5);
			}
			readFinished = true;
		}		
	}
}
