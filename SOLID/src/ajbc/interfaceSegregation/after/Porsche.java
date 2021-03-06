package ajbc.interfaceSegregation.after;

public class Porsche implements Vehicle, Transmission, IPodControl {

	private int gear = 1;

	public void drive() {
		System.out.println("Driving...");
	}

	public void changeGear(int gear) {
		this.gear = gear; 
	}

	public void playIPod() {
		System.out.println("Playing music from the iPod...");
	}

	public int getGear() {
		return gear;
	}

}
