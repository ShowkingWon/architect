package design.pattern.creational.singleton;

import design.pattern.annotation.NotRecommended;

/**
 * 单例模式第4种实现方式：
 * 懒汉式（线程安全 同步方法）
 *
 * 优点： 通过同步锁，解决了线程不安全的问题。
 * 缺点： 效率太低。每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只需要执行一次实例化代码就够了，后面想获得实例的，追return就可以。
 *
 * 总结： 在实际开发中，不推荐使用该方式！！！
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-14  0:00
 */
@NotRecommended
public class Singleton4 {

    /**
     * 1.构造器私有化
     */
    private Singleton4() {
    }

    private static Singleton4 instance;



    /**
     * 3.公有的静态方法，当使用该方法时，才会创建实例
     * 懒汉式
     *
     * 加同步锁，保证线程安全。
     *
     * @return
     */
    public static synchronized Singleton4 getInstance() {
        if(instance == null ){
            instance = new Singleton4();
        }
        return instance;

    }


}
