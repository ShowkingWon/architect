package com.insightfullogic.java8.answers.chapter6;

        import java.util.stream.IntStream;

public class SerialToParallel {


    /**
     * 并行化求和
     * @param range
     * @return
     */
    public static int sumOfSquares(IntStream range) {
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }

    /**
     * 串行化求和
     * @param range
     * @return
     */
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

}
