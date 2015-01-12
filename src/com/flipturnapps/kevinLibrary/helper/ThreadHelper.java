package com.flipturnapps.kevinLibrary.helper;

import java.util.Set;

public class ThreadHelper 
{
	public static void sleep (long mil)
	{
		/*
	
		double cur = System.currentTimeMillis();
		while (System.currentTimeMillis() - cur < mil)
		{
			
		}
		*/
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void terminateApplication()
	{
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threads= threadSet.toArray(new Thread[threadSet.size()]);
		for (int i = 0; i < threads.length;i++)
		{
			if (!(threads[i].equals(Thread.currentThread())))
			{
				threads[i].interrupt();
			}
		}
	}
	public static Thread[] getAllThreads()
	{
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threads= threadSet.toArray(new Thread[threadSet.size()]);
		return threads;
	}
	

}
