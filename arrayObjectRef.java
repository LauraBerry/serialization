import java.lang.reflect.*;
import java.util.*;

public class arrayObjectRef()
{
	private Scanner darkly=new Scanner(System.in);
	public void create(int a)
	{
		public simpleObject[] array = new simpleObject[a];
		for (int i=0; i<(a+1); i++)
		{
			System.out.println("please enter a value for the field: ");
			int b = darkly.nextInt();
			System.out.println("please enter another value for the field: ");
			int c = darkly.nextInt();
			 simpleObject name= new simpleObject();
			name.field1=b;
			name.field2=c;
			 array[i]=name;
		}
	}
}
