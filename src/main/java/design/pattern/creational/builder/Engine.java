package design.pattern.creational.builder;

/**
 * Just another feature of a car.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-16 17:00
 */
public class Engine {

    private final double volume;

    private double mileage;

    private boolean stated;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        stated = true;
    }

    public void off() {
        stated = false;
    }

    public boolean isStarted() {
        return stated;
    }

    public void go(double mileage) {
        if (stated) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }


}
