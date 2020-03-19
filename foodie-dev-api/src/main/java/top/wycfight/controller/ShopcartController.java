package top.wycfight.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.pojo.bo.ShopcartBO;
import top.wycfight.pojo.vo.ShopcartVO;
import top.wycfight.service.ItemService;
import top.wycfight.utils.JSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: Hello Demo
 * @create: 2020-02-26 18:19
 * @modify By:
 **/
@RestController
@Api(tags = "购物车接口相关api", value = "购物车接口Controller")
@RequestMapping("shopcart")
public class ShopcartController {


    @Autowired
    private ItemService itemService;


    /**
     * 购物车添加
     *
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    public JSONResult add(@RequestParam String userId, @RequestBody ShopcartBO shopcartBO,
                               HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("用户未登录");
        }
        return JSONResult.ok();
    }


    /**
     * 购物车添加
     *
     * @return
     */
    @PostMapping("del")
    @ApiOperation(value = "购物车删除商品", notes = "购物车删除商品", httpMethod = "POST")
    public JSONResult del(@RequestParam String userId, @RequestParam String itemSpecId,
                          HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return JSONResult.errorMsg("用户未登录");
        }
        return JSONResult.ok();
    }





}
