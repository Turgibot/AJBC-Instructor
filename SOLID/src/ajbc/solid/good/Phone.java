package ajbc.solid.good;
public class Phone implements Notifier{
	@Override
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
