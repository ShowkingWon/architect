package jdk8.lambdas.functional;

/**
 * 多个参数 无返回值的接口。
 *
 * @creator wx
 * @date 2021/3/1 23:30
 * @description
 */
@FunctionalInterface
public interface SomeArgumentsNoReturn {

    void run(int x, int y);

}
