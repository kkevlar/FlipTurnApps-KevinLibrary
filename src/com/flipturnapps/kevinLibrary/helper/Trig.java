package com.flipturnapps.kevinLibrary.helper;

public class Trig 
{
	public static double findReferenceAngleDeg(double x, double y)
	{
		double tan = y/x;
		double abstan = Math.abs(tan);
		return Math.toDegrees(Math.atan(abstan));
	}
	public static double getAbsoluteAngle(double x, double y)
	{
		if(x == 0)
			if(y <= 0)
				return 270;
			else
				return 90;
		if(y == 0)
			if(x <= 0)
				return 180;
			else
				return 0;
		if(x > 0)
			if(y > 0)
				return Trig.findReferenceAngleDeg(x, y);
			else
				return 360- Trig.findReferenceAngleDeg(x, y);
		else
			if(y > 0)
				return 180 - Trig.findReferenceAngleDeg(x, y);
			else
				return 180 + Trig.findReferenceAngleDeg(x, y);
	}
}
