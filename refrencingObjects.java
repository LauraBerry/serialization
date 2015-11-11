import java.util.*;

public class refrencingObjects()
{
	private Scanner darkly=new Scanner(System.in);
	public void create()
	{
		System.out.println("please enter a value for the field: ");
		int a = darkly.nextInt();
		System.out.println("please enter another value for the field: ");
		int b = darkly.nextInt();
		simpleObject name = new simpleObject();
		name.field1()=a;
		name.field2()=b;
	}
}