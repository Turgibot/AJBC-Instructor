package ajbc.patterns.mvc;

public class Runner {
	public static void main(String[] args) {

		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		CalculatorController controller = new CalculatorController(model, view);
		controller.startApp();
	}
}
