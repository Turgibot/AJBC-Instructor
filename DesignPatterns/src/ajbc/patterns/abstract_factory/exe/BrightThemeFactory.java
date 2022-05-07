package ajbc.patterns.abstract_factory.exe;

public class BrightThemeFactory extends ThemeFactory {

	@Override
	public Text createText() {
		return new DarkText();
	}

	@Override
	public Resolution createResolution() {
		return new SDResolution();
	}

}
