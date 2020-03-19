package top.wycfight.service;

import top.wycfight.pojo.UserAddress;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 地址Service
 * @create: 2020-03-19 07:53
 * @modify By:
 **/
public interface AddressService {
    /**
     * 通过用户id查询所有收货地址
     * @param userId 用户ID
     * @return 收货地址
     */
    List<UserAddress> queryAdreesByUserId(String userId);
}
