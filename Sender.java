import java.lang.*;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;


public class Sender
{
	private static Network networkConnection = null;
	private static Serializer serializer = null;
	private static ObjectCreator objCreator = null;
	
	public static boolean connected;
	
	public static void main(String[] args) throws Exception
	{
		initialize(args);
		Object obj = objCreator.createObject();

		while(connected)
		{	
			if(!connected)
			{
				continue;
			}
			
			Document doc = serializer.serialize(obj, new Document(new Element("serialized")));
			XMLOutputter outfile = new XMLOutputter();	
			outfile.setFormat(Format.getPrettyFormat());
			outfile.output(doc, new FileWriter("input.xml"));
			System.out.println("File wriiten as input.xml");
			String xmlString = XMLtoString(doc);
			
			networkConnection.send(xmlString);

			System.out.println("Sent document");
			connected = false;
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
