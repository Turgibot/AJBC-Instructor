package ajbc.patterns.observer;

public class Runner {
	public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe(EventType.OPEN, new LogOpenListener("logfile.txt"));
        editor.events.subscribe(EventType.SAVE, new LogOpenListener("logfile.txt"));
        editor.events.subscribe(EventType.SAVE, new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
