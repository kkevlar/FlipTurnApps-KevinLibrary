package com.flipturnapps.kevinLibrary.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.CommandParseException;
import com.flipturnapps.kevinLibrary.command.IncorrectDataException;
import com.flipturnapps.kevinLibrary.command.NonExistentCommandException;

public abstract class KCommandServer<E extends ClientData> extends KServer<E> {

	private NetCommandParser upParser;
	public KCommandServer(String ip, int port, ArrayList<Command> up) throws IOException 
	{
		super(ip, port);
		setUp(up);
	}

	public KCommandServer(String ip, int port, boolean shouldDisconnectClients, ArrayList<Command> up)	throws UnknownHostException, IOException 
	{
		super(ip, port, shouldDisconnectClients);
		setUp(up);
	}

	public KCommandServer(int port, ArrayList<Command> up) throws IOException 
	{
		super(port);
		setUp(up);
	}

	private void setUp(ArrayList<Command> up)
	{
		upParser = new NetCommandParser(up);		
	}

	@Override
	protected void newMessage(String message, E clientData)
	{
		try {
			upParser.runCommand(message, null, makeUpCommandData(clientData));
		} 
		catch (IncorrectDataException e) 
		{
			incorrectDataExceptionUpCommand(e);
		} catch (CommandParseException e) 
		{
			commandParseExceptionUpCommand(e);
		} catch (NonExistentCommandException e) 
		{
			nonExistentCommandExceptionUpCommand(e);
		}
		
	}

	protected abstract void commandParseExceptionUpCommand(CommandParseException e);
	protected abstract void incorrectDataExceptionUpCommand(IncorrectDataException e);
	protected abstract void nonExistentCommandExceptionUpCommand(NonExistentCommandException e);

	public abstract Object makeUpCommandData(E clientData);

	

	

}
