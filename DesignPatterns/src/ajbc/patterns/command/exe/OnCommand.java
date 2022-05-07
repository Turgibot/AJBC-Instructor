package ajbc.patterns.command.exe;

import java.time.LocalTime;

public class OnCommand implements Command {
	private static final int MAX_DURATION = 90;
	int duration;

	public OnCommand(int duration) {
		setDuration(duration);
	}

	private void setDuration(int duration) {
		if (duration <= 0 || duration >= MAX_DURATION) {
			duration = MAX_DURATION;
		}
		this.duration = duration;
	}

	@Override
	public String execute() {
		return "Heater turned on for %d minutes on %s".formatted(duration, LocalTime.now());
	}
}