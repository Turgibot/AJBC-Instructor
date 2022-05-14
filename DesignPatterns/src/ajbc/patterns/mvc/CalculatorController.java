package ajbc.patterns.mvc;

public class CalculatorController extends CalculatorView {
	
	private CalculatorModel model;
	private CalculatorView view;
	
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model= model;
		this.view = view;
	}

	public void startApp() {
		int firstNum = view.getFirstNum();
		int secondNum = view.getSecondNum();
		
		model.add(firstNum, secondNum);
		int answer = model.getAnswer();
		
		view.showAnswer(answer);
	}
}
