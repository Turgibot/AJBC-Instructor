package ajbc.dependencyInversion.ebook.before;

public class MobileBook implements EBook{

	@Override
	public String read() {
		return "Reading a Mobile Book...";
	}

}
