package design.pattern.creational.abstractfactory;

/**
 * All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is another variant of a button.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:37
 */
public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
