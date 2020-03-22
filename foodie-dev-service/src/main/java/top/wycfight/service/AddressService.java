package top.wycfight.service;

import top.wycfight.pojo.UserAddress;
import top.wycfight.pojo.bo.AddressBO;

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

    /**
     * 添加用户收获地址
     * @param addressBO 地址实体
     */
    void addNewAddress(AddressBO addressBO);

    /**
     * 更新用户收获地址
     * @param addressBO 地址实体
     */
    void updateAddress(AddressBO addressBO);

    /**
     * 删除收货地址
     * @param userId 用户ID
     * @param addressId 收获地址id
     */
    void deleteAddress(String userId, String addressId);

    /**
     * 更新用户收获地址
     * @param userId
     * @param addressId
     */
    void updateUserAddressToBeAddress(String userId, String addressId);
}
