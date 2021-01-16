package design.pattern.creational.builder;

/**
 * Just another feature of a car.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-16 17:04
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
