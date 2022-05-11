package ajbc.patterns.singleton.exercise;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GameManager {

	private List<Player> players;
	private PackOfCards pack;
	
	public GameManager(List<Player> players) {
		this.players = players;
		pack = PackOfCards.getInstance();
	}


	public void play() {
		int i = 1;
		while(!pack.getCards().isEmpty()) {
			playRound();
			showRound(i);
			i++;
		}
		showWinner();
	}


	private void showWinner() {
		System.out.println("\n******----------And The winner is ---------*****");
		Player maxPlayer = Collections.max(players, (p1, p2)->p1.getPoints()-p2.getPoints());
		System.out.println(maxPlayer);
	}


	private void showRound(int i) {
		System.out.println("----------Round %d ---------".formatted(i));
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
	}


	private void playRound() {
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player currPlayer =  iterator.next();
			currPlayer.getACard();
		}
		Player maxPlayer = Collections.max(players, (p1, p2)->p1.getCurrCard()-p2.getCurrCard());
		maxPlayer.addPoint();
	}
	
	
}
