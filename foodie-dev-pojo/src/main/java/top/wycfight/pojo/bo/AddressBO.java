package top.wycfight.pojo.bo;

import lombok.Data;
import top.wycfight.pojo.UserAddress;

/**
 * @author: wycfight@163.com
 * @description: 地址实体
 * @create: 2020-03-22 17:21
 * @modify By:
 **/
@Data
public class AddressBO extends UserAddress {
    /**
     * 收获地址id
     */
    private String addressId;

}
