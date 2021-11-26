package design.pattern.creational.factorymethod;


/**
 * 通用产品接口。
 * Common interface for all buttons.
 *
 * @author wx
 * @date 2021/1/18 0:11
 * @description
 */
public interface Button {

    /**
     * 渲染
     */
    void render();

    /**
     * 点击事件
     */
    void onClick();
}
