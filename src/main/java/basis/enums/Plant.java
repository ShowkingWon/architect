package basis.enums;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2020-03-28  22:40
 */
public class Plant {

    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {

        /**
         *现在假设你有一组植物代表一个花园，想要列出这些由生命周期组织的植物 (一年生，多年生，或双年生)。
         * 为此，需要构建三个集合，每个生命周期作为一个，并遍历整个花园，将每个植物放置在适当的集合中。
         * 一些程序员可以通过将这些集合放入一个由生命周期序数索引的数组中来实现这一点：
         */
        Plant[] garden = {
                new Plant("Basil", LifeCycle.ANNUAL),
                new Plant("Carroway", LifeCycle.BIENNIAL),
                new Plant("Dill", LifeCycle.ANNUAL),
                new Plant("Lavendar", LifeCycle.PERENNIAL),
                new Plant("Parsley", LifeCycle.BIENNIAL),
                // rosemary 迷迭香
                new Plant("Rosemary", LifeCycle.PERENNIAL)
        };
        System.out.println("-----------  Using ordinal() to index into an array - DON'T DO THIS!  -----------");

        // Using ordinal() to index into an array - DON'T DO THIS!  (Page 171)
        Set<Plant>[] plantsByLifeCycleArr =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            plantsByLifeCycleArr[i] = new HashSet<>();
        }
        for (Plant p : garden) {
            plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
        }
        // Print the results
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
        }

        System.out.println("-----------  Using ordinal() to index into an array - DON'T DO THIS!  -----------");

        /**
         * 这种方法是有效的，但充满了问题。 因为数组不兼容泛型（详见第 28 条），程序需要一个未经检查的转换，并且不会干净地编译。
         * 由于该数组不知道索引代表什么，因此必须手动标记索引输出。
         * 但是这种技术最严重的问题是，当你访问一个由枚举序数索引的数组时，你有责任使用正确的 int 值; int 不提供枚举的类型安全性。
         * 如果你使用了错误的值，程序会默默地做错误的事情，如果你幸运的话，抛出一个 ArrayIndexOutOfBoundsException 异常。
         */

        System.out.println("-----------  Using an EnumMap to associate data with an enum (Page 172)  -----------");

        /**
         * 　有一个更好的方法来达到同样的效果。 该数组有效地用作从枚举到值的映射，因此不妨使用 Map。
         *   更具体地说，有一个非常快速的 Map 实现，设计用于枚举键，称为 java.util.EnumMap。
         *   下面是当程序重写为使用 EnumMap 时的样子
         */
        // Using an EnumMap to associate data with an enum (Page 172)
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println("-----------  plantsByLifeCycle  -----------");
        System.out.println(plantsByLifeCycle);

        // Naive stream-based approach - unlikely to produce an EnumMap!  (Page 172)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));

        /**
         * 　通过使用 stream（详见第 45 条）来管理 Map，可以进一步缩短以前的程序。
         * 以下是最简单的基于 stream 的代码，它们在很大程度上重复了前面示例的行为：
         */

        // Using a stream and an EnumMap to associate data with an enum (Page 173)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet())));
    }

}
