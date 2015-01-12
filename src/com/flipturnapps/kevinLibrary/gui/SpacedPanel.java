package com.flipturnapps.kevinLibrary.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SpacedPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1237185178867310342L;
	
	private JPanel[] panels;
	private int layout;
	public SpacedPanel(int length) 
	{
		super();
		setUp(length,BoxLayout.X_AXIS);
	}
	public SpacedPanel(int length,int layout) 
	{
		super();
		setUp(length,layout);
	}
	private void setUp(int length, int layout)
	{
		this.layout = layout;
		panels = new JPanel[length];
		this.setLayout(new BoxLayout(this, layout));
		for(int i = 0; i < panels.length; i++)
		{
			panels[i] = new JPanel();
			panels[i].setLayout(new BorderLayout());
			panels[i].add(new TransparentPanel());
			this.add(panels[i]);
		}
		setSizes();
	}
	public int getPanelCount()
	{
		return panels.length;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setSizes();
	}
	private void setSizes()
	{
		for(int i = 0;  i < panels.length; i++)
		{
			if(layout == BoxLayout.X_AXIS)
			panels[i].setPreferredSize(new Dimension(this.getWidth() / panels.length, this.getHeight()));
			else
				panels[i].setPreferredSize(new Dimension(this.getWidth() , this.getHeight()/ panels.length));
		}
	}
	public void spacedAdd(Component comp, int i)
	{
		panels[i].removeAll();
		panels[i].add(comp);
		repaint();
	}
	public JPanel[] getPanels()
	{
		return panels;
	}
	public void spacedRemove(int i)
	{
		panels[i].removeAll();
		panels[i].add(new TransparentPanel());
		repaint();
	}

}
