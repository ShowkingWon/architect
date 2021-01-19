package design.pattern.creational.simplefactory;

/**
 * 具体实现接口的实现类。 可能会有多个。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-20  0:00
 */
public class OneInterfaceImpl implements OneInterface {


    @Override
    public void operation(String s) {

        System.out.println("OneInterfaceImpl s = " + s);

    }
}
