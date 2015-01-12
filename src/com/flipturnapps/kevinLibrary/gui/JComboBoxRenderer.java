package com.flipturnapps.kevinLibrary.gui;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public abstract class JComboBoxRenderer implements ListCellRenderer
{

	@Override
	public Component getListCellRendererComponent(JList arg0, Object value,
			int arg2, boolean arg3, boolean arg4) {
		int selectedIndex = ((Integer)value).intValue();
		return getComponent(arg0,selectedIndex, arg3,arg4);
	}
	public abstract Component getComponent (JList list, int index, boolean selected, boolean cellHasFocus);
}