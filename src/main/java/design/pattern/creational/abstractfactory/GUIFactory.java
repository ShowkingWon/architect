package design.pattern.creational.abstractfactory;

/**
 * Abstract factory knows about all (abstract) product types.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:39
 */
public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();


}
