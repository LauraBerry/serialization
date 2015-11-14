package assignment3;

import java.io.*;
import java.net.*;


public class socketAcceptor
{
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private int socketTimeoutDuration= 2000;
	private final char END_OF_STREAM= (char)-1;
	
	public void SocketAcceptor()
	{
		createServerSocket(4321);//or pass paramiter
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
			Reciever.connected= false;
		}
		else
		{
			System.out();
		}
		return message.toString();
	}
	
	public void acceptConnection()
	{
		try
		{
			socket = serverSocket.accept();
			socket.setSoTimeout(socketTimeoutDruation);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
