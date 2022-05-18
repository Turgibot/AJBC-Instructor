package solutions.exams.week2.kid;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Kid {
	private String name;
	private LocalDate birthDate;

	public Kid(String name, LocalDate birthDate) {
		setName(name);
		setBirthDate(birthDate);
	}

	private void setName(String name) {
		this.name = name;
	} 

	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Kid [name=" + name + ", birthDate=" + birthDate + "]";
	}

	public long calcAge() {
		return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
	}

}
