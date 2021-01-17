package design.pattern.creational.factorymethod;

/**
 * Concrete product
 * HTML button implementation.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-18  0:12
 */
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();

    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");

    }
}
