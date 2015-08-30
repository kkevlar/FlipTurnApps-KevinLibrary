package com.flipturnapps.kevinLibrary.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.flipturnapps.kevinLibrary.helper.DependentSocketReader;
import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public abstract class KClient extends Socket
{
	private FlushWriter writer;
	private DependentSocketReader reader;
	public KClient(String ip, int port) throws UnknownHostException, IOException 
	{
		super(ip,port);
		writer = new FlushWriter(this.getOutputStream());
		reader = new ClientReader(this);
	}
	private class ClientReader extends DependentSocketReader
	{

		public ClientReader(Socket socket) throws IOException {
			super(socket);
		}

		@Override
		protected void readString(String read) 
		{
			if(read.equals(">hb"))
				writer.println(">hb");
			else if(read.equals(">dis"))
			{
				disconnectedFromServer();
				disconnect();
			}
			else
				readMessage(read);

		}

		



	}
	protected abstract void disconnectedFromServer();
	protected abstract void readMessage(String read);
	public void sendMessage(String message)
	{
		writer.println(">" + message);
	}
	public void disconnect()
	{
		writer.println(">dis");
		try {
			this.reader.close();
			this.writer.flush();
			this.writer.close();		
			this.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
