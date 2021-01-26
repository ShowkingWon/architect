package design.pattern.creational.abstractfactory;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:38
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
