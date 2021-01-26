package design.pattern.creational.abstractfactory;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a checkbox.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:38
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
