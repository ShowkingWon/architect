package design.pattern.structural.adapter;

/**
 * Adapter allows fitting square pegs into round holes.
 *
 * 适配器是一个能够同时处理客户机和服务的类:它实现客户机接口，同时包装服务对象。
 * 适配器通过适配器接口接收来自客户机的调用，并将其转换为对包装好的服务对象的调用，这种调用的格式是它可以理解的。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-22  0:25
 */
public class SquarePegAdapter extends RoundPeg{

    //通过组合方式  对象适配器
    private SquarePeg peg;


    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }



}
