package solutions.exams.week2.toy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import solutions.exams.week2.kid.Kid;

public abstract class Toy {
	private static long counter;

	protected final long serialNum;
	protected String name;
	protected LocalDate purchaseDate;
	protected AgeGroup ageGroup;
	protected Kid kid;
	static {
		counter = 0;
	}

	public Toy(String name, LocalDate purchaseDate, AgeGroup ageGroup, Kid kid) {
		this.serialNum = counter++;
		setName(name);
		setPurchaseDate(purchaseDate);
		setAgeGroup(ageGroup);
		setKid(kid);
		//TODO add Wheel class later
	}

	private void setKid(Kid kid) {
		this.kid = kid;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	protected void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	@Override
	public String toString() {
		return "Toy [serialNum=" + serialNum + ", name=" + name + ", purchaseDate=" + purchaseDate + ", ageGroup="
				+ ageGroup + ", isBroken=" + isBroken() + ", kid=" + kid + "]";
	}

	protected boolean isBroken() {
		long yearDiff = ChronoUnit.YEARS.between(purchaseDate, LocalDate.now());
		return yearDiff >= 1;
		//TODO dont forget to check for existance
	}

	protected boolean isInAgeGroup() {
		return ageGroup == AgeGroup.getGroupByAge(kid.calcAge());
	}

	protected boolean isPlayable() {
		return !isBroken() && isInAgeGroup();
	}

	public void simulatePlay() {

		System.out.println("Before Play Time:");
		System.out.println(this);

		if (!isPlayable()) {
			System.out.println("I'm Sorry but this toy cannot be played with right now :(");
			return;
		}

		play();

		System.out.println("After Play Time:");
		System.out.println(this);
	}

	protected abstract void play();
}
