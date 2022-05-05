package ajbc.patterens.factory.method;

public class HtmlDialog extends Dialog {

	@Override
	public Button createButton() {
		return new HtmlButton();
	}

}
