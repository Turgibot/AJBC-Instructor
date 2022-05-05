package ajbc.patterens.factory.method;

public abstract class Dialog {
	public void renderWindow() {
        // ... other code ... do something important

        Button button = createButton();
        button.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
