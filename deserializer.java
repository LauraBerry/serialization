import java.lang.*;
import java.jdom2.*;
import java.util.*;
import java.io.*;

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
			obj=parseDocument(doc);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return obj;
	}
	public Document stringToDoc(String a)
	{
		Document doc;
		
		try
		{
			SAXBuilder docBuilder = new SAXBuilder();
			InputStream docStream = new ByteArrayInputStream(a.getBytes("UTF-8"));
			doc=docBuilder.build(docStream);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return doc;
	}
	
	public Object parseDocument (Document doc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, DataConversionException
	{
		List <Element> objectElements = doc.getRootElement.getChildren("object");	
		for(Element objectElements: objectElement)
		{
			String ClassName=objectElement.getAttribute("class");
			Class<?> tmpClass= Class.forName(className)
			Object obj= referenceMap.get(objectElement.getAttribute("id").getIntValue());
			if(tmpClass.isArray)
			{
				//setArray(obj, tmpClass, objectElement); 
			}
			else
			{
				List<Element> fieldElements=objectElement.getChildren("fields");
				for(Element fieldElement: fieldElements)
				{
					
					//setField(obj, tmpClass, fieldElement);
				}
			}
		}
	}
	
	public Object subDeserializer(Document doc)
	{
		List objects = doc.getRootElement().getChildren();
		HashMap table= new HashMap();
		
		instantiate(table, objects);
		assignValues(table, objects);
		
		return table.get("0");
	}
	
	public void instantiate(HashMap a, List objs) throws Exception
	{
		for (int i=0; i<objs.size();i++)
		{
			Element objElement= (Element) objs.get(i);
			Class clName= Class.forName(objElements.getAttributeValue("class"));
			Object instance;
			if(!clName.isArray())
			{
				Constructor cons= clName.getDeclaredConstructor(null);//no args
				if(!mods.isPublic(cons.getModifiers())
				{
					cons.setAccessible(true); 
				}
				instance = cons.newInstance();
			}
			else 
			{
				instance=Array.newInstance(clName.getComponentType(), Integer.parseInt(objElement.getAttributeValue("length"));
				a.put(objElement.getAttributeValue("id"),instanceOf);
			}
		}
	}
	
	public void assignValues(HashMap a, List objs)
	{
		for (int i=0; i<objs.size(); i++)
		{
			Element objElements = (Element) objs.git(i);
			Object instanceOf = table.get(objElements.getAttributeValue("id"));
		}
	}
}