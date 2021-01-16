package design.pattern.creational.builder;

/**
 * Builder interface defines all possible ways to configure a product.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-16 16:57
 */
public interface Builder {

    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);


}
