package design.pattern.structural.adapter;

/**
 * 适配器是一个能够同时处理客户机和服务的类:它实现客户机接口，同时包装服务对象。
 * 适配器通过适配器接口接收来自客户机的调用，并
 * 将其转换为对包装好的服务对象的调用，这种调用的格式是它可以理解的。
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-21 21:00
 */
public class Adapter implements Target {

    /**
     * 持有需要被适配的接口对象.
     */
    private Adaptee adaptee;


    /**
     * 构造方法,传入需要被适配的接口对象.
     *
     * @param adaptee
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {

        // 可能转调已经实现的方法,进行适配
        adaptee.specificRequest();

    }
}
