

public class Visualizer
{
	public void visualize(Object obj, boolean recursive)
	{
		//note: boolean is initialized as true
		Class className=obj.getClass();
		System.out.print ("\nClass name: ");
		output(className);
		System.out.println("");
		
		Class[] temp;
		if (obj.isArray())
		{
			System.out.print("object is an array");
			if(obj[i].isPrimitive())
			{
				System.out.print(" of primitives: [");				
				for (int i=0; i<obj.length(); i++)
				{
					System.out.print(obj[i]);
					System.out.print(", ");
				}
				System.out.println("]");
			}
			else
			{
				System.out.print(" of refrences");
				if(recursive==true)
				{
					for (int i=0; i<obj.length();i++)
					{
						Class tmp= obj.getDeclaringClass();
						Object tmp2=tmp.getInstance();
						visualize(tmp2, recursive);
					}
				}
				else
				{
					System.out.print(" [");
					for (int i=0; i<obj.length(); i++)
					{
						System.out.print(obj[i]);
						System.out.print(", ");
					}
					System.out.println("]");
				}
			}
		}
		else
		{
			System.out.println("Fields");
			if(c.length==0)
			{
				System.out.println("		none");
			}
			else
			{
				for (int i=0; i<c.length; i++)
				{
					System.out.print(i+1);
					System.out.print(")\n 	Field Name: ");
					String fieldName=c[i].toString();
					System.out.println(fieldName);
					//types
					Class fieldType=c[i].getType();
					System.out.print("		Field Type: ");
					output(fieldType);
					//value
					Object value=getvalue(c[i],e);
					System.out.print("		Field value: ");
					String fieldValName=String.valueOf(value);
					System.out.println(fieldValName);
					//modifiers	
					int modifiers=c[i].getModifiers();
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

}
