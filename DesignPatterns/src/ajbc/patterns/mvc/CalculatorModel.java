package ajbc.patterns.mvc;

public class CalculatorModel {

	int answer;
	
	public void add(int firstNum, int secondNum) {
		answer = firstNum+secondNum;
	}

	public int getAnswer() {
		return answer;
	}
	
	

}
