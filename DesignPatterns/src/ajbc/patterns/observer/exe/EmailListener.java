package ajbc.patterns.observer.exe;

public class EmailListener implements EventListener {
    private String email;

    public EmailListener(String email) {
        this.email = email;
    }

	@Override
	public void update(Report report) {
		System.out.println("%s news report sent to email: %s Report: %s".formatted(report.getReportType() ,email, report.getMessage()));
	}
}