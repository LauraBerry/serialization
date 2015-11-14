package assignment3;
import java.util.*;

public class arrayPrimitive
{
	private Scanner darkly=new Scanner(System.in);
	public int[] array;
	public arrayPrimitive(int a)
	{
		array= new int[a];
	}

	public void create(int a)
	{
		for(int i=0; i<a; i++)
		{
			System.out.println("what would you like this element of the array to be? ");
			array[i]=darkly.nextInt();
		}	
	}
}
