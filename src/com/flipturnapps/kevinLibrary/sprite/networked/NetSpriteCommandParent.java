package com.flipturnapps.kevinLibrary.sprite.networked;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandIO;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;

public abstract class NetSpriteCommandParent extends SimpleCommand 
{
	@Override
	public String getHelpText()
	{
	
		return null;
	}

	

	

	@Override
	public boolean willInterceptCommand(Command command, String[] params) {
	
		return false;
	}

	@Override
	public void interceptCommand(Command command, String[] params) {
	

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
	public ArrayList<String> getPermissionsCanHave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean objectDataOK(Object data) {
	return true;
	}

	@Override
	public boolean permProtected() {

		return false;
	}

	@Override
	public boolean needsIO() {

		return false;
	}
	
	@Override
	public Object execute(String commandName, String[] params, CommandIO speaker, Object data) 
	{
		netSpriteExecute(params,(NetworkedSpritePanel) data);
		return data;
	}





	protected abstract void netSpriteExecute(String[] params, NetworkedSpritePanel panel);

}
