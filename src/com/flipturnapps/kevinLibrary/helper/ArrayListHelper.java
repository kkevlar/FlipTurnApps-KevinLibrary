package com.flipturnapps.kevinLibrary.helper;

import java.util.ArrayList;

public class ArrayListHelper 
{
	public static boolean someOverlap(ArrayList a, ArrayList b)
	{
		for(int x = 0;  x < a.size(); x++)
		{
			for(int y = 0; y < b.size(); y++)
			{
				if(a.get(x).equals(b.get(y)))
				{
					return true;
				}
			}
		}
		return false;
	}
	public static int[] toIntArray(ArrayList ar)
	{
		 Integer[] intearr = (Integer[]) ar.toArray();
		 int[] returner = new int[intearr.length];
		 for (int i = 0; i < returner.length; i++)
		 {
			 returner[i] = intearr[i];
		 }
		 return returner;
	}
	public static char[] toCharArray(ArrayList ar)
	{
		 Character[] intearr = (Character[]) ar.toArray();
		 char[] returner = new char[intearr.length];
		 for (int i = 0; i < returner.length; i++)
		 {
			 returner[i] = intearr[i];
		 }
		 return returner;
	}
	public static boolean[] toBooleanArray(ArrayList ar)
	{
		 Boolean[] intearr = (Boolean[]) ar.toArray();
		 boolean[] returner = new boolean[intearr.length];
		 for (int i = 0; i < returner.length; i++)
		 {
			 returner[i] = intearr[i];
		 }
		 return returner;
	}
	
	public static String[] toStringArray(ArrayList ar)
	{
		 String[] intearr = (String[]) ar.toArray();
		 String[] returner = new String[intearr.length];
		 for (int i = 0; i < returner.length; i++)
		 {
			 returner[i] = intearr[i];
		 }
		 return returner;
	}
	public static Object[] toObjectArray(ArrayList ar)
	{
		 return ar.toArray();
	}
}
