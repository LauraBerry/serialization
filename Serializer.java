import java.lang.reflect.*;
import java.util.*;;
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
	
	public Document serialize(Object object)
	{
		if(object == null)
		{
			
		}
		else if(!serializedObjects.contains(object))
		{
			String mapSaize= Integer.toString(map.size());
			serializedObjects.add(object);
			
			if(currentElement++ == 0)
			{
				doc = new Document();
				root = new Element("serialized");
				doc.setRootElement(root);
			}
			Class c = object.getClass();
			Integer id = getID(object);
			map.put(object, id)
			Element objectElement = new Element("object");
			objectElement.setAttribute(new Attribute("class", c.getName()));
			objectElement.setAttribute(new Attribute("id", id.toString()));
			doc.getRootElement().addContent(objectElement);

			if(c.isArray())
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
					for(int j = 0;j < Array.getLength(array);j++)
					{
						Element ref = new Element("reference");
						id = getID(Array.get(c,j));
						if(id != -1)
						{
							ref.setText(Array.get(array, j);						// add each array element
						}
					}
					for(int k = 0;k<Array.getLength(array);k++)
					{
						serialize(Array.get(array,k));
					}
				}
			}
			else
			{
				Class tmpClass = c;
				while(tmpClass != null)
				{
					Field[] fields = tmpClass.getDeclaredFields();
					ArrayList<Element> fieldXML = serializeFields(fields, object);
					for(Element element:fieldXML)
						objectElement.addContent(element);
					
					tmpClass = tmpClass.getSuperclass();
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

	private ArrayList<Element> serializeFields(Field[] fields, Object object)
	{
		Class currentClass=object.getClass();
		ArrayList<Element> elements = new ArrayList<Element>();
		for(Field f : fields)
		{
			try
			{
				if(!f.isAccessible())
				{
					f.setAccessible(true);
				}
				//recursion if the Field is not primitive
				if(!f.isPrimitive())
				{
					Class fieldClass= f.getDeclaingClass();
					if (fieldClass==currentClass)
					{
						continue;
					}
					else
					{
						Object obj= fieldClass.newInstance();
						serialize(obj);
					}
				}
				
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
			id = referenceMap.get(object);
		else
		{
			referenceMap.put(object, id);
			referenceID++;
		}
		
		return id;
	}

}
