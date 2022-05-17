package solutions.exams.week4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner {

	//1
	private static List<Tent> sortTentsByAreas(ArrayList<Tent> tents) {		
		return tents.stream().sorted(Comparator.comparing(tent -> tent.getLength() * tent.getWidth())).collect(Collectors.toList());
	}
	//2
	private static List<Tent> getTentsByNumOfPeople(ArrayList<Tent> tents, int num) {
		return tents.stream().filter(tent -> tent.getNumOfPeople() >= num).collect(Collectors.toList());
	}
	//3
	private static boolean isHighest(List<Tent> tents, Tent max) {
		return !tents.stream().anyMatch(t -> t.getHeight() > max.getHeight());
	}
	//4
	private static Map<Double, List<Tent>> getMapByHeights(ArrayList<Tent> tents) {
		return tents.stream().collect(Collectors.groupingBy(tent -> tent.getHeight()));
	}
	//5
	private static List<Tent> getTentsByHeights(Map<Double, List<Tent>> map, double maxHeight,
			double minHeight){
		List<Tent> c = map.values().stream().flatMap(x->x.stream())
				.filter(x->x.height>=minHeight&&x.height<=maxHeight)
				.collect(Collectors.toList());
		return c;
		
	}
}
