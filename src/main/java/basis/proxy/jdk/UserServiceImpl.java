package basis.proxy.jdk;

import basis.proxy.User;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:17
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        System.out.println("用户数据入库成功，数据为： " + user.toString());
    }
}
