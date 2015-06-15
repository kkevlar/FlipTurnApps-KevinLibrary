package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public class CommandExecutor 
{
	private boolean interceptionsAllowed;
	private ArrayList<Command> commands;
	public CommandExecutor(ArrayList<Command> commands)
	{
		this.commands = commands;
		this.setUp();
	}
	private void setUp() 
	{
		for (int i = 0; i < commands.size(); i++) 
		{
			commands.get(i).setCommandExecutor(this);
		}
	}
	public CommandExecutor(Command[] commandsArray)
	{
		commands = new ArrayList<Command>();
		for (int i = 0; i < commandsArray.length; i++) 
		{
			this.commands.add(commandsArray[i]);
		}
		this.setUp();
	}
	public boolean isInterceptionsAllowed() {
		return interceptionsAllowed;
	}
	public void setInterceptionsAllowed(boolean interceptionsAllowed) 
	{
		this.interceptionsAllowed = interceptionsAllowed;
	}

	public Command getCommand(String commandName, String params[]) throws NonExistentCommandException
	{
		int good = -1;
		for (int i = 0; i < commands.size(); i++)
		{
			if(commands.get(i).namesMatch(commandName, params))
			{
				good = i;
			}
		}
		if(good > -1)
			return commands.get(good);
		else
			throw new NonExistentCommandException(commandName, params);
	}
	public Object executeCommand(Command command, String commandName, String[] params, CommandSpeaker speaker, Object data) throws IncorrectDataException 
	{
		if(!this.runIntercepts(command, commandName, params, data))
		{
			if(command.canExecute(commandName, params, speaker, data) == Command.CAN_EXECUTE)
				return command.execute(commandName, params, data);
			else if(command.canExecute(commandName, params, speaker, data) == Command.DATA_INCORRECT)
				throw new IncorrectDataException(commandName, params, data, Command.DATA_INCORRECT);
			else if(command.canExecute(commandName, params, speaker, data) == Command.NAME_INCORRECT)
				throw new IncorrectDataException(commandName, params, data, Command.NAME_INCORRECT);
			else if(command.canExecute(commandName, params, speaker, data) == Command.PARAMS_INCORRECT)
				throw new IncorrectDataException(commandName, params, data, Command.PARAMS_INCORRECT);
			else if(command.canExecute(commandName, params, speaker, data) == Command.PERMISSIONS_INCORRECT)
				throw new IncorrectDataException(commandName, params, data, Command.PERMISSIONS_INCORRECT);
		}
		return data;
	}
	protected boolean runIntercepts(Command command, String commandName, String[] params, Object data)
	{
		ArrayList<Command> priorityCommands = new ArrayList<Command>();
		ArrayList<Command> commandCopy = new ArrayList<Command>();
		for(int i = 0; i < this.getCommandList().size();i++)
		{
			commandCopy.add(this.getCommandList().get(i));
		}
		while(commandCopy.size() > 0)
		{
			Command maxCommand = commandCopy.get(0);
			for(int i = 0; i < commandCopy.size(); i++)
			{
				if(maxCommand.getInterceptPriority() > commandCopy.get(i).getInterceptPriority())
					maxCommand = commandCopy.get(i);
			}
			priorityCommands.add(maxCommand);
			commandCopy.remove(maxCommand);
		}
		for(int i = 0; i < priorityCommands.size(); i++)
		{
			if(priorityCommands.get(i).willInterceptCommand(command, params))
			{
				priorityCommands.get(i).interceptCommand(command, params);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Command> getCommandList() 
	{
		return this.commands;
	}
}
