package design.pattern.structural.bridge;

/**
 * 所有远程控制器的通用接口。
 *
 * 抽象部分 （Abstraction） 提供高层控制逻辑， 依赖于完成底层实际工作的实现对象。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-01  23:45
 */
public interface Remote {

    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();

}
