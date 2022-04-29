package ajbc.examples.custom.checked;

public class MissingNameException extends Exception {

	private String name;

	public MissingNameException() {
		super();
		this.name = "Name was not passed as argument";
	}

	public MissingNameException(String name) {
		super();
		this.name = name;
	}

	public MissingNameException(String message, String name) {
		super(message + " - Given name: " + name);
		this.name = name;
	}

	public MissingNameException(String message, Throwable cause, String name) {
		super(message + " - Given name: " + name, cause);
		this.name = name;
	}

	public MissingNameException(Throwable cause, String name) {
		super(cause);
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
