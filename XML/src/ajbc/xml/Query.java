package ajbc.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Query {

	public static void run() {
		List<Student> students = new ArrayList<>();
		try {
			File inputFile = new File("myFiles/myStudents.xml");
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);
			System.out.println(document);
			System.out.println("Root element :" + document.getRootElement().getName());
			Element classElement = document.getRootElement();

			List<Element> studentList = classElement.getChildren();
			System.out.println("----------------------------");

			for (int i = 0; i < studentList.size(); i++) {
				Element student = studentList.get(i);
				System.out.println("Current Element name:" + student.getName());
				Student tmp = parseStudent(student);
				students.add(tmp);
				System.out.println(tmp);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	private static Student parseStudent(Element student) {

		Attribute attribute = student.getAttribute("rollNumber");
		long rollNumber = Long.parseLong(attribute.getValue());
		String firstName = student.getChild("firstname").getText();
		String lastName = student.getChild("lastname").getText();
		String nickName =  student.getChild("nickname").getText();
		int grade = Integer.parseInt(student.getChild("marks").getText());
		return new Student(rollNumber, firstName, lastName, nickName, grade);
	}
}
