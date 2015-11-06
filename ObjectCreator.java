import java.util.*;

public class ObjectCreator
{
	Scanner darkly = new Scanner(System.in);
	public ObjectCreator()
	{}
	
	public Object CreateObject()
	{
		System.out.println("what would youlike to do?\n 1)create a simple object\n 2)create a collection of Objects\n 3) disconnect");
		String userInput=darkly.nextLine();
		Object object = null;
		if(userInput.toInteger()==1)
		{
			object= createSimpleObject();
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
		return object;
	}
	
	private simpleObject createSimpleObject()
	{
		System.out.println("enter value for field")
		int a=darkly.nextLine().toInteger();
		System.out.println("enter a value for ___");
		int b = darkly.nextLine().toInteger();
		return SimpleObject(a,b);
	}
	
	private ObjectCollectionObject create ObjectsCollectionObject(Object object)
	{
		
		System.out.println("how large would you like the collection of objects to be?");
		int collectionSize= darkly.nextLine().toInteger();
		Object[] list = new Object[collectionSize];
		for (int i=0; i< collectionSize; i++)
		{
			list[i]=createObject();
		}
		return new ObjectsCollectionObject(list);
	}
}