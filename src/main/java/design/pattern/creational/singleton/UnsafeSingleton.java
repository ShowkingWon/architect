package design.pattern.creational.singleton;

/**
 * 线程不安全的简单单例模式。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-12  23:21
 */
public class UnsafeSingleton {


    /**
     * 懒汉模式 用的时候再new.
     */
    private static UnsafeSingleton instance = null;

    /**
     * 私有构造器.
     */
    private UnsafeSingleton() {
    }

    /**
     * 公有的访问点.
     *
     * @return
     */
    public static UnsafeSingleton getInstance() {
        if (instance == null) {
            instance = new UnsafeSingleton();
        }
        return instance;

    }

    /**
     * 方法.
     */
    public void doSomething(){
        System.out.println("UnsafeSingleton doSomething ... ");
    }

}
