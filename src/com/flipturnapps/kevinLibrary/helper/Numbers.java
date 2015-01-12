package com.flipturnapps.kevinLibrary.helper;

import java.awt.Point;
import java.util.Random;

public class Numbers
{
	public static double random ()
	{
		return Math.random();
	}
	public static int random (int range)
	{
		Random rand = new Random();
		return rand.nextInt(range);
	}
	public static int random (int range, int range2)
	{
		Random rand = new Random();
		return rand.nextInt(range2 - range + 1) + range;
	}
	public static boolean isWhole(double d)
	{
		if (d == (int) d)
			return true;
		else
			return false;
		
	}
	public static boolean isInt(String s)
	{
		try
		{
			int i = Integer.parseInt(s);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public static double getAngle(Point a,Point b)
	{
		return Numbers.getAngle(a.getX(), b.getX(), a.getY(), b.getY());
	}
	public static double getAngle(double x1, double x2, double y1, double y2)
	{
		return ((360-(Math.toDegrees(Math.atan2(x2-x1,y2-y1))))%360)-180;
	}
}
