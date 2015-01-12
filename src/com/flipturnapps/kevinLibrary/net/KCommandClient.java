package com.flipturnapps.kevinLibrary.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandParseException;
import com.flipturnapps.kevinLibrary.command.IncorrectDataException;
import com.flipturnapps.kevinLibrary.command.NonExistentCommandException;

public abstract class KCommandClient extends KClient {

	private NetCommandParser downParser;
	public KCommandClient(String ip, int port, ArrayList<Command> down) throws UnknownHostException,  IOException 
	{
		super(ip, port);
		this.setUp(down);
	}
	private void setUp(ArrayList<Command> down)
	{
		downParser = new NetCommandParser(down);		
	}

	@Override
	protected void readMessage(String message) 
	{
	
		try {
			downParser.runCommand(message, null, makeDownCommandData(message));
		} 
		catch (IncorrectDataException e) 
		{
			incorrectDataExceptionDownCommand(e);
		} catch (CommandParseException e) 
		{
			commandParseExceptionDownCommand(e);
		} catch (NonExistentCommandException e) 
		{
			nonExistentCommandExceptionDownCommand(e);
		}
		
	}

	
	protected abstract void commandParseExceptionDownCommand(CommandParseException e);
	protected abstract void incorrectDataExceptionDownCommand(IncorrectDataException e);
	protected abstract void nonExistentCommandExceptionDownCommand(NonExistentCommandException e);

	public abstract Object makeDownCommandData(String message);

	

}
