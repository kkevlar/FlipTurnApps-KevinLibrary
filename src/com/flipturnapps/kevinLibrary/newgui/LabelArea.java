package com.flipturnapps.kevinLibrary.newgui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.flipturnapps.kevinLibrary.gui.KJLabel;
import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class LabelArea {

	private JPanel panel;
	private JScrollPane scroll;
	private boolean autoScrollDown;
	private AdjustmentEvent e;
	public LabelArea() {
		panel = new JPanel();
		panel.setBackground(KevinColor.kwhite);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(new KJLabel());
	}
	
	public void autoScrollDown()
	{
		scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        @Override
			public void adjustmentValueChanged(AdjustmentEvent e) {  
	        	if(e.getValueIsAdjusting() == false)
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
	}
	JScrollPane getComponent()
	{
		return scroll;
	}
	public JScrollPane getPane()
	{
		return scroll;
	}
	public ArrayList<KJLabel> getLabels()
	{
		ArrayList<KJLabel> labels = new ArrayList<KJLabel>();
		for(int i = 0; i < panel.getComponentCount(); i++)
		{
			labels.add((KJLabel) panel.getComponent(i));
		}
		return labels;
	}
	public KJLabel print(String text)
	{
		KJLabel label = (KJLabel) panel.getComponent(panel.getComponentCount() -1 );
		label.setText(label.getText() + text);
		return label;
	}
	public KJLabel println(String text)
	{
		KJLabel label = print(text);
		panel.add(new KJLabel());		
		return label;
	}
	public void clear()
	{
		panel.removeAll();
		panel.add(new KJLabel());
	}





}
