package ajbc.patterns.factory.method.exe;

public class BrightThemeFactory extends ThemeFactory {

	@Override
	public Text createText() {
		return new DarkText();
	}

}
