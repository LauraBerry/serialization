import java.util.*;

public class ObjectCreator
{
	Scanner darkly = new Scanner(System.in);
	public ObjectCreator()
	{}
	
	public Object CreateObject()
	{
		//textbased menu and user input
		System.out.println("what would youlike to do?\n 1)create a simple object\n 2)create a collection of Objects");
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
		Sender.connected=false;
		break;
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
	
	private ObjectCollectionObject create ObjectsCollectionObject()
	{
		Vector<object> list = new Vector<object>();
		int collectionSize=GUI.getIntInput(......);
		
		for (int i=0; i< collectionSize; i++)
		{
			list.add(createObject());
		}
		return new ObjectsCollectionObject(list);
	}
}