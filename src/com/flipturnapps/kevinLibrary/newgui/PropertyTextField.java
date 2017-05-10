package com.flipturnapps.kevinLibrary.newgui;

import javax.swing.JTextField;

import com.flipturnapps.kevinLibrary.helper.PropertyManager;

public class PropertyTextField extends JTextField 
{
	private PropertyManager properties;
	private String name;

	public PropertyTextField(PropertyManager manager, String propertyName)
	{
		this.properties = manager;
		this.name = propertyName;
		
		this.setText(properties.getProperty(name));
	}
	
	public String getText()
	{
		String text = super.getText();
		properties.setProperty(name, text);
		return text;
	}
	
}
