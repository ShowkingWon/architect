package design.pattern.creational.builder;

/**
 * Builder interface defines all possible ways to configure a product.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-16 16:57
 */
public interface Builder {

    /**
     * 设置车型。
     * @param carType
     */
    void setCarType(CarType carType);


    /**
     * 设置座位数
     * @param seats
     */
    void setSeats(int seats);


    /**
     * 设置发动机。
     * @param engine
     */
    void setEngine(Engine engine);

    /**
     * 设置换挡方式
     * @param transmission
     */
    void setTransmission(Transmission transmission);


    /**
     * 行车电脑
     * @param tripComputer
     */
    void setTripComputer(TripComputer tripComputer);


    /**
     * GPS导航
     * @param gpsNavigator
     */
    void setGPSNavigator(GPSNavigator gpsNavigator);


}
