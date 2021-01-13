package design.pattern.creational.singleton;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-12  23:33
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance = null;

    private static Object lock = new Object();


    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if(instance == null ){

        }
        return instance;
    }




}
