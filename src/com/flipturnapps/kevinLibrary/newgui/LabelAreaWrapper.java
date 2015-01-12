package com.flipturnapps.kevinLibrary.newgui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class LabelAreaWrapper extends JPanel
{
	public LabelAreaWrapper(LabelArea area)
	{
		super();
		this.setLayout(new BorderLayout());
		this.setBackground(KevinColor.kwhite);
		this.add(area.getComponent());
	}
}
