package assignment3;

import java.io.*;
import java.net.*;


public class socketAcceptor
{
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private int socketTimeoutDuration= 2000;
	private final char END_OF_STREAM= (char)-1;

	public socketAcceptor(int a)
	{
		createServerSocket(a);
	}
	
	private void createServerSocket(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public String getMessage()
	{
		StringBuilder message = new StringBuilder();
		boolean reading = true; 
		boolean socketClosed= false;
		
		//can impliment such that connection is established and you are alwways listening or you can have a time out time
		while(socket != null && socket.isConnected() && reading)
		{
			try
			{
				char dataByte; 
				
				while((dataByte=(char)socket.getInputStream().read())!= END_OF_STREAM)
				{
					message.append(dataByte);
				}
				
				socketClosed = dataByte == END_OF_STREAM;
				reading = false;
			}
			catch (SocketTimeoutException e)
			{
				System.out.println(e);
			}	
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		if(socketClosed)
		{
			//Laura need to deal with this
			//Reciever.connected= false;
		}
		else
		{
			System.out.println();
		}
		return message.toString();
	}
	
	public void acceptConnection()
	{
		try
		{
			socket = serverSocket.accept();
			socket.setSoTimeout(socketTimeoutDuration);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
