package ajbc.solid.good;

public class WeatherTracker {
    public String currentConditions;
   

    public WeatherTracker(String currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void notify(Notifier notifier) {
    	notifier.generateWeatherAlert(currentConditions);
    }
    
    
    public boolean trying() {
    	int x = 4;
    	int y = 5;
    	
    	return x>y;
    		
    }
}
