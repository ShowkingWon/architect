package design.pattern.creational.singleton;

/**
 * @author JerryWan
 * @descripion
 * @date 2021-01-11  0:12
 */
public class Demo {
    public static void main(String[] args) {
        /*UnsafeSingleton unsafeSingleton = UnsafeSingleton.getInstance();
        unsafeSingleton.doSomething();*/

        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();

        // true
        System.out.println(singleton1 == singleton2);
        // 利用枚举来实现单例模式是最佳实践！！！
        BestSingleton instance1 = BestSingleton.INSTANCE;
        BestSingleton instance2 = BestSingleton.INSTANCE;
        System.out.println(instance1 == instance2);
        instance1.method();


    }

}
