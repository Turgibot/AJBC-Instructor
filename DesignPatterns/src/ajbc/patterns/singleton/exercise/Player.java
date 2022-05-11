package ajbc.patterns.singleton.exercise;

import java.util.Collections;

public class Player {

	private int currCard;
	private PackOfCards pack;
	private String name;
	private int points;
	
	public Player(String name) {
		this.pack = PackOfCards.getInstance();
		this.name = name;
	}
	
	public void getACard() {
		Collections.shuffle(pack.getCards());
		currCard = pack.getCards().remove(0);
	}

	public int getPoints() {
		return points;
	}


	public int getCurrCard() {
		return currCard;
	}

	public void addPoint() {
		points++;
	}

	@Override
	public String toString() {
		return "Player name = " + name + " [currCard=" + currCard +  ", points=" + points + "]";
	}
	
	
	
}
