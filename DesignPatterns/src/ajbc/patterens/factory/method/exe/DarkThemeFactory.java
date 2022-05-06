package ajbc.patterens.factory.method.exe;

public class DarkThemeFactory extends ThemeFactory {

	@Override
	public Text createText() {
		return new BrightText();
	}

}
