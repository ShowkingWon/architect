package design.pattern.creational.factorymethod;

/**
 * Client code
 * Everything comes together here.
 * 在这个例子中，按钮扮演产品角色，对话框扮演创造者。
 *
 *
 * 1.Simple factory pattern
 * 简单工厂模式描述了一个具有一个创建方法和一个大型条件的类，该条件基于方法参数选择实例化哪个产品类并返回。
 *
 * 人们通常会将简单工厂与一般工厂或一种创造性的设计模式混淆。在大多数情况下，简单工厂是引入工厂方法或抽象工厂模式的中间步骤。
 *
 * 一个简单的工厂通常由单个类中的单个方法表示。随着时间的推移，这个方法可能会变得太大，所以您可能决定将该方法的部分提取到子类中。
 * 这样做几次之后，您可能会发现整个过程都变成了经典的工厂方法模式。
 *
 * 顺便说一下，如果您声明了一个简单的工厂抽象，它不会神奇地变成抽象工厂模式。
 *
 * Here’s an example of simple factory:
 * class UserFactory {
 *  public static function create($type) {
 *      switch ($type) {
 *          case 'user': return new User();
 *          case 'customer': return new Customer();
 *          case 'admin': return new Admin();
 *          default:
 *              throw new Exception('Wrong user type passed.');
 *        }
 *    }
 * }
 *
 * 2.Factory Method pattern
 *  工厂方法是一种创建设计模式，它提供了创建对象的接口，但允许子类更改将要创建的对象的类型。
 *
 *  如果您在基类中有一个创建方法以及扩展它的子类，那么您可能需要查看工厂方法。
 *
 *
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-11  0:12
 */
public class Demo {


    /**
     * Base creator
     */
    private static Dialog dialog;

    public static void main(String[] args) {

        configure();

        runBusinessLogic();
    }


    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
