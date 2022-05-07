package ajbc.patterns.builder;

/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
public class Director {
	private final int NUM_SEATS_SPORT=2,NUM_SEATS_CITY=2,NUM_SEATS_SUV=4;
	private final double ENGINE_VOL_SPORT = 3.0d, MILAGE_SPORT=0d,
						 ENGINE_VOL_CITY = 1.2d, MILAGE_CITY=0d,
						 ENGINE_VOL_SUV = 2.5d, MILAGE_SUV=0d;
	
    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(NUM_SEATS_SPORT);
        builder.setEngine(new Engine(ENGINE_VOL_SPORT, MILAGE_SPORT));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(NUM_SEATS_CITY);
        builder.setEngine(new Engine(ENGINE_VOL_CITY, MILAGE_CITY));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(NUM_SEATS_SUV);
        builder.setEngine(new Engine(ENGINE_VOL_SUV, MILAGE_SUV));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}