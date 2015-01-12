package com.flipturnapps.kevinLibrary.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;

public class StackedSpacedPanel extends KJPanel{

	private SpacedPanel[] panels;
	public StackedSpacedPanel(int rows, int columns)
	{
		super();
		int[] cols = new int[rows];
		for(int i = 0; i < cols.length; i++)
		{
			cols[i] = columns;
		}
		setUp(rows,cols);
	}
	public SpacedPanel[] getPanels()
	{
		return panels;
	}
	public int getPanelCount()
	{
		return panels.length;
	}
	public StackedSpacedPanel(int rows, int[] columns)
	{
		super();
		setUp(rows,columns);
	}
	private void setSizes()
	{
		for(int i = 0;  i < panels.length; i++)
		{
			panels[i].setPreferredSize(new Dimension(this.getWidth(), this.getHeight() / panels.length));
		}
	}
	private void setUp(int rows, int[] cols) 
	{
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		panels = new SpacedPanel[rows];
		for(int i = 0; i < panels.length; i++)
		{
			
			panels[i] = new SpacedPanel(cols[i]);
			this.add(panels[i]);
		}
		setSizes();
		
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setSizes();
	}
	public void add(Component c, int r, int col)
	{
		panels[r].spacedAdd(c, col);
	}
	public void remove(Component c, int r, int col)
	{
		panels[r].spacedRemove(col);
	}
	

}
