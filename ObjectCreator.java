import java.util.*;

public class ObjectCreator
{
	public ObjectCreator()
	{}
	
	public Object CreateObject()
	{
		//textbased menu and user input
		System.out.println("what would youlike to do?\n 1)create a simple object\n 2)create a collection of Objects");
		Scanner darkly = new Scanner(System.in);
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