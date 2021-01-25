package design.pattern.creational.abstractfactory;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:39
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
