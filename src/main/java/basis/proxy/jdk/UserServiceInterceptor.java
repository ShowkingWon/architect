package basis.proxy.jdk;

import basis.proxy.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 每个动态代理实例都有一个关联的InvocationHandler，在代理实例上调用方法时，
 * 方法调用将被转发到InvocationHandler的invoke方法。
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:22
 */
public class UserServiceInterceptor implements InvocationHandler {

    /**
     * 真正提供服务的对象.
     */
    private Object realObject;

    private static Logger logger = LoggerFactory.getLogger(UserServiceInterceptor.class.getName());

    public UserServiceInterceptor(Object realObject) {
        super();
        this.realObject = realObject;
    }

    public Object getRealObject() {
        return realObject;
    }

    public void setRealObject(Object realObject) {
        this.realObject = realObject;
    }


    /**
     *
     * @param proxy     代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * @param method    我们所要调用某个对象真实的方法的Method对象
     * @param args      指代代理对象方法传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 前置增强
        System.out.println("----------------------JDK 前置增强-------------------");
        if (args != null && args.length > 0 && args[0] instanceof User) {
            User user = (User) args[0];
            if (user.getName().trim().length() <= 1) {
                throw new RuntimeException("用户姓名输入长度需要大于1！");
            }
        }

        // 通过反射， 方法执行
        Object ret = method.invoke(realObject, args);

        //后置增强
        System.out.println("----------------------JDK 后置增强-------------------");
        logger.info("数据库操作成功");
        return ret;
    }
}
