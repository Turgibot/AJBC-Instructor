package ajbc.patterns.observer;

import java.io.File;

public interface EventListener {
	void update(EventType eventType, File file);
}
