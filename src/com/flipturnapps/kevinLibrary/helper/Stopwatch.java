package com.flipturnapps.kevinLibrary.helper;


public class Stopwatch 
{
	private double elapsed = 0;
	private long increment = 100;
	private boolean stopped = false;
	public Stopwatch()
	{
		new Thread(new Up()).run();
	
	}
	public void stop()
	{
		stopped = true;
	}
	public void go()
	{
		stopped = false;
	}
	public double get()
	{
		return elapsed;
	}
	private class Up implements Runnable
	{
		@Override
		public void run() {
			while (true)
			{
				
			
			double start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start < increment)
			{
				
			}
			if (stopped = false)
			{
				elapsed = elapsed + increment;
			}
			}
			
			
		}
		
	}
	
}

	
