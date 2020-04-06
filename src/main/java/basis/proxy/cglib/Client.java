package basis.proxy.cglib;

import basis.proxy.User;
import net.sf.cglib.proxy.Enhancer;

import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * CGLIB动态代理演示。
 * Code Generation Library. 是一个基于ASM的自己吗生成库，它允许我们在运行时对自己吗进行修改和动态生成。
 * CGLIB是通过继承方式实现代理。
 * <p>
 * Enhancer：
 * 来指定要代理的目标对象，实际处理代理逻辑的对象，最终通过调用create方法得到代理对象，
 * 对这个对象的所有非final方法的调用都会转发给MethodInterceptor。
 * MethodInterceptor:
 * 动态代理对象的方法调用都会转发到intercept方法进行增强。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:33
 */
public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.setName("122");
        user.setAge(22);
        user.setAddress("南京市软件大道170-1号");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.addUser(user);

        System.out.println("---------------------------");


//        String original = "aaa                     bb          cc  dd  ee";
//        StringTokenizer whitespaceStripper = new StringTokenizer(original);
//        StringBuilder builder = new StringBuilder();
//        while (whitespaceStripper.hasMoreTokens()) {
//            builder.append(whitespaceStripper.nextToken());
//            builder.append(" ");
//        }
//        System.out.println(builder.toString());

        int queryStack = 1;
        char[] buffer = new char[queryStack * 2 + 2];
        Arrays.fill(buffer, '=');
        buffer[queryStack * 2 + 1] = ' ';
        if (false) {
            buffer[queryStack * 2] = '>';
        } else {
            buffer[0] = '<';
        }
        System.out.println(new String(buffer));

    }
}
