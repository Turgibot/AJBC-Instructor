package ajbc.patterns.observer.exe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
	Map<ReportType, List<EventListener>> listeners = new HashMap<>();

	public EventManager(ReportType... reports) {
		for (ReportType report : reports) {
			listeners.put(report, new ArrayList<>());
		}
	}

	public void subscribe(ReportType eventType, EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.add(listener);
	}

	public void unsubscribe(ReportType eventType, EventListener listener) {

		List<EventListener> users = listeners.get(eventType);
		while (users.contains(listener))
			users.remove(listener);
	}

	public void notify(Report report) {
		ReportType reportType = report.getReportType();
		List<EventListener> users = listeners.get(reportType);
		for (EventListener listener : users) {
			listener.update(report);
		}
	}
}
