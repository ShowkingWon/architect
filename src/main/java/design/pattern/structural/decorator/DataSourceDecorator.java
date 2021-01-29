package design.pattern.structural.decorator;

/**
 * Base Decorator角色。
 *
 * 基础装饰 （Base Decorator） 类拥有一个指向被封装对象的引用成员变量。
 * 该变量的类型应当被声明为通用部件接口， 这样它就可以引用具体的部件和装饰。 装饰基类会将所有操作委派给被封装的对象。
 *
 * 抽象基础装饰.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-29  23:54
 */
public class DataSourceDecorator implements DataSource {


    /**
     * 基础装饰 （Base Decorator） 类拥有一个指向被封装对象的引用成员变量。
     * 该变量的类型应当被声明为通用部件接口， 这样它就可以引用具体的部件和装饰.
     */
    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {

        // 装饰基类会将所有操作委派给被封装的对象。
        wrappee.writeData(data);

    }

    @Override
    public String readData() {

        //装饰基类会将所有操作委派给被封装的对象。
        return wrappee.readData();
    }
}
