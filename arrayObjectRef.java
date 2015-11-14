import java.lang.reflect.*;
import java.util.*;

public class arrayObjectRef
{
	private Scanner darkly=new Scanner(System.in);
	public simpleObject[] array;
	
	public arrayObjectRef(int size)
	{
			array = new simpleObject[size];
	}

	public void create(int size)
	{
		for (int i=0; i<size; i++)
		{
			System.out.println("please enter a value for the field: ");
			int b = darkly.nextInt();
			System.out.println("please enter another value for the field: ");
			int c = darkly.nextInt();
			simpleObject name = new simpleObject();
			name.field1=b;
			name.field2=c;
			array[i]=name;
		}
	}
}
