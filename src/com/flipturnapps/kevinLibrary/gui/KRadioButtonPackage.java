package com.flipturnapps.kevinLibrary.gui;



import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class KRadioButtonPackage extends JPanel
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7099391512060393505L;
	private JRadioButton[] boxes;
	private boolean oneAtATime = false;
	private int totalnumber = 0;
	private int lasttouched = -1;
	private boolean lselected = false;
	private ite[] listeners; 
	public KRadioButtonPackage (int number)
	{
		super();
		setUp(number);
	}
	public KRadioButtonPackage(Color[] colors)
	{
		super();
		setUp(colors.length);
		setBackgrounds(colors);
		
	}
	private void setUp(int number){
		totalnumber = number;
		boxes = new JRadioButton[number];
		listeners = new ite[number];
		for (int i = 0; i < number; i++)
		{
			boxes[i] = new JRadioButton();
			listeners[i] = new ite(i);
			add(boxes[i]);
			boxes[i].addItemListener(listeners[i]);
			boxes[i].setSelected(false);
		}
		this.setOneAtATime(true);
	}
	public void setBackgrounds(Color[] colors)
	{
		if (colors.length != getBoxCount())
		{
			return;
		}
		for(int i = 0; i < colors.length; i++)
		{
			getBox(i).setBackground(colors[i]);
		}
	}
	public void makeVisible()
	{
		for (int i = 0; i < boxes.length; i++)
		{
			boxes[i].setVisible(true);
		}
	}
	public void makeInVisible()
	{
		for (int i = 0; i < boxes.length; i++)
		{
			boxes[i].setVisible(false);
		}
	}
	public void makeInVisible(int i)
	{
		
		
			boxes[i].setVisible(false);
		
	}
	public void makeVisible(int i)
	{
		
		
			boxes[i].setVisible(true);
		
	}
	
	public boolean[] getSelected()
	{
		boolean[] stuffs = new boolean[boxes.length];
		for (int i = 0; i < boxes.length; i++)
		{
			stuffs[i] = boxes[i].isSelected();
		}
		return stuffs;
	}
	public void setOneAtATime (boolean b)
	{
		oneAtATime = b;
		if (b == true)
		{
			unSelectAll();
			lasttouched = -1;
		}
	}
	public int getBoxCount()
	{
		return totalnumber;
	}
	public boolean getOneAtATime ()
	{
		return oneAtATime;
	}
	public JRadioButton getBox(int number)
	{
		return boxes[number];
	}
	public boolean allSelected()
	{
		boolean b = false;
		for (int i = 0; i < boxes.length; i++)
		{
			if (boxes[i].isSelected() == false)
			{
				b = false;
			}
		}
		return b;
	}
	public boolean allUnSelected()
	{
		boolean b = false;
		for (int i = 0; i < boxes.length; i++)
		{
			if (boxes[i].isSelected() == true)
			{
				b = false;
			}
		}
		return b;
	}
	public void selectAll()
	{
		if (oneAtATime == false)
		{
			for (int i = 0; i < boxes.length; i++)
			{
				boxes[i].setSelected(true);
			}
		}
	}
	public void unSelectAll()
	{
		for (int i = 0; i < boxes.length; i++)
		{
			boxes[i].setSelected(false);
		}
		lasttouched = -1;
	}

	private class ite implements ItemListener
	{
		public ite (int x)
		{
			mynumber = x;
		}
		int mynumber = -1;
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			clicked(mynumber);

		}

	}
	public void selectAllTF(boolean b)
	{
		if (b == true)
			selectAll();
		else
			unSelectAll();
	}
	public void flip()
	{
		if (oneAtATime == false)
		{
			if (allSelected() == true || allUnSelected() == true)
			{
				if (allSelected() == true)
					unSelectAll();
				else if (allUnSelected() == true)
					selectAll();
			}
		}
	}
	private void clicked(int number) 
	{
		if (oneAtATime == false)
			performedActionCBP(number);
		else
		{

			if (lasttouched == -1)
			{
				lasttouched = number;
				lselected = boxes[number].isSelected();
			}
			else
			{
				if (boxes[lasttouched].equals(boxes[number]))
				{
					
				}
				else
				{
					boxes[lasttouched].setSelected(false);
				}
				
				lasttouched = number;
				lselected = boxes[number].isSelected();
				performedActionCBP(number);
			}
		}
		


	}
	public void performedAction ()
	{
		performedActionCBP(0);
	}
	public void performedActionCBP(int i)
	{
		
	}
	public void setTotalBackground (Color c)
	{
		for (int i = 0; i < boxes.length; i++)
		{
			setBackground(c);
			boxes[i].setBackground(c);
		}
	}
}
