package com.flipturnapps.kevinLibrary.command;

public class NonExistentCommandException extends Exception 
{
	private String commandName;
	private String[] params;

	public NonExistentCommandException(String con_commandName, String[] con_params)
	{
		setCommandName(con_commandName);
		setParams(con_params);
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
