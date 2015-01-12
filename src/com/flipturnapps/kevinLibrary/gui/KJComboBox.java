package com.flipturnapps.kevinLibrary.gui;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JList;


public class KJComboBox extends JComboBox
{
	Component[] comps;
	public KJComboBox(Component[] components, Integer[] ints)
	{
		super(ints);
		comps = components;
		this.setRenderer(new Cells());
	}
	private class Cells extends JComboBoxRenderer
	{

		@Override
		public Component getComponent(JList list, int index, boolean selected,
				boolean cellHasFocus) {
			return comps[index];
		}
		
	}
	public static KJComboBox create(Component[] c)
	{
		Integer[] ints = new Integer[c.length];
		for (int i = 0; i < ints.length; i++)
		{
			ints[i] = i;
		}
		return new KJComboBox(c,ints);
	}
}
