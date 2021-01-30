package design.pattern.structural.decorator;

import java.util.Base64;

/**
 * Concrete Decorators角色。
 * 具体装饰类 （Concrete Decorators） 定义了可动态添加到部件的额外行为。
 * 具体装饰类会重写装饰基类的方法， 并在调用父类方法之前或之后进行额外的行为。
 * <p>
 * 加密装饰。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-29  23:56
 */
public class EncryptionDecorator extends DataSourceDecorator {


    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }


    /**
     * 写数据。
     *
     * 具体装饰类会重写装饰基类的方法， 并在调用父类方法之前或之后进行额外的行为。
     * @creator wx
     * @date 2021/1/30 0:36
     * @description
     */
    @Override
    public void writeData(String data) {
        System.out.println("要被加密了。。。" );
        super.writeData(encode(data));
    }


    /**
     * 读数据。
     *
     * 具体装饰类会重写装饰基类的方法， 并在调用父类方法之前或之后进行额外的行为。
     * @creator wx
     * @date 2021/1/30 0:36
     * @description
     */
    @Override
    public String readData() {
        System.out.println("要被解密了。。。" );
        return decode(super.readData());
    }


    // 额外的功能 加密


    /**
     * 加密。
     *
     * 具体装饰类 定义的可动态添加到部件的额外行为。
     * @creator wx
     * @date 2021/1/30 0:34
     * @description
     */
    private String encode(String data) {
        byte[] result = data.getBytes();

        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }



    /**
     * 解密。
     *
     * 具体装饰类 定义的可动态添加到部件的额外行为。
     * @creator wx
     * @date 2021/1/30 0:34
     * @description
     */
    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

}
