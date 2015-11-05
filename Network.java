import java.net.Socket;
import java.io.*;

public class Network
{
	private Socket socket = null;
	private int port = 4321;
	private String ip= "localhost";
	
	public void send (String message)
	{
		if(socket==null)
		{
			connect(0);
		}
		if (socket !=null&& socket.isConnected())
		{
			
		}
	}
	public void send(String message)
	{
		if(socket==null)
		{
			connect(0);
		}
		if (socket !=null&& socket.isConnected())
		{
			try
			{
				OutputStream outstream= socket.getOutputStream();
				
				outstream.write(message.getBytes());
				outstream.flush();
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("socket unavailable");
		}
	}
	public void connect()
	{
		try
		{
			socket=new Socket(ip, port);
		}
		catch (IOException e)
		{
			Sender.connected= false;
		}
	}
	
	public void setIP()
	{
		
	}
	public void setPort()
	{
		
	}
}