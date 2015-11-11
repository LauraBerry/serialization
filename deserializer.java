import java.lang.*;
import java.jdom2.*;
import java.util.*;

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
				setArray(obj, tmpClass, objectElement); 
			}
			else
			{
				List<Element> fieldElements=objectElement.getChildren("fields");
				for(Element fieldElement: fieldElements)
				{
					setField(obj, tmpClass, fieldElement);
				}
			}
		}
	}
	
	public void setArray(Object obj, Class tmpClass, Element fieldElement)
	{
		//DO A THING
	}
	
	public void setField(Object obj, Class tmpClass, Element fieldElement)
	{
		//DO A THING
	}
}