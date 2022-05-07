package ajbc.patterns.abstract_factory.exe;

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Text text;
    private Resolution resolution;

    public Application(ThemeFactory factory) {
        text = factory.createText();
        resolution = factory.createResolution();
    }

    public void start() {
        text.render();
        resolution.init();
    }
}