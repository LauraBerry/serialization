import java.net.*;
import java.io.*;

public class Network
{
	private ServerSocket server = null;
	private int port = 4321;
	private String ip = "localhost";

	public Network()
	{ }

	public void send(String message)
	{
		try
		{
			server = new ServerSocket(port);
			Socket receiver = server.accept();

			OutputStream stream = receiver.getOutputStream();
			stream.write(message.getBytes());
			stream.flush();

			server.close();
			receiver.close();
		}
		catch(Exception e)
		{
			//Sender.connected = false;
			e.printStackTrace();
		}
	}

	public void setIP(String newIP)
	{
		ip = newIP;
	}

	public void setPort(int newPort)
	{
		port = newPort;
	}
}
