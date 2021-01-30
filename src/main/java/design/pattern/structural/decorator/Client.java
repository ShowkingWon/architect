package design.pattern.structural.decorator;

/**
 *
 *  客户端 （Client） 可以使用多层装饰来封装部件， 只要它能使用通用接口与所有对象互动即可。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-30  0:07
 */
public class Client {

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        //可以使用多层装饰来封装部件， 只要它能使用通用接口与所有对象互动即可。

        // 多个装饰器装饰函数时,离函数近的装饰器先进行装饰，下面的装饰器先装饰完后将整个装饰结果给第一个装饰器进行装饰

        //即：封装时自内而外(自下而上)，执行时自外而内(自上而下)
        DataSourceDecorator encoded = new CompressionDecorator(
                                        new EncryptionDecorator(
                                            new FileDataSource("out/OutputDemo.txt")
                ));

        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
