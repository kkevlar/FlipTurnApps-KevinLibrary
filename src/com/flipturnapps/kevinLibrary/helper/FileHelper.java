package com.flipturnapps.kevinLibrary.helper;

import java.io.File;
import java.util.ArrayList;

public class FileHelper 
{
	public static String[] findFiles(String extension)
	{
		File[] files = new File("").getAbsoluteFile().listFiles();
		ArrayList<String> strings = new ArrayList<String>();
		
		for (int i = 0; i<files.length;i++)
		{
			if (files[i].getName().endsWith(extension))
			{
				strings.add(files[i].getName());
			}
		}
		String[] strings2 = new String[strings.size()];
		for (int i = 0; i < strings2.length; i++)
		{
			strings2[i] = strings.get(i);
		}
		return strings2;

	}



}
