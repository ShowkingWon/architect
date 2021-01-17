package design.pattern.creational.factorymethod;

/**
 *  Concrete creator
 *
 *  HTML Dialog will produce HTML buttons.
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-18  0:17
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
