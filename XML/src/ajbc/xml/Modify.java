package ajbc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Modify {

	public static void run() {
		try {
			File inputFile = new File("myFiles/cars2.xml");
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);
			Element rootElement = document.getRootElement();

			// get first supercar
			Element supercarElement = rootElement.getChild("supercars");

			// update supercar attribute
			Attribute attribute = supercarElement.getAttribute("company");
			attribute.setValue("Lamborigini");

			// loop the supercar child node
			List<Element> list = supercarElement.getChildren();

			for (int i = 0; i < list.size(); i++) {
				Element carElement = list.get(i);

				if ("Ferrari 101".equals(carElement.getText())) {
					carElement.setText("Lamborigini 001");
				}
				if ("Ferrari 202".equals(carElement.getText())) {
					carElement.setText("Lamborigini 002");
				}
			}

			// get all supercars element
			List<Element> supercarslist = rootElement.getChildren();

			for (int i = 0; i < supercarslist.size(); i++) {
				Element tempElement = supercarslist.get(i);

				if ("luxurycars".equals(tempElement.getName())) {
					rootElement.removeContent(tempElement);
				}
			}

			XMLOutputter xmlOutput = new XMLOutputter();

			// display xml
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			//overwrite file
			OutputStream outputStream = new FileOutputStream(inputFile);
			xmlOutput.output(document, outputStream);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
