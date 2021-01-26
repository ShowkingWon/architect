package design.pattern.creational.singleton;

import design.pattern.annotation.Recommended;

/**
 * 单例模式第7种实现方式：
 *  Bill Pugh Singleton Implementation
 *
 * 静态内部类
 * 特性： 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
 * 具体来说当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，
 * 使用INSTANCE的时候,才会导致虚拟机加载SingleTonHoler类。这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 * 首先要了解类加载过程中的最后一个阶段：即类的初始化，类的初始化阶本质就是执行类构造器的<clinit>方法。
 * <clinit>方法：这不是由程序员写的程序，而是根据代码由javac编译器生成的。它是由类里面所有的类变量的赋值动作和静态代码块组成的。
 * JVM内部会保证一个类的<clinit>方法在多线程环境下被正确的加锁同步，也就是说如果多个线程同时去进行“类的初始化”，
 * 那么只有一个线程会去执行类的<clinit>方法，其他的线程都要阻塞等待，直到这个线程执行完<clinit>方法。
 * 然后执行完<clinit>方法后，其他线程唤醒，但是不会再进入<clinit>()方法。也就是说同一个加载器下，一个类型只会初始化一次。
 *
 *
 * 优点： 避免了线程不安全，利用静态内部类特点实现延迟加载，效率高！
 *
 * 总结： 在实际开发中，推荐使用！
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-14  0:00
 */
@Recommended
public class Singleton7 {

    /**
     * 1.构造器私有化
     */
    private Singleton7() {
    }


    /**
     * 2.使用静态内部类。
     * 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
     * 具体来说当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，
     * 使用INSTANCE的时候,才会导致虚拟机加载SingleTonHoler类。这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
     * <p>
     * 首先要了解类加载过程中的最后一个阶段：即类的初始化，类的初始化阶本质就是执行类构造器的<clinit>方法。
     * <clinit>方法：这不是由程序员写的程序，而是根据代码由javac编译器生成的。它是由类里面所有的类变量的赋值动作和静态代码块组成的。
     * JVM内部会保证一个类的<clinit>方法在多线程环境下被正确的加锁同步，也就是说如果多个线程同时去进行“类的初始化”，
     * 那么只有一个线程会去执行类的<clinit>方法，其他的线程都要阻塞等待，直到这个线程执行完<clinit>方法。
     * 然后执行完<clinit>方法后，其他线程唤醒，但是不会再进入<clinit>()方法。也就是说同一个加载器下，一个类型只会初始化一次。
     */
    private static class SingletonHolder {
        private static Singleton7 instance = new Singleton7();
    }


    /**
     * 3.公有的静态方法，加入双重检查代码，解决线程安全问题和懒加载问题，同时保证了效率。
     */
    public static Singleton7 getInstance() {

        return SingletonHolder.instance;

    }


}
