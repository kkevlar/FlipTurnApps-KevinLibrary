package com.flipturnapps.kevinLibrary.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileHelper 
{
	public static String getFirstTextLine(File f) throws IOException
	{
		return getTextLine(f,0);
	}
	public static String getTextLine(File f, int line) throws IOException
	{
		return getTextByLine(f)[line];		
	}
	public static String[] getTextByLine(File f) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(f));
		ArrayList<String> lines = new ArrayList<String>();
		while(true)
		{
			String s = reader.readLine();
			if(s == null)
				break;
			lines.add(s);
		}
		reader.close();
		String[] ret = new String[lines.size()];
		for (int i = 0; i < ret.length; i++) 
		{
			ret[i] = lines.get(i);
		}
		return ret;
	}
	public static void writeTextToFile(File f, String... text) throws FileNotFoundException
	{
		FlushWriter writer = new FlushWriter(f);
		for(int i = 0; i < text.length; i++)
		{
			writer.println(text[i]);
		}
		writer.close();
	}
	
	public static void writeTextToFile(File f, String text) throws FileNotFoundException
	{
		String[] s = new String[1];
		s[0] = text;
		writeTextToFile(f,s);
	}
}
