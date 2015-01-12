package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public interface Command 
{
	public static final int CAN_EXECUTE = 0;
	public static final int PARAMS_INCORRECT = 1;
	public static final int NAME_INCORRECT = 2;
	public static final int DATA_INCORRECT = 3;
	public static final int PERMISSIONS_INCORRECT = 4;
	public String getName();
	public String getHelpText();
	public int getMaximumParams();
	public int getMinimumParams();
	public boolean willInterceptCommand(Command command, String[] params);
	public void interceptCommand(Command command, String[] params);
	public int getInterceptPriority();
	public String[] getAliases();
	public Object execute(String commandName, String[] params, Object data);
	public boolean namesMatch(String commandName, String[] params);
	public int canExecute(String commandName, String[] params, CommandSpeaker speaker, Object data);
	public void setCommandExecutor(CommandExecutor executor);
	public CommandExecutor getCommandExecutor();
	public ArrayList<String> getPermissionsCanHave();
}
