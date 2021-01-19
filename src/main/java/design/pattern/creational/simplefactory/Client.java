package design.pattern.creational.simplefactory;

/**
 * 简单工厂模式
 * 不算一种正式的设计模式。
 * <p>
 * 定义：
 * 提供一个创建对象实例的功能，而无须关心其具体实现。被创建实例的类型可以是接口、抽象类、也可以是具体的类。
 * <p>
 * Client 客户端。
 * 通过Factory获取Api接口对象，然后面向Api接口编程。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-19  23:54
 */
public class Client {
    public static void main(String[] args) {
        OneInterface api = Factory.createApi(1);
        api.operation("正在使用简单工厂模式。。。");

    }
}
