package assignment3;
import java.util.*;

public class arrayPrimitive
{
	private Scanner darkly=new Scanner(System.in);
	public void create(int a)
	{
		
		System.out.println("what type would you like the array to be?");
		String answer=darkly.nextLine();
		if(answer.equalsIgnoreCase("Int")||answer.equalsIgnoreCase("Integer"))
		{
			int[] array = new int[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextInt();
			}	
		}
		else if(answer.equalsIgnoreCase("Double"))
		{
			double[] array = new double[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextDouble();
			}	
		}
		else if(answer.equalsIgnoreCase("boolean")||answer.equalsIgnoreCase("bool"))
		{
			boolean [] array = new boolean[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextBoolean();
			}	
		}
		else if(answer.equalsIgnoreCase("string"))
		{
			String[] array = new String[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextLine();
			}	
		}
		else if (answer.equalsIgnoreCase("float"))
		{
			float[] array = new float[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextFloat();
			}	
		}
		else if (answer.equalsIgnoreCase("long"))
		{
			long[] array = new long[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextLong();
			}	
		}
		else if (answer.equalsIgnoreCase("short"))
		{
			short[] array = new short[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextShort();
			}	
		}
		else if (answer.equalsIgnoreCase("byte"))
		{
			byte[] array = new byte[a];
			for(int i=0; i<(a+1); i++)							//a+1 because i'm assuming the user doesn't know arrays are zero indexed
			{
				System.out.println("what would you like this element of the array to be? ");
				array[i]=darkly.nextByte();
			}	
		}
		else
		{
			System.out.println("that is not a valid type. please use: int, float, double, boolean, short, long or byte");
			create(a);
		}
	}
}
