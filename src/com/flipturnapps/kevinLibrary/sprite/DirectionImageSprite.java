package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.flipturnapps.kevinLibrary.helper.ImageHelper;

public class DirectionImageSprite extends DirectionSprite {

	private BufferedImage image;
	public DirectionImageSprite(BufferedImage conImage) 
	{
		this.setImage(conImage);
	}
	public DirectionImageSprite(String fileName) throws IOException
	{
		this(new File(fileName));
	}
	public DirectionImageSprite(File file) throws IOException
	{
		this(ImageIO.read(file));
	}
	@Override
	protected void drawDirectionShape(Graphics g, SpritePanel s, int x, int y, int width, int height, double dir) 
	{
		Graphics2D g2d = (Graphics2D) g;
		ImageHelper.drawRotatedImage(x, y, width, height, dir, this.getImage(), g2d);

	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	

}
