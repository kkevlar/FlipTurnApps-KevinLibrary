package com.flipturnapps.kevinLibrary.sprite.physics.test;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.GravitationalForce;

public class TestFrame2 extends JFrame
{

	
	private SpritePanel panel;
	private ArrayList<Sprite> testSprites;
	
	public TestFrame2() throws HeadlessException 
	{
		panel = new SpritePanel();
		testSprites = new ArrayList<Sprite>();
		for (int i = 0; i < 2; i++)
		{
			Sprite sprite = new Sprite();
			testSprites.add(sprite);
			panel.add(sprite);
		}
		for (int x = 0; x < testSprites.size(); x++) 
		{
			for (int y = 0; y < testSprites.size(); y++) 
			{
				if(x > y)
				{
					GravitationalForce force = new GravitationalForce(testSprites.get(x), testSprites.get(y));
					force.setGravitationalConstant(50);
					testSprites.get(x).getForces().add(force);
					testSprites.get(y).getForces().add(force);
					force.setSprite(testSprites.get(y));
					panel.add(force);
					System.out.println("hi");
				}
			}
		}
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		
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
