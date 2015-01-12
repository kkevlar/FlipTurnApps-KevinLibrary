package com.flipturnapps.kevinLibrary.helper;

import java.util.Scanner;

public class InputGetter {

	private Scanner scan;
	public InputGetter()
	{
		scan = new Scanner(System.in);
	}
	public double nextDouble(String prompt)
	{
		double in;
		while(true)
		{
			System.out.println(prompt);
			try
			{
				in = Double.parseDouble(scan.nextLine());
				break;
			}
			catch(Exception ex)
			{
				System.out.println("Invalid input.");
			}
		}
		return in;
	}
	public boolean nextBoolean(String prompt)
	{
		boolean in;
		while(true)
		{
			System.out.println(prompt);
			try
			{
				in = Boolean.parseBoolean(scan.nextLine());
				break;
			}
			catch(Exception ex)
			{
				System.out.println("Invalid input.");
			}
		}
		return in;
	}
	public int nextInt(String prompt)
	{
		int ret;
		while(true)
		{
			double dou = this.nextDouble(prompt);
			ret = (int) dou;
			if(dou != (ret + 0.0))
			{
				System.out.println("Invalid input.");
			}
			else
			{
				break;
			}
		}
		return ret;
	}
	public String nextLine(String prompt)
	{
		System.out.println(prompt);
		return scan.nextLine();
	}
	public String nextLine()
	{
		return scan.nextLine();
	}

}
