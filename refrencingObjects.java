package assignment3;
import java.util.*;

public class refrencingObjects
{
	private Scanner darkly=new Scanner(System.in);
	public simpleObject sim_Obj;

	public refrencingObjects()
	{
		sim_Obj = new simpleObject();
	}
	public void create()
	{
		System.out.println("please enter a value for the field: ");
		int a = darkly.nextInt();
		System.out.println("please enter another value for the field: ");
		int b = darkly.nextInt();
		sim_Obj.field1=a;
		sim_Obj.field2=b;
	}
}
