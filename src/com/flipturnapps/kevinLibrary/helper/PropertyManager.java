package com.flipturnapps.kevinLibrary.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public abstract class PropertyManager 
{
	private HashMap<String,String> map;
	
	public PropertyManager()
	{
		map = new HashMap<String,String>();
	}
	
	public PropertyManager(File file) throws IOException
	{
		super();
		read(file);
	}
	
	public abstract File getStorageDirectory();
	public abstract String getFilename();
	
	public File getSaveFile()
	{
		return new File(FileHelper.fileInDir(getStorageDirectory(), getFilename()));
	}
	
	public void read() throws IOException
	{
		read(this.getSaveFile());
	}
	
	public void read(File file) throws IOException
	{
		if(map == null)
			map = new HashMap<String,String>();
		map.clear();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while(true)
		{
			String line = reader.readLine();
			if(line == null)
				break;
			String[] pieces = line.split("=");
			try
			{
			map.put(pieces[0], pieces[1]);
			}
			catch(Exception ex)
			{
				
			}
		}
		reader.close();
	}
	
	public void write() throws IOException
	{
		this.getSaveFile().getParentFile().mkdirs();
		if(!this.getSaveFile().exists())
			this.getSaveFile().createNewFile();
		
		FlushWriter writer = new FlushWriter(this.getSaveFile());
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext())
		{
			String key = iter.next();
			String value = map.get(key);
			String output = key+"="+value;
			writer.println(output);
		}
		writer.close();
	}
	
	public String getProperty(String key)
	{
		return map.get(key);
	}
	
	public void setProperty(String key, String value)
	{
		map.remove(key);
		map.put(key, value);
	}
	
}
