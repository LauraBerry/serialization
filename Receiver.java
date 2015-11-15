import org.jdom2.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Receiver
{
	private static deserializer deserialize = null; 
	private static Visualizer visualizer = null;
	private static socketAcceptor socketAccept=null;
	
	public static boolean connected;
	
	public static void main(String[] args) throws Exception
	{
		initialize(args);
		
		String message= socketAccept.getMessage();
		System.out.println("before deserialize");
		Document doc = deserialize.stringToDoc(message);
		System.out.println("doc created");
		Object obj = deserialize.deserialize(doc);
		System.out.println("after deserialize");
		visualizer.visualize(obj, true);
	}
	
	public static void initialize(String[] args)
	{
		connected=true;
		socketAccept=new socketAcceptor(4321);//Laura need to make sure this can read from the command line too
		deserialize= new deserializer();
		visualizer= new Visualizer();
		
		if(connected)
		{
			socketAccept.acceptConnection();
		}
	}
}
