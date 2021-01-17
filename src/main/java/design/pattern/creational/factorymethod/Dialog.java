package design.pattern.creational.factorymethod;

/**
 * Base creator
 * <p>
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be created.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-18  0:15
 */
public abstract class Dialog {


    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }


    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
