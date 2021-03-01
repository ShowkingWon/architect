package jdk8.lambdas;

/**
 * 方法/函数引用演示.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-02  0:14
 */
public class MethodReferenceDemo {

    @FunctionalInterface
    private interface Calculator {
        int calculate(int x, int y);
    }


    public static void main(String[] args) {
//        Calculator calculator = (x, y) -> {
//            if (x > y) {
//                return x - y;
//            } else {
//                return y - x;
//            }
//        };
//
//        System.out.println(calculator.calculate(1, 2));


        //Calculator calculator = (x, y) -> calculate(x, y);
        // 静态方法引用   类:: 静态方法
        Calculator calculator = MethodReferenceDemo::calculate;
        System.out.println(calculator.calculate(1, 2));

        //非静态方法引用  对象实例::非静态方法
        Calculator calculator2 =  new MethodReferenceDemo()::calculate2;

    }


    private static int calculate(int x, int y) {
        if (x > y) {
            return x - y;
        } else {
            return y - x;
        }
    }

    private int calculate2(int x, int y) {
        if (x > y) {
            return x - y;
        } else {
            return y - x;
        }
    }
}
