import java.lang.reflect.*;
import java.util.*;

import org.jdom2.*;

public class Serializer
{
	private Document doc=null;
	private Element root; 
	
	private Integerreference ID=0;
	private HasMap<Object, Integer> referenceMap = new HashMap<Object, Integer>();
	
	
	private int currentElement=0;
	private Object[] serializedObjects;
	public Serializer()
	{		
	}

	public Document serialize(Object object)
	{
		if(object==null)
		{
			
		}
		else if(!serializedObjects.contains(object))
		{
			seralizedObjec.add(object);
			
			if(currentElement++ ==0)
			{
				doc=new Document();
				root=new Element("Serialized");
				doc.setRootElement(root);
			}
			
			Class c = object.getClass();
			integer id = getID(object);
			
			Element objectElement= new Element("object");
			objectElement.setAttribute(new Attribute("class", c.getname()));
			objectElement.setAttribute(new Attribute("id", id.toString()));
			doc.getRootElement().getContent.(objectElemennt);
			if(c.isArray())
			{
				Object array = object;
				objectElement.setAttribute(new Attribute("length", Integer.toString(Array.getLength(array))));
				if(c.getComponentType().isPrimitive()==true)
				{
					for(int j=0; j<Array.getLength(array); j++)
					{
						Element value= new Element("value");
						value.setText();
						objectElement.addContent();
					}
				}
				else
				{
					for(int j=0; j<Array.getLength(array); j++)
					{
						Element ref= new Element("reference");
						id=getID(Array, j);
						
						if(id!= -1)
						{
							ref.setText();
							objectElement.addContent();
						}
						
					}
					for(int j=0; j<Array.getLength(array); j++)
					{
						serialize(Array.get(array, j));
					}
				}
			}
			else
			{
				Class tmpClass = c; 
				while (tmpClas != null)
				{
					Field[] fields= tmpClass.getDeclaredFields();
					Element[] fieldXML= serializeFields(fields, object);
					for(int i=0; i<fieldXML.length(); i++)
					{
						objectElement.addContent(fieldXML[i]);
					}
					tmpClass= tmpClass.getSuperClass();
				}
			}
		}
		return doc;
	}
	
	private Element[] serializedFields(Fields[] fields, Object object)
	{
		Element[] elements = new Element[field.length()];
		for (int j=0; j<fields.length(); j++)
		{
			try
			{
				if(!field.isAccessible())
				{
					fields[j].setAccessable(true);
				}
				Element objectElement= new Element("field");
				if(fields[i].isPrimitive()==true)
				{
					objectElement.setAttribute(new Attribute("value", fields[i].getn()));
				}	
				objectElement.setAttribute(new Attribute("id", id.toString()));
				doc.getRootElement().getContent.(objectElemennt);
				elements[i]=fields[i];
			}
			catch(Exception e)
			{
				
			}
		}
		return elements;
	}
	
	private int getID(Object object)
	{
		Integer id = referenceID;
		if(referenceMap.containsKey(object))
		{
			id=referenceMap.get(object);
		}
		else if(object==null)
		{
			id=-1;
		}
		else
		{
			referenceMap.put(object, id);
			referenceID++;
		}
		return id;
	}
}
