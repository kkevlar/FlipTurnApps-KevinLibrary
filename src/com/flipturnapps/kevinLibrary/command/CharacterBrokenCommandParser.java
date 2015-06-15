package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public abstract class CharacterBrokenCommandParser extends CommandParser {


	public CharacterBrokenCommandParser(ArrayList<Command> commands) 
	{
		super(commands);
	}

	public CharacterBrokenCommandParser(Command[] commands) 
	{
		super(commands);
	}

	@Override
	public CommandWrapper parseAsCommand(String commandString) throws CommandParseException, NonExistentCommandException 
	{
		if(!commandString.startsWith(this.getStartingCharacters()))
			throw new CommandParseException(commandString);
		else
		{
			try
			{
				String noSlashString = commandString.substring(this.getStartingCharacters().length());
				String[] commandChuncks = noSlashString.split(this.getSplittingCharacters());
				String[] params = new String[commandChuncks.length - 1];
				String commandName = commandChuncks[0];
				for(int i = 0; i < params.length; i++)
				{
					params[i] = commandChuncks[i+1];
				}
				CommandWrapper wrapper = new CommandWrapper();
				wrapper.setCommand(this.getCommand(commandName, params));
				wrapper.setCommandName(commandName);
				wrapper.setParamaters(params);
				return wrapper;
			}
			catch(RuntimeException ex)
			{

				throw new CommandParseException(commandString);
			}
		}
	}

	public abstract String getSplittingCharacters();

	public abstract String getStartingCharacters();
}
