package design.pattern.structural.decorator;

/**
 * Component角色。
 * 部件 （Component） 声明封装器和被封装对象的公用接口。
 *
 * <p>
 * 定义了读取和写入操作的通用数据接口.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-29  23:50
 */
public interface DataSource {


    /**
     * 写数据。
     *
     * @param data
     */
    void writeData(String data);


    /**
     * 读数据。
     *
     * @return
     */
    String readData();

}
