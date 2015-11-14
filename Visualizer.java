package assignment3;
import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;

public class Visualizer
{
	public void visualize(Object obj, boolean recursive)
	{
		//note: boolean is initialized as true
		Class c=obj.getClass();
		System.out.print ("\nClass name: ");
		output(c);
		System.out.println("");
		
		Class[] temp;
		if (c.isArray())
		{
			int arraySize= Array.getLength(obj);
			System.out.print("object is an array");
			if(c.isPrimitive())
			{
				System.out.print(" of primitives: [");				
				for (int i=0; i<arraySize; i++)
				{
					System.out.print(Array.get(obj, i));
					System.out.print(", ");
				}
				System.out.println("]");
			}
			else
			{
				System.out.print(" of refrences");
				if(recursive==true)
				{
					for (int i=0; i<arraySize;i++)
					{
						Class tmp= obj.getClass();
						Object tmp2=tmp.newInstance();
						visualize(tmp2, recursive);
					}
				}
				else
				{
					System.out.print(" [");
					for (int i=0; i<arraySize; i++)
					{
						System.out.print(Array.get(c,i));
						System.out.print(", ");
					}
					System.out.println("]");
				}
			}
		}
		else
		{
			System.out.println("Fields");
			Field[] f=c.getDeclaredFields();
			if(Array.getLength(f)==0)
			{
				System.out.println("		none");
			}
			else
			{
				for(int i=0; i<Array.getLength(f); i++)
				{
					System.out.print(i+1);
					System.out.print(")\n 	Field Name: ");
					String fieldName=f[i].toString();
					System.out.println(fieldName);
					//types
					Class fieldType=f[i].getType();
					System.out.print("		Field Type: ");
					output(fieldType);
					//value
					Object value=f[i].get(obj);
					System.out.print("		Field value: ");
					String fieldValName=String.valueOf(value);
					System.out.println(fieldValName);
					//modifiers	
					int modifiers=f[i].getModifiers();
					System.out.print("		Modifier: ");
					String mods = Modifier.toString(modifiers);
					System.out.println(mods);
					if(recursive==true)
					{
						if(value.getClass()!=null)
						{
							Class newClass=value.getClass();
							visualize(newClass, recursive);
						}
					}
				}
			}
		}
		
	}
	public void output(Class a)
	{
		if(a==null)
		{
			System.out.println("none");
		}
		else
		{
			String output= a.getName();
			System.out.println(output);
		}
		return;
	}

}
