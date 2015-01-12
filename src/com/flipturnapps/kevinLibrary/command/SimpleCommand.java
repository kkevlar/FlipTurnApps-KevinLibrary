package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.helper.ArrayHelper;
import com.flipturnapps.kevinLibrary.helper.ArrayListHelper;

public abstract class SimpleCommand implements Command {

	private CommandExecutor executor;
	@Override
	public String toString()
	{
		return this.getName();
	}
	@Override
	public int canExecute(String commandName, String[] params, CommandSpeaker speaker, Object data) 
	{

		if(!objectDataOK(data))
			return Command.DATA_INCORRECT;
		if(!this.namesMatch(commandName, params))
			return Command.NAME_INCORRECT;
		if(params.length > this.getMaximumParams() || params.length < this.getMinimumParams())
			return Command.PARAMS_INCORRECT;
		if(this.permProtected())
		{
			if(!(ArrayListHelper.someOverlap(this.getPermissionsCanHave(), speaker.getPermsOwned()) || speaker.getPermsOwned().contains("op")))	
				return Command.PERMISSIONS_INCORRECT;
		}
		return Command.CAN_EXECUTE;
	}
	public abstract boolean objectDataOK(Object data);
	public abstract boolean permProtected();
	@Override
	public boolean namesMatch(String commandName, String[] params) 
	{
		//System.out.println("Names match commandName: "+ commandName);
		boolean aliasesGood = false;
		if(this.getAliases() != null)
			aliasesGood = ArrayHelper.contains(commandName, this.getAliases());
		return ((this.getName().equals(commandName) || aliasesGood));

	}
	public ArrayList<Command> getCommandList()
	{
		return executor.getCommandList();
	}
	@Override
	public void setCommandExecutor(CommandExecutor exe)
	{
		this.executor = exe;
	}
	@Override
	public CommandExecutor getCommandExecutor()
	{
		return this.executor;
	}



}
