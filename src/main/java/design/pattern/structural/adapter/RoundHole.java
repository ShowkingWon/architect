package design.pattern.structural.adapter;

/**
 * RoundHoles are compatible with RoundPegs.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-22  0:22
 */
public class RoundHole {

    private double radius;
    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }



}
