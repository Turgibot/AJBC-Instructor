package solutions.exams.week2.doll;

import java.time.LocalDate;

import solutions.exams.week2.kid.Kid;
import solutions.exams.week2.toy.AgeGroup;
import solutions.exams.week2.toy.Toy;

public class Doll extends Toy {

	private final int MIN_DIRT = 1;
	private final int MAX_DIRT = 10;
	private final int DIRT_CHANGE = 1;
	protected boolean isHard;
	protected int dirtLevel;

	public Doll(String name, LocalDate purchaseDate, AgeGroup ageGroup, Kid kid, boolean isHard, int dirtLevel) {
		super(name, purchaseDate, ageGroup, kid);
		setDirtLevel(dirtLevel);
		setHard(isHard);
	}

	private void setHard(boolean isHard) {
		this.isHard = isHard;
	}

	private void setDirtLevel(int dirtLevel) {
		if (dirtLevel < MIN_DIRT)
			dirtLevel = MIN_DIRT;
		else if (dirtLevel > MAX_DIRT)
			dirtLevel = MAX_DIRT;
		this.dirtLevel = dirtLevel;
	}

	@Override
	protected void setAgeGroup(AgeGroup ageGroup) {
		if (ageGroup != AgeGroup.A && ageGroup != AgeGroup.B)
			ageGroup = AgeGroup.A;
		this.ageGroup = ageGroup;
	}

	@Override
	protected void play() {
		setDirtLevel(dirtLevel + DIRT_CHANGE);
	}

	@Override
	public String toString() {
		return "Doll [isHard=" + isHard + ", dirtLevel=" + dirtLevel + ", toString()=" + super.toString() + "]";
	}
	
	

}
