package design.pattern.structural.bridge;

/**
 * 客户端代码.
 *  通常情况下， 客户端 （Client） 仅关心如何与抽象部分合作。 但是， 客户端需要将抽象对象与一个实现对象连接起来。
 *
 * 本例展示了远程控制器及其所控制的设备的类之间的分离。
 * 远程控制器是抽象部分， 设备则是其实现部分。 由于有通用的接口， 同一远程控制器可与不同的设备合作， 反过来也一样。
 * 桥接模式允许在不改动另一层次代码的前提下修改已有类， 甚至创建新类。
 *
 *    桥接是一种结构型设计模式， 可将业务逻辑或一个大类拆分为不同的层次结构， 从而能独立地进行开发。
 *    层次结构中的第一层 （通常称为抽象部分） 将包含对第二层 （实现部分） 对象的引用。
 *    抽象部分将能将一些 （有时是绝大部分） 对自己的调用委派给实现部分的对象。 所有的实现部分都有一个通用接口， 因此它们能在抽象部分内部相互替换。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-11  0:12
 */
public class Demo {


    public static void main(String[] args) {

        //客户端需要将抽象对象与一个实现对象连接起来。

        // 实现部门可以有自己的层次，可独立扩展。 比如 LED TV 是 Tv的子类，  Tv是Device的子类。
        testDevice(new Tv());
        testDevice(new LedTv());
        testDevice(new Radio());
    }


    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        //客户端需要将抽象对象与一个实现对象连接起来。
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        //客户端需要将抽象对象与一个实现对象连接起来。
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }


}
