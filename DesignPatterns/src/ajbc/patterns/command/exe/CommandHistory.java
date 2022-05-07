package ajbc.patterns.command.exe;


import java.util.ArrayList;
import java.util.List;


public class CommandHistory {
    private List<Command> history;
    
    public CommandHistory() {
    	history = new ArrayList<>();
    }

    public void add(Command c) {
        history.add(c);
    }

    public List<Command> getHistory() {
        return history;
    }

    public boolean isEmpty() { return history.isEmpty(); }
}