package com.flipturnapps.kevinLibrary.command;

public abstract class OutputSimpleCommand extends SimpleCommand {

	private CommandOutput printer;
	public OutputSimpleCommand(CommandOutput output) 
	{
		printer = output;
	}
	protected CommandOutput getCommandOutput()
	{
		return printer;
	}

}
