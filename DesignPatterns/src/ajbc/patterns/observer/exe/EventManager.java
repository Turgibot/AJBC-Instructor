package ajbc.patterns.observer.exe;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
	 Map<ReportType, List<EventListener>> sMSListeners = new HashMap<>();
	 Map<ReportType, List<EventListener>> eMailListeners = new HashMap<>();

	    public EventManager(ReportType... operations) {
	        for (ReportType operation : operations) {
	        	sMSListeners.put(operation, new ArrayList<>());
	        	eMailListeners.put(operation, new ArrayList<>());
	        }
	    }

	    public void subscribe(ReportType eventType, SMSListener listener) {
	        List<EventListener> users = sMSListeners.get(eventType);
	        users.add(listener);
	    }

	    public void subscribe(ReportType eventType, EmailListener listener) {
	        List<EventListener> users = eMailListeners.get(eventType);
	        users.add(listener);
	    }

	    public void unsubscribe(ReportType eventType, EventListener listener) {
	    	
	        List<EventListener> users = eMailListeners.get(eventType);
	        if(users.contains(listener))
	        	users.remove(listener);
	        users = sMSListeners.get(eventType);
	        if(users.contains(listener))
	        	users.remove(listener);
	        
	    }

	    public void notify(Report report) {
	    	ReportType reportType = report.getReportType();
	        List<EventListener> users = sMSListeners.get(reportType);
	        users.addAll(eMailListeners.get(reportType));
	        for (EventListener listener : users) {
	            listener.update(report);
	        }
	    }
}
