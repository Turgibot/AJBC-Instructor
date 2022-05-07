package ajbc.patterns.command.exe;

import java.time.LocalTime;

public class OffCommand implements Command {
	public OffCommand() {

	}

	@Override
	public String execute() {
		return "Heater turned off on %s".formatted(LocalTime.now());
	}
}