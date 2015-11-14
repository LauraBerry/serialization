package assignment3;
// This is meant to be a skeleton of the Sender class for assignment 3
import java.lang.reflect.*;
import java.lang.*;
import java.util.*;

import org.jdom2.*;

public class Sender
{
	private static Network networkConnection = null;
	private static Serializer serializer = null;
	private static ObjectCreator objCreator = null;
	
	public static boolean connected;
	
	public static void main(String[] args)
	{
		initialize(args);
		Object obj = objCreator.createObject();

		while(connected)
		{	
			if(!connected)
			{
				continue;
			}
			
			Document doc = serializer.serialize(obj);
			String xmlString = XMLtoString(doc);
			
			networkConnection.send(xmlString);
		}
	}
	
	public static void initialize(String[] args)
	{
		connected = true;
		networkConnection = new Network();
		serializer = new Serializer();
		objCreator = new ObjectCreator();
		
		if(args.length == 2)
		{
			networkConnection.setIP(args[0]);
			networkConnection.setPort(Integer.valueOf(args[1]));
		}
	}
	
	public static String XMLtoString(Document doc)
	{
		XMLOutputter outString = new XMLOutputter();
		return outString.outputString(doc);
	}
}
