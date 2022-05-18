package solutions.exams.week2.runner;

import java.time.LocalDate;

import solutions.exams.week2.doll.Doll;
import solutions.exams.week2.electric.ElectricToy;
import solutions.exams.week2.kid.Kid;
import solutions.exams.week2.toy.AgeGroup;
import solutions.exams.week2.toy.Toy;


public class Runner {
	public static void main(String[] args) {

		Kid kid1 = new Kid("David", LocalDate.ofYearDay(2021, 9));
		Kid kid2 = new Kid("Charley", LocalDate.ofYearDay(2018, 10));
		Kid kid3 = new Kid("Rose", LocalDate.ofYearDay(2022, 10));
		Kid kid4 = new Kid("Julie", LocalDate.ofYearDay(2016, 10));

		Toy[] toys = new Toy[4];

		toys[0] = new Doll("Micky Mouse", LocalDate.ofYearDay(2022, 10), AgeGroup.B, kid1, false, 2);
		toys[1] = new Doll("Barbie", LocalDate.ofYearDay(2021, 10), AgeGroup.C, kid2, true, 2);
		toys[2] = new ElectricToy("RC Car", LocalDate.ofYearDay(2022, 10), AgeGroup.C, kid3, 8, 6);
		toys[3] = new ElectricToy("Train", LocalDate.now(), AgeGroup.C, kid4, 3, 0);
		
		for (Toy toy : toys) {
			System.out.println("------------------------------------------------");
			toy.simulatePlay();
			System.out.println("------------------------------------------------");
		}
	}

}
