package basis.enums;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2020-03-28  19:18
 */
public class Text {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
