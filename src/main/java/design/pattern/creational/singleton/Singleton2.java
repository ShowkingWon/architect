package design.pattern.creational.singleton;

import design.pattern.annotation.Recommended;

/**
 * 单例模式第2种实现方式：
 * 饿汉式（静态代码块）
 * <p>
 * 优点： 写法简单，在类装载的时候就完成实例化，避免了线程同步问题。
 * 缺点： 类装载的时候就完成实例化，没有Lazy Loading的效果，如果自始至终都没有用到这个实例，会存在内存浪费。
 * 这种方式基于classloader机制避免了多线程的同步问题，不过instance在类装载时就实例化，
 * <p>
 * 总结： 可用，但可能会造成内存浪费。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-14  0:00
 */
@Recommended
public class Singleton2 {

    /**
     * 1.构造器私有化
     */
    private Singleton2() {
    }

    private static Singleton2 instance;

    /**
     * 2.静态代码块中创建对象实例
     */
    static {
        instance = new Singleton2();
    }

    /**
     * 3.公有的静态方法，返回实例对象
     *
     * @return
     */
    public static Singleton2 getInstance() {
        return instance;

    }


}
