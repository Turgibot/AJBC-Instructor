package src;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable {
	
	protected String name;
	protected LocalDate birthDate;
	protected int flameIntensity;
	
	protected final LocalDate maxBirthDate = LocalDate.of(888, 8, 8);
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity)  {
		this.name = name;
		try {
			setBirthDate(birthDate);
		}
		catch (TooYoungException e)
		{
			System.out.println(e);
			this.birthDate = maxBirthDate;
		}
		this.flameIntensity = flameIntensity;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}

	public void setBirthDate(LocalDate birthDate) {
		if (birthDate.isAfter(maxBirthDate))
			throw new TooYoungException();
		this.birthDate = birthDate;
	}
	
	

}
