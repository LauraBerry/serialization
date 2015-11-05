import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;

public class CreateNewXMLFile
{

	public static void main(String[] args)
	{
		try
		{
			Element company= new Element("company"); //note: this is the root element 
			Document doc = new Document();
			doc.setRootElement(company);
			
			System.out.println (doc.getRootElement());
			
			Element staff= new Element ("staff");
			staff.setAttribute(new Attribute("id","1"));
			staff.addContent(new Element("firstname").setText("ryan"));
			staff.addContent(new Element("lastname").setText("eggold"));
			staff.addContent(new Element("salary").setText("199999"));
			
			doc.getRootElement().addContent(staff);
			
			Element staff2=new Element("staff");
			staff2.setAttribute(new Attribute("id", "2"));
			staff2.addContent(new Element("firstname").setText("megan"));
			staff2.addContent(new Element("lastname").setText("boone"));
			staff2.addContent(new Element("salary").setText("199999"));
			
			XMLOutputter xmlOutput= new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			//xmlOutput.output(doc, System.out);
			
			xmlOutput.output(doc, new FileWriter("newxmlfile.xml"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}