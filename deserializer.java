import java.lang.*;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;


public class deserializer
{
	private Scanner darkly;
	private HashMap <Integer, Object> referenceMap = new HashMap<Integer, Object>();
	public Object deserialize(Document doc)
	{
		darkly= new Scanner(System.in);
		Object obj = null;
		try
		{
			//initializeReferenceMap(doc);
			obj=subDeserializer(doc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	public Document stringToDoc(String a)
	{
		Document doc=null;
		try
		{
			SAXBuilder docBuilder = new SAXBuilder();
			InputStream docStream = new ByteArrayInputStream(a.getBytes("UTF-8"));
			doc=docBuilder.build(docStream);
			XMLOutputter outfile = new XMLOutputter();
			outfile.setFormat(Format.getPrettyFormat());
			outfile.output(doc, new FileWriter("output.xml"));
			System.out.println("File received as output.xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return doc;
	}
	
	public Object subDeserializer(Document doc) throws Exception
	{
		List objects = doc.getRootElement().getChildren();
		HashMap table= new HashMap();
		
		instantiate(table, objects);
		assignValues(table, objects);
		
		return table.get("0");
	}
	
	public void instantiate(HashMap map, List objs) throws Exception
	{
		for (int i=0; i<objs.size();i++)
		{
			Element objElement= (Element) objs.get(i);
			Class clName= Class.forName(objElement.getAttributeValue("class"));
			Object instance;
			if(!clName.isArray())
			{
				Constructor cons= clName.getDeclaredConstructor();//no args
				instance = cons.newInstance();
			}
			else 
			{
				instance=Array.newInstance(clName.getComponentType(), Integer.parseInt(objElement.getAttributeValue("length")));
				map.put(objElement.getAttributeValue("id"), instance);
			}
		}
	}
	
	public void assignValues(HashMap a, List objs)throws Exception
	{
		for (int i=0; i<objs.size(); i++)
		{
			Element objElements = (Element) objs.get(i);
			Object instance = a.get(objElements.getAttributeValue("id"));
			List fields = objElements.getChildren();
			if(!instance.getClass().isArray())
			{
				for (int j=0; j<fields.size(); j++)
				{
					Element fieldElement= (Element) fields.get(j);
				}
			}
			else
			{
				Class component = instance.getClass().getComponentType();
				for (int j=0; j<fields.size(); j++)
				{
					Array.set(instance, j,deserializeVal((Element)fields.get(j), component, a));
				}
			}
		}
	}
	public Object deserializeVal (Element elm, Class cl, Map a) throws Exception
	{
		String elemType= elm.getName();
		if (elemType.equals("null"))
		{
			return null;
		}
		else if (elemType.equalsIgnoreCase("refrence"))
		{
			return a.get(elm.getText());
		}
		else
		{
			if(cl.equals(boolean.class))
			{
				if(elm.getText().equals("true"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if (cl.equals(short.class))
			{
				return Short.valueOf(elm.getText());
			}
			else if (cl.equals(byte.class))
			{
				return Byte.valueOf(elm.getText());
			}
			else if (cl.equals(long.class))
			{
				return Long.valueOf(elm.getText());
			}
			else if (cl.equals(double.class))
			{
				return Double.valueOf(elm.getText());
			}
			else if (cl.equals(float.class))
			{
				return Float.valueOf(elm.getText());
			}
			else if (cl.equals(String.class))
			{
				return String.valueOf(elm.getText());
			}
			else 
			{
				return Character.valueOf(elm.getText().charAt(0));
			}
		}
	}
}
