package design.pattern.structural.bridge;

/**
 * 基础远程控制器。
 *
 *  精确抽象 （Refined Abstraction） 提供控制逻辑的变体。 与其父类一样， 它们通过通用实现接口与不同的实现进行交互。
 *
 *   本例展示了远程控制器及其所控制的设备的类之间的分离。
 *   远程控制器是抽象部分， 设备则是其实现部分。 由于有通用的接口， 同一远程控制器可与不同的设备合作， 反过来也一样。
 *   桥接模式允许在不改动另一层次代码的前提下修改已有类， 甚至创建新类。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-01  23:45
 */
public class BasicRemote implements Remote{


    /**
     * 层次结构中的第一层 （通常称为抽象部分） 将包含对第二层 （实现部分） 对象的引用。
     * 抽象部分将能将一些 （有时是绝大部分） 对自己的调用委派给实现部分的对象。
     * 所有的实现部分都有一个通用接口， 因此它们能在抽象部分内部相互替换。
     *
     */
    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }




    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }
}
