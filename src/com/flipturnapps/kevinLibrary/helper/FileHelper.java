package com.flipturnapps.kevinLibrary.helper;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;

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
	public static String fileInDir(File d, String s)
	{
		return fileInDir(d.getAbsolutePath(),s);
	}
	public static String fileInDir(String d, String s)
	{
		if(d.endsWith("/") && s.startsWith("/"))
			return d + s.substring(1);
		else if(d.endsWith("/") || s.startsWith("/"))
			return (d + s);
		else
			return d + "/" + s;
	}
	public static String getAppDataDir(String devName, String appName)
	{
		String os = System.getProperty("os.name","generic").toLowerCase(Locale.ENGLISH);
		String home = System.getProperty("user.home");
		if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) {
			return home + "/Library/Application Support/"+ devName +"/"+appName+"/" ;
		} else if (os.indexOf("win") >= 0) {
			return home + "/AppData/Roaming/"+ devName +"/"+appName+"/" ;
		} else if (os.indexOf("nux") >= 0) {
			return home + "/."+ devName +"/"+appName+"/"  ;
		} else {
			return "/"+ devName +"/"+appName+"/"  ;
		}
	}
	public static File getThisJarDir(Class aClass) throws URISyntaxException
	{
		return new File(aClass.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
	}


}
