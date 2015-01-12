package com.flipturnapps.kevinLibrary.newgui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class KJTextArea extends JTextArea
{
	private JScrollPane pane;
	public KJTextArea ()
	{
		super();
	}
	public JScrollPane setUpDefault()
	{
		setLineWrap(true);
		JScrollPane scroll = new JScrollPane(this);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.pane = scroll;
		return scroll;
	}
	public void println(String s)
	{
		append(s + "\n");
	}
	public void print(String s)
	{
		append(s);
	}
	public void autoScrollDown()
	{
		if(pane != null)
		{
			JScrollPane scroll = pane;
			scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {  
					if(e.getValueIsAdjusting() == false)
						e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
				}
			});
		}
	}

}
