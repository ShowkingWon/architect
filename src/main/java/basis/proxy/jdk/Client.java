package basis.proxy.jdk;

import basis.proxy.User;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理演示。
 *  在运行期创建指定接口或者类的子类（动态代理）以及其实例对象的技术，通过这个技术可以无侵入性的为代码进行增强。
 *
 *
 *   Proxy:  所有代理的父类。通过静态方法
 *      Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *      创建动态代理的class对象和实例。
 *
 *      loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
 *      interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，
 *      那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
 *      h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
 *
 *
 *   InvocationHandler：
 *      每个动态代理实例都有一个关联的InvocationHandler，在代理实例上调用方法时，
 *      方法调用将被转发到InvocationHandler的invoke方法。
 *      InvocationHandler接口 只有如下一个方法
 *      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 *
 *      proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
 *      method:我们所要调用某个对象真实的方法的Method对象
 *      args:指代代理对象方法传递的参数
 *
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

        UserService userService = new UserServiceImpl();
        UserServiceInterceptor interceptor = new UserServiceInterceptor(userService);

        // 通过Proxy的静态方法，创建动态代理的class对象和实例。

        // loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载


        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),interceptor);

        // 调用代理的方法
        proxy.addUser(user);


        System.out.println("---------------------------");

    }
}
