package com.flipturnapps.kevinLibrary.helper;

import java.util.ArrayList;

public class TimeHelper 
{
	public static final long SECOND = 1000;
	public static final long MINUTE = 60*SECOND;
	public static final long HOUR = 60*MINUTE;
	public static final long DAY = 24*HOUR;
	
	
	public static String formatTimeMillis(long time, int types)
	{
		double[] cutoffs = new double[]{2,1.5,1.5,1};
		String[] names = new String[] {"day","hour","minute","second","millisecond"};
		long[] measuresMillis = new long[]{DAY,HOUR,MINUTE,SECOND};
		
		ArrayList<TimeMeasure> timeMeasures = new ArrayList<TimeMeasure>();
		
		for(int i = 0; i < measuresMillis.length; i++)
		{
			if(time > measuresMillis[i]*cutoffs[i])
			{
				if(timeMeasures.size() + 1 != types && types != 1)
				{
					int amount = (int) (time / measuresMillis[i]);
					time %= measuresMillis[i];
					timeMeasures.add(new TimeMeasure(names[i],amount,i<2));
				}
				else
				{
					double amount = (double) ((time+0.0) / (measuresMillis[i]+0.0));
					time = 0;
					timeMeasures.add(new TimeMeasure(names[i],amount,i<2));
				}
			}
			if(timeMeasures.size() >= types)
				break;
		}
		if(timeMeasures.size() < types && time > 0)
		{
			timeMeasures.add(new TimeMeasure(names[names.length-1],time,false));
		}
		
		String ret = "";
		for(int i = 0; i < timeMeasures.size(); i++)
		{
			String append = "";
			if(i < timeMeasures.size() -1)
			{
				append = ", ";
			}
			if(timeMeasures.size() >= 2 && i  == timeMeasures.size() -2)
			{
				append = " and ";
			}
			ret += timeMeasures.get(i) + append;			
		}
		return ret;
	}
	public static String formatTimeMillis(long time)
	{
		return formatTimeMillis(time,1);
	}
	private static class TimeMeasure
	{
		private String name;
		private double amount;
		private boolean big;
		
		public TimeMeasure(String name, double amount, boolean big)
		{
			this.setName(name);
			this.setAmount(amount);
			this.setBig(big);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount2) {
			this.amount = amount2;
		}
		public String toString()
		{
			String plural;
			if(this.getAmount() > 1)
				plural = "s";
			else
				plural = "";
			String amountString;
			if(Math.abs(amount - ((int) Math.round(amount))) < .2 || !isBig())
			{
				int amountInt = (int) Math.round(amount);
				amountString = amountInt +"";
			}
			else
			{
				amountString = String.format("%.1f", amount);
			}
			
			return amountString + " " + this.getName() + plural;
		}
		public boolean isBig() {
			return big;
		}
		public void setBig(boolean big) {
			this.big = big;
		}
	}
}
