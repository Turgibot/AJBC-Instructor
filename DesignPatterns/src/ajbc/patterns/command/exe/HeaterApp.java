package ajbc.patterns.command.exe;


import java.util.List;

public class HeaterApp {
    
    private static final int MAX_SHOW_QTT = 5;
	private CommandHistory history;
    
    public HeaterApp() {
    	history = new CommandHistory();
    }
    public void TurnOn(int minutes) {
    	executeCommand(new OnCommand(minutes));
    }
    
    public void TurnOff() {
    	executeCommand(new OffCommand());
    }
    
    private void executeCommand(Command command) {
    		System.out.println(command.execute());
            history.add(command);
    }
    
    public void showHistory() {
    	if(history.isEmpty())
    		return;
    	List<Command> commands = history.getHistory();
    	int size = commands.size();
    	if( size > MAX_SHOW_QTT) {
    		commands = commands.subList(size-MAX_SHOW_QTT, size);
    	}
    	commands.forEach(c->System.out.println(c.execute()));
    }
}