package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.GravitationalForce;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class TestFrame2 extends JFrame
{

	
	private SpritePanel panel;
	private ArrayList<GravitySprite> testSprites;
	
	public TestFrame2() throws HeadlessException 
	{
		testSprites = new ArrayList<GravitySprite>();
		panel = new PhysicsSpritePanel(testSprites);
		GravitationalForce.setGravitationalConstant(50);
		for (int i = 0; i < 0; i++)
		{
			GravitySprite sprite = new GravitySprite();
			testSprites.add(sprite);
			panel.add(sprite);
		}
		for (int x = 0; x < testSprites.size(); x++) 
		{
			for (int y = 0; y < testSprites.size(); y++) 
			{
				if(x > y)
				{
					GravitationalForce force = makeGForce(this.testSprites.get(x), this.testSprites.get(y));
					force.setSprite(testSprites.get(x));
					panel.add(force);
					//System.out.println("hi");
				}
			}
		}
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		
	}

	public static GravitationalForce makeGForce(PhysicsSprite spriteX, PhysicsSprite spriteY) 
	{
		GravitationalForce force = new GravitationalForce(spriteX, spriteY);
		spriteX.getForces().add(force);
		spriteY.getForces().add(force);
		return force;
	}
	
	public static void main (String[] args)
	{
		TestFrame2 frame = new TestFrame2();
		frame.setVisible(true);
		while(true)
		{
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < frame.testSprites.size(); i++) {
				frame.testSprites.get(i).update();
			}
			frame.panel.refresh();
		}
	}

	

}
