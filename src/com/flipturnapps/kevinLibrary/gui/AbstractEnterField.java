package com.flipturnapps.kevinLibrary.gui;

public abstract class AbstractEnterField extends EnterField {

	public AbstractEnterField() {
		super();
	}

	public AbstractEnterField(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public AbstractEnterField(int columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void enterrPressed()
	{
		enterPressed();
	}

	protected abstract void enterPressed();

}
