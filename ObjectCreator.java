import java.util.*;

public class ObjectCreator
{
	private String clName;
	Scanner darkly = new Scanner(System.in);
	Serializer forSerial= new Serializer;
	
	public void ObjectCreator()
	{
		System.out.println("Please enter the name of the class you would like to use: ");
		clName=darkly.nextLine();
		Class mainClass=Class.forName(clName);
		System.out.println("what would you like to do?\n 1)create a simple object\n 2)create a collection of Objects\n 3) disconnect\n 4) object refrencing another object\n5) an object with an array of primitives\n6) an object with an array of object refrences");
		String userInput=darkly.nextLine();
		forSerial.serialize(userInput, mainClass)
	}
	
	public Object CreateObject(String userInput, Class className)
	{
		Object object = null;
		if(userInput.toInteger()==1)
		{
			object= createSimpleObject(className);
		}
		else if (userInput.toInteger()==2)
		{
			object=createObjectCollectionObject();
			break;
		}
		else if (userInput.toInteger()==3)
		{
			Sender.connected=false;
			break;
		}
		/*else if (userInput.toInteger()==4)
		{
			object=createObjectRefrenceObject();
			break;
		}
		else if (userInput.toInteger()==5)
		{
			object=createObjectArrayPrimitive();
			break;
		}
		else if (userInput.toInteger()==6)
		{
			object=createObjectArrayObject();
			break;
		}
		return object;
	}*/
	
	private Object createSimpleObject(Object object)
	{
		Class className=object.getDeclaringClass();
		Field[] fields= className.getDeclaredFields();
		for(int i=0; i<fields.length(); i++)
		{
			if(!fields[i].isAccessible())
			{
				fields[i].setAccessible(true);
			}
			if(fields.getType.isPrimitive())
			{
				if(fields[i].getType().getSimpleName() == "Integer")
				{
					int fieldType=darkly.nextInt();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "String")
				{
					String fieldType=darkly.nextLine();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Byte")
				{
					byte fieldType=darkly.nextByte();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Boolean")
				{
					boolean fieldType=darkly.nextLine();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Short")
				{
					short fieldType=darkly.nextShort();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Long")
				{
					long fieldType=darkly.nextLong();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Float")
				{
					float fieldType=darkly.nextFloat();
					fields[i].set(object, fieldType);
				}
				else if(fields[i].getType().getSimpleName() == "Double")
				{
					double fieldType=darkly.nextDouble();
					fields[i].set(object, fieldType);
				}
			}
		}
		//return object
	}
	
	private ObjectCollectionObject createObjectsCollectionObject(Object object)
	{
		
		System.out.println("how large would you like the collection of objects to be?");
		int collectionSize= darkly.nextLine().toInteger();
		Object[] list = new Object[collectionSize];
		for (int i=0; i< collectionSize; i++)
		{
			list[i]=createObject();
		}
		//return Object;
	}
}