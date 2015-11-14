import java.lang.reflect.*;
import java.lang.Class;
import java.util.*;

public class ObjectCreator
{
	private String className;
	private Scanner darkly;
	private Class clName = null;

	public ObjectCreator()
	{
		darkly = new Scanner(System.in);
		System.out.println("what would you like to do?");
		System.out.println("\t1) create an object");
		System.out.println("\t2) object refrencing another object");
		System.out.println("\t3) object that contains an array of primities");
		System.out.println("\t4) object containing an array of object refrences");
		System.out.println("\t5) object collect");
		System.out.println("\t6) disconnect");
		
		int decision= darkly.nextInt();
		if(decision==1)
		{
			simpleObject obj= createSimpleObject();	
		}
		else if(decision==2)
		{
			refrencingObjects obj = objectRefrenceObject();
		}
		else if(decision==3)
		{
			arrayPrimitive obj=arrayObjectPrimitive();
		}
		else if(decision==4)
		{
			arrayObjectRef obj = arrayObjectRefs();
		}
		else if (decision==5)
		{
			System.out.println("create object collection");
		}
		else if (decision==6)
		{
			System.out.println("disconnecting");
			Sender.connected=false;
		}
	}
	
	public Object createObject()
	{	
		Object object = null;
		try
		{
			clName = Class.forName(className);
			object = clName.newInstance();
			object = setFields(object);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return object;
	}
	
	private Object setFields(Object obj)
	{
		Field[] fields = clName.getDeclaredFields();
		for(int f=0;f<fields.length;f++)
		{
			if (!fields[f].isAccessible()) {
				fields[f].setAccessible(true); }
			if(fields[f].getType().isPrimitive())
			{
				Object fieldType = fields[f].getType();
				System.out.print("Set the value of the "+fields[f].getType().getSimpleName()+" named "+fields[f].getName()+" : ");
				try
				{
				if(fields[f].getType().getSimpleName() == "Integer") {
					int value = darkly.nextInt();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "String") {
					String value = darkly.nextLine();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Boolean") {
					boolean value = darkly.nextBoolean();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Double") {
					double value = darkly.nextDouble();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Float") {
					float value = darkly.nextFloat();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Long") {
					long value = darkly.nextLong();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Short") {
					short value = darkly.nextShort();
					fields[f].set(obj,value); }
				else if(fields[f].getType().getSimpleName() == "Byte") {
					byte value = darkly.nextByte();
					fields[f].set(obj,value); }
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return obj;
	}

	private simpleObject createSimpleObject()
	{
		System.out.println("please enter a value for the field: ");
		int a = darkly.nextInt();
		System.out.println("please enter another value for the field: ");
		int b = darkly.nextInt();
		simpleObject name = new simpleObject();
		name.field1=a;
		name.field2=b;
		return name;
	}
	
	private refrencingObjects objectRefrenceObject()
	{
		refrencingObjects jerry = new refrencingObjects(); 
		jerry.create();
		return jerry;
	}
	
	private arrayPrimitive arrayObjectPrimitive()
	{
		System.out.println("how big would you like the array to be?");
		int a = darkly.nextInt();
		arrayPrimitive name = new arrayPrimitive(a);
		name.create(a);
		return name;
	}
	
	private arrayObjectRef arrayObjectRefs()
	{
		System.out.println("how big would you like the array to be?");
		int a = darkly.nextInt();
		arrayObjectRef name = new arrayObjectRef(a);
		name.create(a);
		return name;
	}
	
	/*private ObjectCollectionsObject createObjectsCollectionObject()
	{
		System.out.println("how big would you like the collection to be?");
		Vector<Object> list = new Vecotr<Object>();
		
		int collectionSize = darkly.nextInt();
		
		for(int i = 0; i < collectionSize; i++)
		{
			System.out.println("please enter a value for the field: ");
			int a = darkly.nextInt();
			System.out.println("please enter another value for the field: ");
			int b = darkly.nextInt();
			list.add(simpleObject(a,b));
		}
		
		return new ObjectCollectionObject(list);
	} */
}
