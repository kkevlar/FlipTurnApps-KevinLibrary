package com.flipturnapps.kevinLibrary.gui;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class ButtonGroupPanel extends JPanel{
	private ButtonGroup group;
	public ButtonGroupPanel()
	{
		super();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		group = new ButtonGroup();
	}
	public AbstractButton addInGroup(AbstractButton button)
	{
		group.add(button);
		this.add(button);
		return button;
	}
}
