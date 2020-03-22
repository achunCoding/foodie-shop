package top.wycfight.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.pojo.UserAddress;
import top.wycfight.pojo.bo.AddressBO;
import top.wycfight.service.AddressService;
import top.wycfight.utils.JSONResult;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: Hello Demo
 * @create: 2020-02-26 18:19
 * @modify By:
 **/
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RestController
@RequestMapping("address")
public class AddressController {


    @Autowired
    private AddressService addressService;


    /**
     * 用户在订单页，可以针对收货地址如下操作
     * 1.查询用户的所有收获地址
     * 2.新增收获地址
     * 3.删除收获地址
     * 4.修改收获地址
     * 5.设置默认地址
     */

    /**
     * 查询商品列表
     *
     * @return
     */
    @PostMapping("list")
    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    public JSONResult list(@ApiParam(name = "userId", value = "用户ID", required = true)
                           @RequestParam(value = "userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("用户信息为空");
        }
        List<UserAddress> userAddresses = addressService.queryAdreesByUserId(userId);
        return JSONResult.ok(userAddresses);
    }

    /**
     * 添加收获地址
     *
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加收获地址", notes = "添加收获地址", httpMethod = "POST")
    public JSONResult add(@RequestBody AddressBO addressBO) {
        JSONResult result = checkAddress(addressBO);
        if (result.getStatus() != 200) {
            return result;
        }
        addressService.addNewAddress(addressBO);
        return JSONResult.ok();
    }

    /**
     * 更新收获地址
     *
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "更新收获地址", notes = "更新收获地址", httpMethod = "POST")
    public JSONResult update(@RequestBody AddressBO addressBO) {
        JSONResult result = checkAddress(addressBO);
        String addressId = addressBO.getAddressId();
        if (StringUtils.isBlank(addressId)) {
            return JSONResult.errorMsg("修改失败");
        }
        int successStatus = 200;
        if (result.getStatus() != successStatus) {
            return result;
        }
        addressService.updateAddress(addressBO);
        return JSONResult.ok();
    }


    /**
     * 更新收获地址
     *
     * @return
     */
    @PostMapping("delete")
    @ApiOperation(value = "删除收货地址", notes = "删除收货地址", httpMethod = "POST")
    public JSONResult delete(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JSONResult.errorMsg("删除失败");
        }
        addressService.deleteAddress(userId, addressId);
        return JSONResult.ok();
    }

    /**
     * 设置默认收获地址
     *
     * @return
     */
    @PostMapping("setDefault")
    @ApiOperation(value = "设置默认收获地址", notes = "设置默认收获地址", httpMethod = "POST")
    public JSONResult setDefault(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JSONResult.errorMsg("设置失败");
        }
        addressService.updateUserAddressToBeAddress(userId, addressId);
        return JSONResult.ok();
    }

    private JSONResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return JSONResult.errorMsg("收货人不能为空");
        }
        int receiverLength = 12;
        if (receiver.length() > receiverLength) {
            return JSONResult.errorMsg("收货人姓名不能太长");
        }
        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return JSONResult.errorMsg("收货人手机号码不能为空");
        }
        int mobileLength = 11;
        if (mobile.length() != mobileLength) {
            return JSONResult.errorMsg("收货人手机号长度不正确");
        }
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        String province = addressBO.getProvince();
        if (StringUtils.isBlank(city) || StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail) || StringUtils.isBlank(province)) {
            return JSONResult.errorMsg("收货地址不能为空");
        }
        return JSONResult.ok();
    }

}
