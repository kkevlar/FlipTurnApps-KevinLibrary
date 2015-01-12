package com.flipturnapps.kevinLibrary.helper;

public class BooleanHelper 
{
	public static boolean flip (boolean boo)
	{
		if (boo == true)
			boo = false;
		else if (boo == false)
			boo = true;
		return boo;
	}
}
