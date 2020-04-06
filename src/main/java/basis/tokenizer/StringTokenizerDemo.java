package basis.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 字符串词法分析的类 StringTokenizer ,目的是将对字符串进行分解的方法进行封装，以简化应用程序设计过程中的工作量.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2020-02-19  19:43
 */
public class StringTokenizerDemo {

    public static void main(String[] args) {
        String original = "aaa                     bb          cc  dd  ee";
        StringTokenizer whitespaceStripper = new StringTokenizer(original);
        StringBuilder builder = new StringBuilder();
        while (whitespaceStripper.hasMoreTokens()) {
            builder.append(whitespaceStripper.nextToken());
            builder.append(" ");
        }
        System.out.println(builder.toString());


        /**
         * foreach 循环空List没问题，但是如果list如果是null，会跑出空指针异常
         */
        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println("s = " + s);
        }

    }
}
