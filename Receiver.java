package assignment3;
import org.jdom2.*;

public class Receiver
{
	private static Deserializer deserializer = null; 
	private static Visualizer visualizer = null;
	private static SocketAcceptor socketAcceptor=null;
	
	public static boolean connected;
	
	public static void main(String[] args)
	{
		initialize(args);
		
		string message= socketAcceptor.getMessage();
		
		Document doc = deserializer.stringToDoc(message);
		Object obj = deserializer.deserialize();
		
		visualizer.visualize(obj, true);
		
	}
	
	public static void initialize(String[] args)
	{
		connected=true;
		socketAcceptor=new SocketAcceptor(4321);//need to make sure this can read from the command line too
		deserializer= new Deserializer();
		visualizer= new Visualizer();
		
		if(connected)
		{
			socketAcceptor.acceptConnection();
		}
	}
}
