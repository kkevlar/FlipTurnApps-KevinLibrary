package com.flipturnapps.kevinLibrary.gui;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

import com.flipturnapps.kevinLibrary.helper.ImageHelper;



public class ImageButton extends JButton{

	String a;
	String b;
	String c;
	private void setUp(String a,String b, String c)
	{
		a = this.a;
		b = this.b;
		c = this.c;

		setContentAreaFilled(false);
		setFocusable(false);
		setRolloverEnabled(true);
	}
	public void setSizeToImage()
	{
		Dimension dim = new Dimension();
		dim.height = ImageHelper.getIcon(a).getIconHeight();
		dim.width = ImageHelper.getIcon(a).getIconWidth();
		this.setPreferredSize(dim);
	}
	public ImageButton(String normal) 
	{
		super();
		setUp(normal,normal,normal);
		
	}
	public ImageButton(String normal, String mouseOver) 
	{
		super();
		setUp(normal,mouseOver,mouseOver);
		
	}
	
	public ImageButton(String normal, String mouseOver,String click) 
	{
		super();
		this.setUp(normal, mouseOver, click);
		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (this.getModel().isPressed())
			g.drawImage(ImageHelper.getImage(c),0,0,this.getWidth(),this.getHeight(),null);
		else if(this.getModel().isRollover())
			g.drawImage(ImageHelper.getImage(b),0,0,this.getWidth(),this.getHeight(),null);
		else
			g.drawImage(ImageHelper.getImage(a),0,0,this.getWidth(),this.getHeight(),null);
	}

	
}
