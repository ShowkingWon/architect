package jdk8.lambdas;

import java.util.stream.Stream;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2020-04-05  11:56
 */
public class Question1 {

    /**
     * 求和函数
     *
     * @param numbers
     * @return
     */
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }
}
