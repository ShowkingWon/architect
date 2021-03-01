package jdk8.lambdas.functional;

/**
 * 多个参数 有返回值的接口。
 *
 * @creator wx
 * @date 2021/3/1 23:30
 * @description
 */
@FunctionalInterface
public interface OneArgumentSingleReturn {

    int run(int x);

}
