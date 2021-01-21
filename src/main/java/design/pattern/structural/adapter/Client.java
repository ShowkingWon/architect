package design.pattern.structural.adapter;

/**
 * 客户端是一个包含程序现有业务逻辑的类。
 * 只要客户机代码通过客户机接口与适配器一起工作，客户机代码就不会耦合到具体的适配器类。
 * 由于这一点，您可以在程序中引入新类型的适配器，而不会破坏现有的客户机代码。
 * 当服务类的接口被更改或替换时，这很有用:您可以只创建一个新的适配器类，而不更改客户机代码。
 *
 *
 * 当您想要使用某些现有的类，但其接口与您的其余代码不兼容时，可以使用适配器类。
 *    适配器模式允许您创建一个中间层类，作为代码与遗留类、第三方类或任何具有奇怪接口的其他类之间的转换程序。
 *
 * 当您想重用几个现有的子类时，可以使用该模式，这些子类缺乏一些不能添加到超类中的通用功能。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-21  0:36
 */
public class Client {

    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if(hole.fits(roundPeg)){
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);
        //System.out.println(hole.fits(smallSquarePeg)); // Won't compile.

        //使用适配器
        SquarePegAdapter smallAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeAdapter = new SquarePegAdapter(largeSquarePeg);
        if(hole.fits(smallAdapter)){
            System.out.println("Square peg w2 fits round hole r5.");

        }
        if(hole.fits(largeAdapter)){
            System.out.println("Square peg w20 fits round hole r5.");

        }


    }



}
