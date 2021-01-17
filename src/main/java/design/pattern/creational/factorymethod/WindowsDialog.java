package design.pattern.creational.factorymethod;

/**
 * One more concrete creator
 * Windows Dialog will produce Windows buttons.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-18  0:17
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
