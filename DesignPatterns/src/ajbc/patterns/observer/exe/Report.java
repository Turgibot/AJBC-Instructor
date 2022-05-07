package ajbc.patterns.observer.exe;

public class Report {
	private String message;
	private ReportType reportType;

	public Report(String message, ReportType reportType) {
		this.message = message;
		this.reportType = reportType;
	}

	public String getMessage() {
		return message;
	}
	
	public ReportType getReportType() {
		return reportType;
	}
}
