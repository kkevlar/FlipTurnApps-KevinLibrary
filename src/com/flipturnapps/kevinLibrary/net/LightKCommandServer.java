package com.flipturnapps.kevinLibrary.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandParseException;
import com.flipturnapps.kevinLibrary.command.IncorrectDataException;
import com.flipturnapps.kevinLibrary.command.NonExistentCommandException;

public abstract class LightKCommandServer<E extends ClientData> extends KCommandServer<E> {

	public LightKCommandServer(String ip, int port, ArrayList<Command> up)
			throws IOException {
		super(ip, port, up);
		// TODO Auto-generated constructor stub
	}

	public LightKCommandServer(String ip, int port,
			boolean shouldDisconnectClients, ArrayList<Command> up)
			throws UnknownHostException, IOException {
		super(ip, port, shouldDisconnectClients, up);
		// TODO Auto-generated constructor stub
	}

	public LightKCommandServer(int port, ArrayList<Command> up)
			throws IOException {
		super(port, up);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void commandParseExceptionUpCommand(CommandParseException e) 
	{
		System.out.println("Up Command parse exception!");
	}

	@Override
	protected void incorrectDataExceptionUpCommand(IncorrectDataException e) 
	{
		System.out.println("Up Command incorrect data exception " + e.getErrorTypeText());

	}

	@Override
	protected void nonExistentCommandExceptionUpCommand(NonExistentCommandException e) 
	{
		System.out.println("Up command nonexistent command exception!");

	}

}
