package ajbc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Create {

	public static void run() {
		try {
			// root element
			Element carsElement = new Element("cars");
			Document doc = new Document(carsElement);

			// supercars element
			Element supercarElement = new Element("supercars");
			supercarElement.setAttribute(new Attribute("company", "Ferrari"));

			// supercar element
			Element carElement1 = new Element("carname");
			carElement1.setAttribute(new Attribute("type", "formula one"));
			carElement1.setText("Ferrari 101");

			Element carElement2 = new Element("carname");
			carElement2.setAttribute(new Attribute("type", "sports"));
			carElement2.setText("Ferrari 202");

			supercarElement.addContent(carElement1);
			supercarElement.addContent(carElement2);

			doc.getRootElement().addContent(supercarElement);
			Element ele = new Element("Guy");
			ele.addContent("Tordjman");
			doc.getRootElement().addContent(ele);
			
			XMLOutputter xmlOutput = new XMLOutputter();

			// display format
			xmlOutput.setFormat(Format.getPrettyFormat());
			// save to a file
			File outputFile = new File("myFiles/cars3.xml");
			OutputStream outputStream = new FileOutputStream(outputFile);
			xmlOutput.output(doc, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
