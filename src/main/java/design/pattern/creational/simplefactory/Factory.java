package design.pattern.creational.simplefactory;

/**
 * 简单工厂： -->选择实现！
 *   负责创建接口对象。 选择合适的实现类来创建接口的对象。
 * <p>
 * Client通过Factory获取接口实现，而不是由Client来创建接口的对象。
 * Client根本不知道具体的实现是什么，也不知道如何实现。它只知道通过工厂获取一个接口对象，通过该接口对象获取想要的功能即可。
 * 选择合适的实现类来创建接口的对象。
 *
 * 1. 命名建议
 *      简单工厂类名建议为 ”模块名称+Factory“
 *      方法名通常为“get+接口名称”或者“create+接口名称”。
 *
 * 2. 简单工厂优点：
 *      帮助封装。
 *      解耦： 实现了客户端和具体实现类的解耦。
 * 3. 简单工厂缺点：
 *      可能会增加客户端的复杂度。
 *      不方便扩展子工厂
 *
 * 4.
 *
 *
 *
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-20  0:01
 */
public class Factory {


    /**
     * 具体创建接口的方法。
     * <p>
     * 使用简单工厂时，通常不需要创建简单工厂的实例，也就是说简单工厂的方法通常是静态的，所以也被成为静态工厂。
     *
     * @creator wx
     * @date 2021/1/20 0:03
     * @description
     */
    public static OneInterface createApi(int condition) {
        OneInterface api = null;

        if (condition == 1) {
            api = new OneInterfaceImpl();
        } else if (condition == 1) {
            api = new AnotherInterfaceImpl();
        }

        return api;
    }
}
