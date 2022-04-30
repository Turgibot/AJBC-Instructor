package bootcamp.collections.examples;

import java.util.ArrayList;

public class ExerciseSolution {
//	public static void main (String[] args) {
//        ArrayList<Integer> input = range(1, 10);
//        ArrayList<Integer> doubled = double_each(input);
//        ArrayList<Integer> complexified = complexify_each(input);
//        System.out.println(input);
//        System.out.println(doubled);
//        System.out.println(complexified);
//    }

    public static ArrayList<Integer> double_each(ArrayList<Integer> inlist) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i : inlist) {
            out.add(i*2);
        }
        return out;
    }

    public static ArrayList<Integer> complexify_each(ArrayList<Integer> inlist) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i : inlist) {
            out.add(complexify(i));
        }
        return out;
    }

    public static int complexify(int x) {
        return x * 4 + 3;
    }

    public static ArrayList<Integer> range(int start, int end) {
        ArrayList<Integer> k = new ArrayList<Integer>();

        for (int i=start; i<end; i++) {
            k.add(i);
        }

        return k;
    }
}
