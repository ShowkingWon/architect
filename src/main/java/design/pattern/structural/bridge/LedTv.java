package design.pattern.structural.bridge;

/**
 *
 * 具体实现 （Concrete Implementations） 中包括特定于平台的代码。
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-02  0:10
 */
public class LedTv extends Tv {

    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm LED TV set.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
