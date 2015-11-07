import java.util.*;

public class ObjectCreator
{
	public ObjectCreator()
	{}
	
	public Object CreateObject()
	{
		//textbased menu and user input
		Object object = null;
		switch(selection)
		{
			case 0;
				Sender.connected=false;
				break;
			case 1;
				object= createSimpleObject();
			case 2;
			case 3;
			case 4;
			case 5;
				object=createObjectCollectionObject();
				break;
		}
		return object;
	}
	
	private simpleObject createSimpleObject()
	{
		int a = GUI.getIntInpur ("enter value for field \a" a"\")
		int b= .......................;
		
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