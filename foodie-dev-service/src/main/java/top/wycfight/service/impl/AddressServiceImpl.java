package top.wycfight.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.wycfight.enums.YesOrNo;
import top.wycfight.mapper.UserAddressMapper;
import top.wycfight.pojo.UserAddress;
import top.wycfight.pojo.bo.AddressBO;
import top.wycfight.service.AddressService;

import java.util.Date;
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
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserAddress> queryAdreesByUserId(String userId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        return userAddressMapper.select(address);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addNewAddress(AddressBO addressBO) {
        int isDefault = YesOrNo.yes.type;
        List<UserAddress> userAddresses = queryAdreesByUserId(addressBO.getUserId());
        if (!CollectionUtils.isEmpty(userAddresses)) {
            isDefault = YesOrNo.no.type;
        }
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        userAddress.setIsDefault(isDefault);
        userAddressMapper.insertSelective(userAddress);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);
        userAddress.setId(addressId);
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setId(addressId);
        userAddressMapper.delete(userAddress);
    }

    @Override
    public void updateUserAddressToBeAddress(String userId, String addressId) {
        // 首先都更新为不是默认收获地址
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setIsDefault(YesOrNo.no.type);
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
        // 将addressId更新为默认地址
        userAddress.setId(addressId);
        userAddress.setIsDefault(YesOrNo.yes.type);
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }
}
