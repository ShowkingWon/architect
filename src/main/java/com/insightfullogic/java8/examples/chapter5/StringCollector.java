package com.insightfullogic.java8.examples.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


/**
 * 自定义收集器
 *
 * 在这里我有必要重申，这些代码只作教学用途，和 joining 收集器的内部实现略有出入。
 * 读者也许会认为 StringCombiner 看起来非常有用，别担心——你没必要亲自去编写，Java8 有一个
 * java.util.StringJoiner 类，它的作用和 StringCombiner 一样，有类似的 API。
 *
 *
 *Collector<String, StringCombiner, String>
 *     第一个参数： 待收集元素的类型
 *     第二个参数： 累加器的类型
 *     第三个参数： 最终结果的类型
 *
 *一个收集器由4部分组成
 *  首先是一个Supplier，这是一个工厂方法，用来创建容器。 在该例子中就是StringCombiner。
 *  和reduce操作的第一个参数类似，它是后续操作的初值
 *
 *  收集器的 accumulator 的作用和 reduce 操作的第二个参数一样，它结合之前操作的结果
 *  和当前值，生成并返回新的值。这一逻辑已经在 StringCombiners 的 add 方法中得以实现，
 *  直接引用就好了（如例 5-27 所示）。
 *
 *
 */
// BEGIN class_def
public class StringCollector implements Collector<String, StringCombiner, String> {
// END class_def

    /**
     * 特征是一组描述收集器的对象，框架可以对其适当优化。characteristics 方法定义了特征。
     */
    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }


    /**
     * Supplier是创建容器的工厂。
     *
     *  首先是一个Supplier，这是一个工厂方法，用来创建容器。 在该例子中就是StringCombiner。
     *  和reduce操作的第一个参数类似，它是后续操作的初值
     * @return
     */
    @Override
    // BEGIN supplier
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }
    // END supplier


    /**
     * accumulator 是一个函数，它将当前元素叠加到收集器
     *
     * 收集器的 accumulator 的作用和 reduce 操作的第二个参数一样，它结合之前操作的结果和当前值，生成并返回新的值。
     *
     * 这一逻辑已经在 StringCombiners 的 add 方法中得以实现，直接引用就好了（如例 5-27 所示）。
     *
     * @return
     */
    @Override
    // BEGIN accumulator
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }
    // END accumulator


    /**
     * combiner 合并两个容器
     *
     * combine 方法很像 reduce 操作的第三个方法。如果有两个容器，我们需要将其合并。
     * 同样，在前面的重构中我们已经实现了该功能，直接使用 StringCombiner.merge 方法就行了.
     *
     * 在收集阶段，容器被 combiner 方法成对合并进一个容器，直到最后只剩一个容器为止
     *
     * @return
     */
    @Override
    // BEGIN combiner
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }
    // END combiner


    /**
     *finisher 方法返回收集操作的最终结果
     *
     * 收集器的 finisher 方法作用相同。我们已经将流中的值叠加入一个可变容器中，但这还不
     * 是我们想要的最终结果。这里调用了 finisher 方法，以便进行转换。在我们想创建字符串
     * 等不可变的值时特别有用，这里容器是可变的。
     *
     * @return
     */
    @Override
    // BEGIN finisher
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }
    // END finisher

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
