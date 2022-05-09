package ajbc.patterns.state.exe;

public class GumDispenser {
	private static final int NUM_GUMS = 1000;
    private State state;
    private int numGums;

    public GumDispenser() {
        this.state = new StartState(this);
        numGums = NUM_GUMS;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getNumGums() {
    	return numGums;
    }

    public void removeGum() {
        numGums--;
    }
}