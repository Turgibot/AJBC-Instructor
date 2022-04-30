package ajbc.functional.stream.exercise;

public class GameCharacter {
	private String name;
	private String title;
	private String city;
	private int level;
	private double hitPoints;
	private Continent continent;

	public GameCharacter(String name, String title, String city, int level, double hitPoints, Continent continent) {
		super();
		this.name = name;
		this.title = title;
		this.city = city;
		this.level = level;
		this.hitPoints = hitPoints;
		this.continent = continent;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getCity() {
		return city;
	}

	public int getLevel() {
		return level;
	}

	public double getHitPoints() {
		return hitPoints;
	}

	public Continent getContinent() {
		return continent;
	}

	@Override
	public String toString() {
		return "GameCharacter [name=" + name + ", title=" + title + ", city=" + city + ", level=" + level
				+ ", hitPoints=" + hitPoints + ", continent=" + continent + "]";
	}
}
