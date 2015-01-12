package com.flipturnapps.kevinLibrary.gui;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class KJLabel extends JLabel {

	public KJLabel() {
		// TODO Auto-generated constructor stub
	}

	public KJLabel(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public KJLabel(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public KJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public KJLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public KJLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}
	public void setFontSize(int size)
	{
		Font curFont = getFont();
	    setFont(new Font(curFont.getFontName(), curFont.getStyle(), size));
	}

}
