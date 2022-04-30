package bootcamp.collections.examples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandidatesSorterDemo {
	public static void run() {

		// -------------------------------------------------------------------//
		// sorting a List using its natural order - the comparable interface must be
		// implemented in candidate class
		// -------------------------------------------------------------------//

		List<Candidate> Candidates = new ArrayList<>();

		Candidates.add(new Candidate(1010, "Michael", 100000.00, LocalDate.of(2010, 7, 10)));
		Candidates.add(new Candidate(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		Candidates.add(new Candidate(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));

		System.out.println("Candidates (Before Sorting) : " + Candidates);

		// This will use the `compareTo()` method of the `Candidate` class to compare two
		// Candidates and sort them.
		Collections.sort(Candidates);

		System.out.println("\nCandidates (After Sorting) : " + Candidates);

		// -------------------------------------------------------------------//
		// sorting a List using different comparators
		// -------------------------------------------------------------------//
		
		Candidates = new ArrayList<>();

        Candidates.add(new Candidate(1010, "Michael", 100000.00, LocalDate.of(2010, 7, 10)));
        Candidates.add(new Candidate(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        Candidates.add(new Candidate(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        Candidates.add(new Candidate(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

        System.out.println("Candidates : " + Candidates);

        // Sort Candidates by Name
        Comparator<Candidate> CandidateNameComparator = new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                return c1.getName().compareTo(c2.getName());
            }
        };

        /*
        The above Comparator can also be written using lambda expression like so =>
        CandidateNameComparator = (c1, c2) -> c1.getName().compareTo(c2.getName());

        Which can be shortened even further using Java 8 Comparator default method
        CandidateNameComparator = Comparator.comparing(Candidate::getName)
        */

        Collections.sort(Candidates, CandidateNameComparator);
        System.out.println("\nCandidates (Sorted by Name) : " + Candidates);

        // Sort Candidates by Salary
        Comparator<Candidate> CandidatesalaryComparator = new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                if(c1.getSalary() < c2.getSalary()) {
                    return -1;
                } else if (c1.getSalary() > c2.getSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        
        Collections.sort(Candidates, CandidatesalaryComparator);
        System.out.println("\nCandidates (Sorted by Salary) : " + Candidates);

        // Sort Candidates by JoiningDate
        Comparator<Candidate> CandidateJoiningDateComparator = new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                return c1.getJoiningDate().compareTo(c2.getJoiningDate());
            }
        };

        Collections.sort(Candidates, CandidateJoiningDateComparator);
        System.out.println("\nCandidates (Sorted by JoiningDate) : " + Candidates);
		
		
	}
}
