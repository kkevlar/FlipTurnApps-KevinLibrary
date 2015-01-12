package com.flipturnapps.kevinLibrary.helper;

public class StringHelper 
{
	public static String constructString (char[] ch)
	{
		String x = "";
		for (char c : ch)
		{
			x = x + Character.toString(c);
		}
		return x;
	}
	public static String remove (String mainstring, String substring)
	{
		char lookingfor = substring.toCharArray()[0];
		char[] mainstringarray = mainstring.toCharArray();
		int whichone = -1;
		for (int i = 0; i < mainstringarray.length; i++)
		{
			if (lookingfor == mainstringarray[i])
			{
				whichone = i;
			}
		}
		if (whichone == -1)
			return mainstring;
		char[] copy = new char[mainstringarray.length -1];
		for (int i = 0; i < copy.length;i++)
		{
			if (i < whichone)
				copy[i] = mainstringarray[i];
			else if (i > whichone)
				copy[i - 1] = mainstringarray[i];

		}
		return constructString(copy);
	}
	public static boolean contains(String main, String sub)
	{
		char[] mainchar = main.toCharArray();
		boolean does = false;
		for (char c : mainchar)
		{
			if (c == sub.charAt(0))
				does = true;
		}
		return does;
	}
}
