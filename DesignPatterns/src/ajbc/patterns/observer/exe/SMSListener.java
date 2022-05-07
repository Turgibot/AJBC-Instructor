package ajbc.patterns.observer.exe;


public class SMSListener implements EventListener {
    private String number;

    public SMSListener(String number) {
        this.number = number;
    }


	@Override
	public void update(Report report) {
		System.out.println("%s news report sent SMS to number: %s Report: %s".formatted(report.getReportType(), number, report.getMessage()));
	}
}