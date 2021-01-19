package design.pattern.structural.facade;

/**
 * 外观对象。
 * 外观模式的本质： 封装交互，简化调用。
 * 很好的体现了 最少知识原则
 *
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-20  0:58
 */
public class Facade {


    public void test(){
        // 在内部实现的时候，可能会调用内部的多个模块

        AModuleApi a = new AModuleImpl();
        a.testA();

        BModuleApi b = new BModuleImpl();
        b.testB();

        CModuleApi c = new CModuleImpl();
        c.testC();
    }

}
