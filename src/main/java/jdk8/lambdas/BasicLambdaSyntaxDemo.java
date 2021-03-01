package jdk8.lambdas;

import jdk8.lambdas.functional.*;

/**
 * Lambda 表达式语法演示。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-01  23:37
 */
public class BasicLambdaSyntaxDemo {

    public static void main(String[] args) {

        //1.实现无参无返回值的函数式接口
        NoArgumentNoReturn lambda1 = () -> {
            System.out.println("这是一个无参、无返回值的函数式接口方法...");
        };
        lambda1.run();

        //2.实现一个参数 无返回值的函数式接口
        OneArgumentNoReturn lambda2 = (int x) -> {
            System.out.println("这是一个参数、无返回值的函数式接口方法..., 参数值: " + x);
        };
        lambda2.run(10);

        //3.实现多个参数 无返回值的函数式接口
        SomeArgumentsNoReturn lambda3 = (int x, int y) -> {
            System.out.println("这是一个多个参数、无返回值的函数式接口方法..., 参数1: " + x + ", 参数2: " + y);
        };
        lambda3.run(10, 20);

        //4.实现无参 有返回值的函数式接口
        NoArgumentsSingleReturn lambda4 = () -> {
            System.out.println("这是一个无参、有返回值的函数式接口方法..., 返回值: " + 100);
            return 100;
        };
        lambda4.run();

        //5.实现一个参数 有返回值的函数式接口
        OneArgumentSingleReturn lambda5 = (int x) -> {
            System.out.println("这是一个参数、有返回值的函数式接口方法..., 参数值: " + x + ", 返回值: " + x * x);
            return x * x;
        };
        lambda5.run(100);


        //6.实现多个参数 有返回值的函数式接口
        SomeArgumentsSingleReturn lambda6 = (int x, int y) -> {
            System.out.println("这是多个参数、有返回值的函数式接口方法...,参数1: " + x + ", 参数2: " + y + " ,返回值: " + (x + y));
            return x + y;
        };
        lambda6.run(100, 50);



    }


}
