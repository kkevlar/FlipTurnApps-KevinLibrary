package com.flipturnapps.kevinLibrary.helper;

import java.util.ArrayList;
import java.util.Random;

public class NumberScrambler
{

	public  static int[] scrambledArray (int range1, int range2)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		int[] nums;
		int range = range2 - (range1 - 1);
		nums = new int[range];
		boolean isgood = false;
		for (int i = 0; i < range; i++)
		{
			isgood = false;
			while (isgood == false)
			{
				int number = rand.nextInt(range);
				if (list.contains(number))
				{
					continue;
				}
				else
				{
					isgood = true;
					list.add(number);
				}
			}
		}
		for (int i = 0; i < range; i++)
		{
			int thing = list.get(i);
			nums[i] = thing;
		}
		for (int i = 0; i < range; i++)
		{
			nums[i] = nums[i] + range1;
		}
		
		return nums;
	}
	public  static int[] scrambledArray (int range)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		int[] nums;
		
		nums = new int[range];
		boolean isgood = false;
		for (int i = 0; i < range; i++)
		{
			isgood = false;
			while (isgood == false)
			{
				int number = rand.nextInt(range);
				if (list.contains(number))
				{
					continue;
				}
				else
				{
					isgood = true;
					list.add(number);
				}
			}
		}
		for (int i = 0; i < range; i++)
		{
			int thing = list.get(i);
			nums[i] = thing;
		}
		
		
		return nums;
	}
	
	
	public  static Object[] scramblearray (Object[] array)
	{
		int[] numbers = scrambledArray(array.length);
		Object[] newarray = new Object[array.length];
		for (int i = 0; i < numbers.length; i++)
		{
			int x = numbers[i];
			newarray[i] = array[x];
		}
		return newarray;
	}
	
}
