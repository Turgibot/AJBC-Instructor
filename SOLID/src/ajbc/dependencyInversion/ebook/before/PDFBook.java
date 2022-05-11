package ajbc.dependencyInversion.ebook.before;

public class PDFBook implements EBook{

	int numPages;
	
	@Override
	public String read() {
		return "Reading a PDF Book...";
	}

	public PDFBook(int numPages) {
		this.numPages = numPages;
	}
	
	
}
