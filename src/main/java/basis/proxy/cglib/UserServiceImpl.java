package basis.proxy.cglib;

import basis.proxy.User;
import basis.proxy.jdk.UserService;

/**
 * CGLIB实现方式。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:17
 */
public class UserServiceImpl  {

    /**
     * 创建用户。
     * @param user
     */
    public void addUser(User user) {
        System.out.println("用户数据入库成功，数据为： " + user.toString());
    }
}
