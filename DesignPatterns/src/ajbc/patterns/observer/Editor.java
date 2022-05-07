package ajbc.patterns.observer;


import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager(EventType.OPEN, EventType.SAVE);
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify(EventType.OPEN, file);
    }

    public void saveFile() throws Exception  {
        if (this.file != null) {
            events.notify(EventType.SAVE, file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}