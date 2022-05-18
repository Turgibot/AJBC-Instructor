package src;

public class NonCapitalizedException extends Exception {
	
	public NonCapitalizedException()
	{
		super("Food name must start with a capital letter");
	}

}
