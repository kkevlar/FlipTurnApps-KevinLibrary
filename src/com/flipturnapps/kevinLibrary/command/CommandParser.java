package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public abstract class CommandParser extends CommandExecutor
{

	public CommandParser(ArrayList<Command> commands) 
	{
		super(commands);
	}
	public CommandParser(Command[] commands) 
	{
		super(commands);
	}
	public abstract CommandWrapper parseAsCommand(String commandString) throws CommandParseException, NonExistentCommandException;
	public Object runCommand(String commandString, CommandSpeaker speaker, Object data) throws IncorrectDataException, CommandParseException, NonExistentCommandException
	{
		CommandWrapper wrapper = this.parseAsCommand(commandString);
		return this.executeCommand(wrapper.getCommand(),wrapper.getCommandName(),wrapper.getParamaters(),speaker, data);
	}
	
}
