package ajbc.patterns.factory.method.exe;

public abstract class ThemeFactory {
	public void renderWindow() {
        // ... other code ... do something important

        Text text = createText();
        text.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Text createText();
}
