package ajbc.patterns.state.exe;


/**
 * Common interface for all states.
 */
public abstract class State {
    GumDispenser dispenser;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(GumDispenser dispenser) {
        this.dispenser = dispenser;
    }
      
    public abstract boolean onInsert5();
    public abstract boolean onInsert10();
    public abstract boolean takeGum();

}