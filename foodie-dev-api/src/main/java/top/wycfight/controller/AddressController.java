package top.wycfight.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.pojo.UserAddress;
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
    public JSONResult list(@ApiParam(name = "keywords", value = "关键字", required = true)
                                   @RequestParam(value = "userId") String userId
                                  ) {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("用户信息为空");
        }
        List<UserAddress> userAddresses = addressService.queryAdreesByUserId(userId);
        return JSONResult.ok(userAddresses);
    }
}
