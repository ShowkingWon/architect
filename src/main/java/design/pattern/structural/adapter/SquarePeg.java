package design.pattern.structural.adapter;

/**
 *
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 *
 * 不兼容。
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-22  0:24
 */
public class SquarePeg {

    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
