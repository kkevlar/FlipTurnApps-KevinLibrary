package com.flipturnapps.kevinLibrary.command;

public class CommandParseException extends Exception
{

	private String commandString;

	public CommandParseException(String commandString) 
	{
	this.setCommandString(commandString);
	}

	public String getCommandString() {
		return commandString;
	}

	public void setCommandString(String commandString) {
		this.commandString = commandString;
	}

}
