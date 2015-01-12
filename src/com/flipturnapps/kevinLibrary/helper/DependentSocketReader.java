package com.flipturnapps.kevinLibrary.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public abstract class DependentSocketReader extends BufferedReader {

	private boolean shouldRead = true;
	public DependentSocketReader(Socket socket) throws IOException
	{
		super(new InputStreamReader(socket.getInputStream()));
		new Thread(new Reader()).start();
	}
	private boolean shouldRead()
	{
		return shouldRead ;
	}
	public void disable()
	{
		shouldRead = false;
	}
	public void stop()
	{
		shouldRead = false;
	}
	protected abstract void readString(String read);
	private class Reader implements Runnable
	{

		@Override
		public void run() 
		{
			while(shouldRead())
			{
				String read = null;
				try {
					read = readLine();
				} catch (IOException e) 
				{
					
				}
				if(read != null && shouldRead())
					readString(read);
				ThreadHelper.sleep(75);
			}

		}

	}





}
