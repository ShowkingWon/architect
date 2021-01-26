package design.pattern.creational.abstractfactory;


/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 *
 * @creator wx
 * @date 2021/1/26 0:35
 * @description
 */
public interface Button {

    void paint();

}
