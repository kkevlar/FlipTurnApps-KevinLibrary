package com.flipturnapps.kevinLibrary.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandParseException;
import com.flipturnapps.kevinLibrary.command.IncorrectDataException;
import com.flipturnapps.kevinLibrary.command.NonExistentCommandException;

public abstract class LightKCommandClient extends KCommandClient {

	public LightKCommandClient(String ip, int port, ArrayList<Command> down)
			throws UnknownHostException, IOException {
		super(ip, port, down);
	}

	@Override
	protected void commandParseExceptionDownCommand(CommandParseException e) 
	{
		System.out.println("Down Command parse exception!");
	}

	@Override
	protected void incorrectDataExceptionDownCommand(IncorrectDataException e) 
	{
		System.out.println("Down Command incorrect data exception " + e.getErrorTypeText());

	}

	@Override
	protected void nonExistentCommandExceptionDownCommand(NonExistentCommandException e) 
	{
		System.out.println("Down command nonexistent command exception!");
	}

	

}
