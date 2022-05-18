package solutions.exams.week2.electric;

import java.time.LocalDate;

import solutions.exams.week2.kid.Kid;
import solutions.exams.week2.toy.AgeGroup;
import solutions.exams.week2.toy.Toy;



public class ElectricToy extends Toy {

	private final int MIN_SOUND = 1;
	private final int MAX_SOUND = 10;
	private final int DEF_NUM_BAT = 2;
	private final int SOUND_CHANGE = -1;
	protected int soundLevel;
	protected int numBatteries;

	public ElectricToy(String name, LocalDate purchaseDate, AgeGroup ageGroup, Kid kid, int soundLevel,
			int numBatteries) {
		super(name, purchaseDate, ageGroup, kid);
		setNumBatteries(numBatteries);
		setSoundLevel(soundLevel);
	}

	private void setNumBatteries(int numBatteries) {
		if (numBatteries > 0 && numBatteries < 24)
			this.numBatteries = numBatteries;
		else
			this.numBatteries = DEF_NUM_BAT;
	}

	private void setSoundLevel(int soundLevel) {
		if (soundLevel < MIN_SOUND)
			soundLevel = MIN_SOUND;
		else if (soundLevel > MAX_SOUND)
			soundLevel = MAX_SOUND;
		this.soundLevel = soundLevel;
	}

	@Override
	protected void play() {
		setSoundLevel(soundLevel + SOUND_CHANGE);
	}

	@Override
	public String toString() {
		return "ElectricToy [soundLevel=" + soundLevel + ", numBatteries=" + numBatteries + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
