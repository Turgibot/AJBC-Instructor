package ajbc.dependencyInversion.ebook.before;

public class EBookReader {

	private EBook eBook;
	
	public EBookReader(EBook pdfBook) {
		this.eBook = pdfBook;
	}
	
//	public EBookReader() {
//		this.book = new PDFBook();
//	}

	public String read() {
		return eBook.read();
	}
	
}
