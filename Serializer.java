import java.lang.reflect.*;
import java.util.*;
import org.jdom2.*;

public class Serializer
{
	private Document doc = null;
	private Element root;
	
	private Integer referenceID = 0;
	private IdentityHashMap map;
	
	private int currentElement = 0;
	private ArrayList<Object> serializedObjects = new ArrayList<Object>();
	
	public Serializer()
	{
		map= new IdentityHashMap();
	}
	
	public Document serialize(Object object,Document doc)
	{
		/*
		if(object == null)
		{
			return new Document(new Element("null"));
		}
		else*/if(true) 
		{
			Class c = object.getClass();
			Integer id = getID(object);
			map.put(object, id);
			String mapSize= Integer.toString(map.size());
			Element objectElement = new Element("object");
			objectElement.setAttribute(new Attribute("class", c.getName()));
			objectElement.setAttribute(new Attribute("id", mapSize));
			doc.getRootElement().addContent(objectElement);
			serializedObjects.add(object);

			if(!c.isArray())
			{

//				if(!serializedObjects.contains(object))
//				{
					Field[] fields = c.getDeclaredFields();
					ArrayList<Element> fieldXML = serializeFields(fields, object, doc);
					for(int i=0; i<fieldXML.size(); i++)
					{
						objectElement.addContent(fieldXML.get(i));
					}
//				}
			}
			else
			{
				Object array = object;
				objectElement.setAttribute(new Attribute("length", Integer.toString(Array.getLength(array))));
				
				if(c.getComponentType().isPrimitive())
				{
					for(int i = 0;i<Array.getLength(array);i++)
					{
						Element value = new Element("value");
						value.setText(Array.get(c,i).toString());
						objectElement.addContent(value);
					}
				}
				else
				{
					for(int j = 0; j< Array.getLength(array); j++)
					{
						Element ref = new Element("reference");
						id = getID(Array.get(c,j));
						if(id != -1)
						{
							ref.setText(Integer.toString(id));	// add each array element
						}
					}
					for(int k = 0;k<Array.getLength(array);k++)
					{
						serialize(Array.get(array,k), doc);
					}
				}
			}
		}
		if(currentElement == 0)
		{
			serializedObjects.clear();
			referenceID = 0;
		}
		
		return doc;
	}

	private ArrayList<Element> serializeFields(Field[] fields, Object object, Document doc)
	{
		Class currentClass=object.getClass();
		ArrayList<Element> elements = new ArrayList<Element>();
		for(Field f : fields)
		{
			try
			{
				if(!currentClass.isPrimitive())
				{
					System.out.println("hello?");
					// Field not primitive, is a reference to another object
				}
				else
				{
					System.out.println("Here you are");
					Element newField = new Element("field");
					newField.setAttribute("name",f.getName());
					newField.setAttribute("declaringclass",f.getDeclaringClass().getName());
					Element newValue = new Element("value");
					newValue.addContent(f.get(object).toString());
					newField.addContent(newValue);
					elements.add(newField);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return elements;
	}
	
	private int getID(Object object)
	{
		Integer id = referenceID;
		
		if(map.containsKey(object))
			id = (Integer) map.get(object);
		else
		{
			map.put(object, id);
			referenceID++;
		}
		
		return id;
	}

}
