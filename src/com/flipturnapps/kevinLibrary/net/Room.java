package com.flipturnapps.kevinLibrary.net;

import java.util.ArrayList;

public class Room 
{
	private ArrayList<? extends ClientData> clients;

	public Room (KServer<?> server)
	{
		server.initializeMe(this);
	}
	protected ArrayList<? extends ClientData> getClients() 
	{
		return clients;
	}

	protected void setClients(ArrayList<? extends ClientData> clients) 
	{
		this.clients = clients;
	}
	
	public ClientData getClient(int i)
	{
		return clients.get(i);
	}
}
