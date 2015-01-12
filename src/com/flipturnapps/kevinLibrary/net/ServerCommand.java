package com.flipturnapps.kevinLibrary.net;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;

public abstract class ServerCommand extends SimpleCommand {


	@Override
	public String getHelpText() 
	{
		return null;
	}

	@Override
	public boolean willInterceptCommand(Command command, String[] params) 
	{
		
		return false;
	}

	@Override
	public void interceptCommand(Command command, String[] params)
	{
		

	}

	@Override
	public int getInterceptPriority() {
		return 0;
	}

	@Override
	public String[] getAliases() {

		return null;
	}

	@Override
	public ArrayList<String> getPermissionsCanHave() 
	{
		return null;
	}

	@Override
	public boolean objectDataOK(Object data) 
	{
		
		return true;
	}

	@Override
	public boolean permProtected() {
		
		return false;
	}

}
