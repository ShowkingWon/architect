package design.pattern.creational.singleton;

import design.pattern.annotation.Forbidden;
import design.pattern.annotation.Unsafe;

/**
 * 单例模式第3种实现方式：
 * 懒汉式（线程不安全）
 *
 * 优点： 起到了lazy loading效果，但是只能在单线程下使用。
 * 缺点： 多线程环境不安全，可能会创建多个实例。
 *
 * 总结： 在实际开发中，不要使用该方式！！！
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-14  0:00
 */
@Unsafe("线程不安全")
@Forbidden
public class Singleton3 {

    /**
     * 1.构造器私有化
     */
    private Singleton3() {
    }

    private static Singleton3 instance;

    /**
     * 3.公有的静态方法，当使用该方法时，才会创建实例
     * 懒汉式
     *
     * 线程不安全 当A线程new时， 可能B线程已经new好了
     *
     * @return
     */
    public static Singleton3 getInstance() {
        if(instance == null ){
            instance = new Singleton3();
        }
        return instance;

    }


}
