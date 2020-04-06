package basis.proxy.cglib;

import basis.proxy.User;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理实例都有一个关联的InvocationHandler，在代理实例上调用方法时，
 * 方法调用将被转发到InvocationHandler的invoke方法。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:22
 */
public class UserServiceInterceptor implements MethodInterceptor {

    private static Logger logger = LoggerFactory.getLogger(UserServiceInterceptor.class);


    /**
     * 动态代理对象的方法调用都会转发到intercept方法进行增强。
     *
     * @param obj
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        // 前置增强
        System.out.println("----------------------CGLIB 前置增强-------------------");
        if (args != null && args.length > 0 && args[0] instanceof User) {
            User user = (User) args[0];
            if (user.getName().trim().length() <= 1) {
                throw new RuntimeException("用户姓名输入长度需要大于1！");
            }
        }

        // 调用被继承对象(父类）的方法执行
        Object ret = methodProxy.invokeSuper(obj, args);

        //后置增强
        System.out.println("----------------------CGLIB 后置增强-------------------");
        logger.info("数据库操作成功");
        return ret;
    }
}
