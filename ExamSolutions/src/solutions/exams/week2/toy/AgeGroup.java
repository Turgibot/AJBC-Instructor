package solutions.exams.week2.toy;

public enum AgeGroup {
	A(0, 1), B(2, 4), C(5, 10), D(10, 120);

	int min, max;

	AgeGroup(int min, int max) {
		this.min = min;
		this.max = max;
	}

	static AgeGroup getGroupByAge(long age) {
		if (age < A.max)
			return A;
		else if (age < B.max)
			return B;
		else if (age < C.max)
			return C;
		return D;
	}
}
