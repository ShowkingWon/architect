package design.pattern.creational.abstractfactory;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-26  0:36
 */
public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
