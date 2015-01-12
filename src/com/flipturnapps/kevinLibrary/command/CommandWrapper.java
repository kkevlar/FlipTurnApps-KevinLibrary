package com.flipturnapps.kevinLibrary.command;

public class CommandWrapper 
{
	private Command command;
	private String commandName;
	private String[] paramaters;
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String[] getParamaters() {
		return paramaters;
	}
	public void setParamaters(String[] paramaters) {
		this.paramaters = paramaters;
	}
}
