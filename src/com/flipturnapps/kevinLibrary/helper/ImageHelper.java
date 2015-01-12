package com.flipturnapps.kevinLibrary.helper;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageHelper {

	public static Image getImage(String f) 
	{
		return new ImageIcon(f).getImage();
	}
	public static Image getImageURL(String f) throws MalformedURLException
	{
		return Toolkit.getDefaultToolkit().getImage(new URL(f));
	}
	public static Icon getIcon (String f)
	{
		return new ImageIcon(f);
	}
	public static byte[] toByteArray(String location, String extension)
	{
		File fnew=new File(location);
		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(fnew);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			ImageIO.write(originalImage, extension, baos );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageInByte=baos.toByteArray();
		return imageInByte;

	}
	public static byte[] toByteArray(Image image,String extension)
	{

		BufferedImage originalImage = toBufferedImage(image);

		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			ImageIO.write(originalImage, extension, baos );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageInByte=baos.toByteArray();
		return imageInByte;

	}
	public static Image bytesToImage(byte[] bytes)
	{
		try {
			return ImageIO.read(new ByteArrayInputStream(bytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public static void drawRotatedImage(int x, int y, int width, int height, double direction, BufferedImage image, Graphics2D g2d)
	{
		int drawLocationX = x;
		int drawLocationY = y;
		double rotationRequired = Math.toRadians(direction);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(image, null), drawLocationX,  drawLocationY,width,height, null);
	}
	public static BufferedImage toBufferedImage(Image img)
	{

		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}
		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();
		// Return the buffered image
		return bimage;

	}
}
