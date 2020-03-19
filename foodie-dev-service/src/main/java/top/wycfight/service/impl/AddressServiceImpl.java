package top.wycfight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.mapper.UserAddressMapper;
import top.wycfight.pojo.UserAddress;
import top.wycfight.service.AddressService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 地址Service
 * @create: 2020-03-19 07:54
 * @modify By:
 **/
@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> queryAdreesByUserId(String userId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        userAddressMapper.select(address);
    }
}
