package basis.generics;

import java.awt.*;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2020-03-09  21:35
 */
public class Colored <T extends HasColor>{
    T item;
    Colored(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }

    /**
     * he bound allows you to call a method.
     * @return
     */
    Color color(){
        return item.getColor();
    }
}
