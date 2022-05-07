package ajbc.patterns.adapter;

public class Runner {
	 public static void main(String[] args) {
	        // Round fits round, no surprise.
		 	double size1 = 2;
	        RoundHole hole = new RoundHole(size1);
	        RoundPeg rpeg = new RoundPeg(size1);
	        if (hole.fits(rpeg)) {
	            System.out.println("Round peg r2 fits round hole r2.");
	        }
	        double size2 = 20;
	        SquarePeg smallSqPeg = new SquarePeg(size1);
	        SquarePeg largeSqPeg = new SquarePeg(size2);
	        // hole.fits(smallSqPeg); // Won't compile.

	        // Adapter solves the problem.
	        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
	        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
	        if (hole.fits(smallSqPegAdapter)) {
	            System.out.println("Square peg w2 fits round hole r2.");
	        }
	        if (!hole.fits(largeSqPegAdapter)) {
	            System.out.println("Square peg w20 does not fit into round hole r2.");
	        }
	    }
}
