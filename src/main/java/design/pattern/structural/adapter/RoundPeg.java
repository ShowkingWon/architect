package design.pattern.structural.adapter;

/**
 * RoundPegs are compatible with RoundHoles.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-22  0:23
 */
public class RoundPeg {

    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
