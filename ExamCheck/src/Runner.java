
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		
		ArrayList<Tent> tents = new ArrayList<>(); 
		
		for(int i = 0; i < 11; i++) {
			tents.add(new Tent());
		}
		
		printTentList(tents);
		
		//1
		List<Tent> tentsSortedByArea = NewTentsListSortedByArea(tents);
		System.out.println("\nAfter sorting by area:");
		printTentList(tentsSortedByArea);
		
		//2
		List<Tent> tentsSortedAndFilteredByNumPeople = NewTentsListSortedAndFilteredByNumPeople(tents,15);
		System.out.println("\nAfter filtering numPeopele>=15 and sorting by numPeople:");
		printTentList(tentsSortedAndFilteredByNumPeople);
		
		//3
		Tent trueMax = new Tent(5, 6.0, 8.5, 10.0); //higher than all the tents in the list. expected result - 'true'.
		boolean isMaxHigher = isTentHighest(trueMax, tents); 
		System.out.println("\nmax is higher than all the tents in the list. the answer: " + isMaxHigher);
		Tent falseMax = new Tent(5, 6.0, 8.5, 0.5); //shorter than all the tents in the list. expected result - 'false'.
		isMaxHigher = isTentHighest(falseMax, tents); 
		System.out.println("max is higher than all the tents in the list. the answer: " + isMaxHigher);
		
		//4
		ArrayList<Tent> tents2 = new ArrayList<>();
		tents2.add(new Tent(5, 3.0, 3.1, 4.5));
		tents2.add(new Tent(7, 3.0, 3.2, 4.5));
		tents2.add(new Tent(8, 3.0, 3.7, 4.5));
		tents2.add(new Tent(9, 3.0, 7.2, 8.9));
		tents2.add(new Tent(10, 5.0, 7.2, 8.9));
		tents2.add(new Tent(15, 5.0, 9.7, 2.7));
		tents2.add(new Tent(16, 9.0, 9.7, 4.5));
		tents2.add(new Tent(17, 9.0, 8.5, 2.7));
		tents2.add(new Tent(18, 8.5, 4.8, 2.7));
		tents2.add(new Tent(5, 7.3, 11.3, 2.7));	
		
		Map<Double, LinkedList<Tent>> listToMapByHeight = listToMapByHeight(tents2);
		System.out.println("\nthe map by height: " + listToMapByHeight);
		
	}
	
	public static List<Tent> NewTentsListSortedByArea(ArrayList<Tent> tents) {
		List<Tent> newSortedList = tents; 
		newSortedList = tents.stream()
				.sorted(Comparator.comparing((x)->x.width*x.length))
				.collect(Collectors.toList());
		return newSortedList;
	}
	
	public static List<Tent> NewTentsListSortedAndFilteredByNumPeople(ArrayList<Tent> tents, int num) {
		List<Tent> newList = tents; 
		newList = tents.stream().filter((x) -> x.numPeople >= num)
				.sorted(Comparator.comparing((x) -> x.numPeople))
				.collect(Collectors.toList());
		return newList;
	}
	
	public static void printTentList(List<Tent> tents) {
		Iterator<Tent> tentsIterator = tents.iterator();
		Tent currTent; 
		while(tentsIterator.hasNext()) {
			currTent = tentsIterator.next();
			System.out.println(currTent);
		}
	}
	
	public static boolean isTentHighest(Tent max, ArrayList<Tent> tents) {
		Iterator<Tent> tentsIterator = tents.iterator();
		Tent currTent; 
		while(tentsIterator.hasNext()) {
			currTent = tentsIterator.next();
			if(currTent.height > max.height)
				return false;
		}
		return true; 
	}
	
	public static Map<Double, LinkedList<Tent>> listToMapByHeight(ArrayList<Tent> tents){
		Map<Double, LinkedList<Tent>> tentsMapping = new HashMap<>(); 
		Iterator<Tent> tentsIterator = tents.iterator();
		Tent currTent; 
		while(tentsIterator.hasNext()) {
			currTent = tentsIterator.next();
			if(tentsMapping.containsKey(currTent.height))
				tentsMapping.get(currTent.height).add(currTent);
			else {
				LinkedList<Tent> newListOfTentsInHeight = new LinkedList<Tent>();
				newListOfTentsInHeight.add(currTent);
				tentsMapping.put(currTent.height, newListOfTentsInHeight);
			}
		}
		
		return tentsMapping;
	}

}