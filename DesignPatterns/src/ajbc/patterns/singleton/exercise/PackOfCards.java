package ajbc.patterns.singleton.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PackOfCards {
	
	private static final int NUM_CARDS = 60;
	private List<Integer> cards;
	private static PackOfCards instance = null;

	public static PackOfCards getInstance() {

		if (instance == null) {
			instance = new PackOfCards();
		}
		return instance;
	}

	private PackOfCards() {
		cards = new ArrayList<>();
		for (int i = 1; i <= NUM_CARDS; i++) {
			cards.add(i);
		}
	}

	public List<Integer> getCards() {
		return cards;
	}
	
	
}
