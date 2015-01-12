package com.flipturnapps.kevinLibrary.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class KImage extends JPanel 
{
	Image image;
	public KImage (String filelocation)
	{
		super();
		File file = new File(filelocation);
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	public KImage(Image image)
	{
		this.image = image;
		repaint();
	}
	public void switchImage(String location)
	{
		File file = new File(location);
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	@Override
	public void paintComponent (Graphics g)
	{
		
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
	}
}
