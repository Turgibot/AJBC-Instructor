package ajbc.date_time;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) {

		// 1. Display Current Date
		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date=" + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2014);

		// Try creating date by providing invalid inputs
		// LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid date 'February 29' as '2014' is not a leap year

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date= " + dateFromBase);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014=" + hundredDay2014);

		// 2. Display current time
		// Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time=" + time);

		// Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
		System.out.println("Specific Time of Day=" + specificTime);

		// Try creating time by providing invalid inputs
		// LocalTime invalidTime = LocalTime.of(25,20);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid value for HourOfDay (valid values 0 - 23): 25

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST=" + timeKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time= " + specificSecondTime);

		// 3. Display Current Date and Time
		// Current Date
		LocalDateTime today1 = LocalDateTime.now();
		System.out.println("Current DateTime=" + today1);

		// Current Date using LocalDate and LocalTime
		today1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime=" + today1);

		// Creating LocalDateTime by providing input arguments
		LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		System.out.println("Specific Date=" + specificDate);

		// Try creating date by providing invalid inputs
		// LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28,
		// 25,1,1);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid value for HourOfDay (valid values 0 - 23): 25

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDateTime todayKolkata1 = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata1);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDateTime dateFromBase1 = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
		System.out.println("10000th second time from 01/01/1970= " + dateFromBase1);

		// 4.Formatting Date and Time

		LocalDateTime myDateObj = LocalDateTime.now();
		System.out.println("Before formatting: " + myDateObj);
//	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");

		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);

		// Format examples
		LocalDate date = LocalDate.now();
		// default format
		System.out.println("Default format of LocalDate=" + date);
		// specific format
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

		LocalDateTime dateTime = LocalDateTime.now();
		// default format
		System.out.println("Default format of LocalDateTime=" + dateTime);
		// specific format
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

		// Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		// Instant from timestamp
		Instant specificTime1 = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = " + specificTime1);

		// Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println("Duration = " + thirtyDay);

		// Parse examples
		LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
				DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
		System.out.println("Default format after parsing = " + dt);
		
		//5. DateAPIUtils
		LocalDate today11 = LocalDate.now();
        
        //Get the Year, check if it's leap year
        System.out.println("Year "+today11.getYear()+" is Leap Year? "+today11.isLeapYear());
         
        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? "+today11.isBefore(LocalDate.of(2015,1,1)));
         
        //Create LocalDateTime from LocalDate
        System.out.println("Current Time="+today11.atTime(LocalTime.now()));
         
        //plus and minus operations
        System.out.println("10 days after today will be "+today11.plusDays(10));
        System.out.println("3 weeks after today will be "+today11.plusWeeks(3));
        System.out.println("20 months after today will be "+today11.plusMonths(20));
 
        System.out.println("10 days before today will be "+today11.minusDays(10));
        System.out.println("3 weeks before today will be "+today11.minusWeeks(3));
        System.out.println("20 months before today will be "+today11.minusMonths(20));
         
        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= "+today11.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today11.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= "+lastDayOfYear);
         
        Period period = today11.until(lastDayOfYear);
        System.out.println("Period Format= "+period);
        System.out.println("Months remaining in the year= "+period.getMonths());     
	}

}
