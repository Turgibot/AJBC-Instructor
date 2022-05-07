package ajbc.patterns.abstract_factory.exe;

public class DarkThemeFactory extends ThemeFactory {

	@Override
	public Text createText() {
		return new BrightText();
	}

	@Override
	public Resolution createResolution() {
		return new HDResolution();
	}

}
