package design.pattern.creational.abstractfactory;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:40
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
