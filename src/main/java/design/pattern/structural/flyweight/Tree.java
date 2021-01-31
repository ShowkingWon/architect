package design.pattern.structural.flyweight;

import java.awt.*;

/**
 * 包含每棵树的独特状态.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-01  0:26
 */
public class Tree {

    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }

}
