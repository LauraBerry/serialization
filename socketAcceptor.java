import java.io.*;
import java.net.*;


public class socketAcceptor
{
	private String ip = "localhost";
	private Socket socket = null;
	private int socketTimeoutDuration= 2000;
	private final char END_OF_STREAM= (char)-1;

	public socketAcceptor(int a)
	{
		createSocket(a);
	}
	
	private void createSocket(int port)
	{
		try
		{
			socket = new Socket(ip,port);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public String getMessage()
	{
		StringBuilder message = new StringBuilder();
		boolean socketClosed= false;
		
		//can impliment such that connection is established and you are alwways listening or you can have a time out time
		try
		{
			char dataByte; 
		
			while((dataByte=(char)socket.getInputStream().read())!= END_OF_STREAM)
			{
				message.append(dataByte);
			}
		
			socketClosed = dataByte == END_OF_STREAM;

			if(socketClosed)
			{
				socket.close();
			}
			else
			{
				System.out.println("\n\n\nBANG\n\n\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message.toString();
	}
}
