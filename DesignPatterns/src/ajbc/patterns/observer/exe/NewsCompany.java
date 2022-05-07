package ajbc.patterns.observer.exe;




public class NewsCompany {
    public EventManager events;
    
    public NewsCompany() {
        this.events = new EventManager(ReportType.values());
    }

    public void sendReport(Report report) {
        events.notify(report);
    }

}