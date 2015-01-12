package com.flipturnapps.kevinLibrary.helper;

import java.util.ArrayList;

public class ReOrderer 
{
	private ArrayList<ReOrderable> items = new ArrayList<ReOrderable>();
	public ArrayList<ReOrderable> getItems()
	{
		return items;
	}
	public void add(ReOrderable item)
	{
		items.add(item);
	}
	
	public void addArrayInt(ReOrderable[] items)
	{
		for(int i = 0; i< items.length;i++)
		{
			this.items.add( items[i]);
		}
	}
	
	public void addArrayListDouble(ArrayList<ReOrderable> items)
	{
		for(int i = 0; i< items.size();i++)
		{
			this.items.add(items.get(i));
		}
	}
	public void reOrderDescending()
	{
		ArrayList<ReOrderable> ordered = new ArrayList<ReOrderable>();
		int size = items.size();
		while(ordered.size() < size)
		{
			double best = items.get(0).getNum();
			int index = 0;
			for(int i = 0; i < items.size();i++)
			{
				
				if(items.get(i).getNum() > best)
				{
					best = items.get(i).getNum();
					index = i;
				}
				ordered.add(items.get(index));
				items.remove(index);
			}
		}
		items = ordered;
			
	}
	public void reOrderAscending()
	{
		ArrayList<ReOrderable> ordered = new ArrayList<ReOrderable>();
		int size = items.size();
		while(ordered.size() < size)
		{
			double best = items.get(0).getNum();
			int index = 0;
			for(int i = 0; i < items.size();i++)
			{
				
				if(items.get(i).getNum() < best)
				{
					best = items.get(i).getNum();
					index = i;
				}
			
			}
			ordered.add(items.get(index));
			items.remove(index);
		}
		items = ordered;
			
	}
}
