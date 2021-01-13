package design.pattern.creational.singleton;

import design.pattern.annotation.Recommended;

/**
 * 单例模式第6种实现方式：
 *
 * 双重检查锁 double-checked locking
 * 优点： 线程安全， 延迟加载， 效率较高。
 *
 * 总结： 在实际开发中，推荐使用！
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-14  0:00
 */
@Recommended
public class Singleton6 {

    /**
     * 1.构造器私有化
     */
    private Singleton6() {
    }


    /**
     * 使用volatile变量
     */
    private static volatile Singleton6 instance;


    /**
     * 3.公有的静态方法，加入双重检查代码，解决线程安全问题和懒加载问题，同时保证了效率。
     *
     */
    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;

    }


}
