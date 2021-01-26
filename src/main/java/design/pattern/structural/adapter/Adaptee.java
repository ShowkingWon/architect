package design.pattern.structural.adapter;

/**
 * 已经存在的接口,这个接口需要被适配.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-01-22 16:21
 */
public class Adaptee {

    /**
     * s示意方法, 原本已经存在, 已经实现的方法.
     *
     * @autuor Jerry Wan
     * @date 2021/1/22 16:22
     */
    void specificRequest() {

        // 具体的处理功能
        System.out.println("Adaptee specific request...");

    }

}
