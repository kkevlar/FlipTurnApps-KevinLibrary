package com.flipturnapps.kevinLibrary.helper;

public class ArrayHelper
{
	private static final char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
	private static int[] toIntArray (int x)
	{
		
		char[] chars = Integer.toString(x).toCharArray();
		int[] returner = new int[chars.length];
		for (int i = 0; i < chars.length; i++)
		{
			for (int y = 0; x < numbers.length; x++)
			{
				if (chars[i] == numbers[i])
				{
					returner[y] = i; 
				}
			}
		}
		return returner;
	}
	public static int[] makeintarray (int size)
	{
		int[] things = new int[size];
		return things;
	}

	public static int indexof (int content, int[] nums)
	{
		int x = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (content == nums[i])
			{
				x = i;
			}
		}
		return x;
	}public static int indexof (String content, String[] nums)
	{
		int x = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (content.equals(nums[i]))
			{
				x = i;
			}
		}
		return x;
	}
	public static int indexof (Object content, Object[] nums)
	{
		int x = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (content.equals(nums[i]))
			{
				x = i;
			}
		}
		return x;
	}
	public static int indexof (char content, char[] nums)
	{
		int x = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (content == nums[i])
			{
				x = i;
			}
		}
		return x;
	}
	public static int indexof (boolean content, boolean[] nums)
	{
		int x = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (content == nums[i])
			{
				x = i;
			}
		}
		return x;
	}

	public static boolean contains (int content, int[] nums)
	{
		boolean yes = false;
		for (int i : nums)
		{
			if (content == i)
				yes = true;
		}
		return yes;
	}public static boolean contains (String content, String[] nums)
	{
		boolean yes = false;
		for (String i : nums)
		{
			if (content.equals(i))
				yes = true;
		}
		return yes;
	}
	public static boolean contains (char content, char[] nums)
	{
		boolean yes = false;
		for (char i : nums)
		{
			if (content == i)
				yes = true;
		}
		return yes;
	}
	public static int[] allOne(int[] arr, int stuff)
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = stuff;
		}
		return arr;
	}
	public static Object[] allOne(Object[] arr, Object stuff)
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = stuff;
		}
		return arr;
	}
	
}
