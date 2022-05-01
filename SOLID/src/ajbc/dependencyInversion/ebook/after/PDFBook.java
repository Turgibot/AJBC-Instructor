package ajbc.dependencyInversion.ebook.after;

public class PDFBook implements EBook {

	public String read() {
		return "Reading a PDF Book...";
	}

}
