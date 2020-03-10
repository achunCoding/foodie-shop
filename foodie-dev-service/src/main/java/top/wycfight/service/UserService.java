package top.wycfight.service;

import top.wycfight.pojo.Users;
import top.wycfight.pojo.bo.UserBO;

/**
 * @author: wycfight@163.com
 * @description: UserService
 * @create: 2020-02-28 17:27
 * @modify By:
 **/
public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return
     */
    boolean queryUsernameExist(String username);

    Users createUser(UserBO userBO);

    Users queryUserFromLogin(String username, String password);
}
