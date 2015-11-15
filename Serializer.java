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
		Class c = object.getClass();
		Integer id = getID(object);
		map.put(object, id);
		String mapSize= Integer.toString(map.size());

		//creating serialization objects
		Element objectElement = new Element("object");
		objectElement.setAttribute(new Attribute("class", c.getName()));
		objectElement.setAttribute(new Attribute("id", mapSize));
		doc.getRootElement().addContent(objectElement);

		if(!c.isArray()) 																		//class is not an array
		{
			Field[] fields = c.getDeclaredFields();
			ArrayList<Element> fieldXML = serializeFields(fields, object, doc);
			for(int i=0; i<fieldXML.size(); i++)
			{
				objectElement.addContent(fieldXML.get(i));
			}
		}
		else 																					//class is an array
		{
			Object array = object;
			objectElement.setAttribute(new Attribute("length", Integer.toString(Array.getLength(array))));
			if(c.getComponentType().isPrimitive())												//class is array of primitives
			{
				for(int i = 0;i<Array.getLength(array);i++)
				{
					Element value = new Element("value");
					value.setText(Array.get(c,i).toString());
					objectElement.addContent(value);
				}
			}
			else 																				//class is array of references
			{
				for(int j = 0; j< Array.getLength(array); j++)
				{
					Element ref = new Element("reference");
					id = getID(Array.get(c,j));
					if(id != -1)
					{
						ref.setText(Integer.toString(id));
					}
				}
				for(int k = 0;k<Array.getLength(array);k++)
				{
					serialize(Array.get(array,k), doc);
				}
			}
		}
		if(currentElement == 0)
		{
			referenceID = 0;
		}
		
		return doc;
	}

 
	private ArrayList<Element> serializeFields(Field[] fields, Object object, Document doc)		//serializes the fields
	{
		Class currentClass=object.getClass();
		ArrayList<Element> elements = new ArrayList<Element>();
		for(Field f : fields)
		{
			try
			{
				if(!f.getType().isPrimitive())													// Field not primitive, is a reference to another object
				{															
				}
				else																			//field is primitive
				{
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
	

	private int getID(Object object)															//gets or sets object id for hash map
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
