package ajbc.patterns.observer.exe;

public class Runner {
	public static void main(String[] args) {
        NewsCompany editor = new NewsCompany();
        editor.events.subscribe(ReportType.SPORTS, new SMSListener("432432438"));
        editor.events.subscribe(ReportType.GENERAL, new SMSListener("123234234"));
        editor.events.subscribe(ReportType.WEATHER, new EmailListener("admin@example.com"));
        editor.events.subscribe(ReportType.WEATHER, new SMSListener("432432438"));
        editor.events.subscribe(ReportType.GENERAL, new EmailListener("123234234"));
        editor.events.subscribe(ReportType.SPORTS, new EmailListener("admin@example.com"));
        
        Report sportReport = new Report("Wariors Won!!", ReportType.SPORTS);
        editor.sendReport(sportReport);
        Report newsReport = new Report("Peace finally arrived to the middle east", ReportType.GENERAL);
        editor.sendReport(newsReport);
        Report weatherReport = new Report("Volcano errapted in Hawaii", ReportType.WEATHER);
        editor.sendReport(weatherReport);
    }
}
