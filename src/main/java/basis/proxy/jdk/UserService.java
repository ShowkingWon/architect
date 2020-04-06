package basis.proxy.jdk;

import basis.proxy.User;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-11  0:33
 */
public interface UserService {


    /**
     * 创建用户.
     *
     * @param user
     */
    void addUser(User user);
}
