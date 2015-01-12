package com.flipturnapps.kevinLibrary.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class OvalSprite extends PositionShapeSprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7950591124573671773L;


	public OvalSprite() {
		super();
	}

	
	public OvalSprite(int i, int j, int k, int l) {
		super(i,j,k,l);
	}


	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width,int height) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(getPaint());
		if (getFill() == true)
			g2.fillOval(x, y, width, height);
		else
			g2.drawOval(x, y, width, height);

	}

}
