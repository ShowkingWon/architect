package design.pattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-14 16:48
 */
public class ReflectionSingletonTest {

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        Singleton1 instance3 = null;


        Constructor[] constructors = Singleton1.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            try {
                instance3 = (Singleton1) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // true
        System.out.println(instance1 == instance2);

        // false
        System.out.println(instance1 == instance3);


    }
}
