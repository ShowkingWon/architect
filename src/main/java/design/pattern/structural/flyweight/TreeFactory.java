package design.pattern.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装创建享元的复杂机制。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-01  0:27
 */
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}
