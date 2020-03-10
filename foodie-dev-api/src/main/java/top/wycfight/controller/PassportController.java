package top.wycfight.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.pojo.Users;
import top.wycfight.pojo.bo.UserBO;
import top.wycfight.service.UserService;
import top.wycfight.utils.CookieUtils;
import top.wycfight.utils.JSONResult;
import top.wycfight.utils.JsonUtils;
import top.wycfight.utils.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-02-28 17:36
 * @modify By:
 **/
@Api(tags = "用于注册登录的相关接口", value = "用户相关")
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    @GetMapping("usernameIsExist")
    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    public JSONResult usernameIsExist(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名不能为空");
        }
        boolean isExist = userService.queryUsernameExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }
        return JSONResult.ok();
    }

    /**
     * 用户注册
     *
     * @return
     */
    @PostMapping("regist")
    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    public JSONResult regist(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
            return JSONResult.errorMsg("用户名密码不能为空");
        }
        // 判断用户名是否已经被使用
        boolean isExist = userService.queryUsernameExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }
        // 判断密码是否大于6位
        if (password.length() < 6) {
            return JSONResult.errorMsg("密码必须大于6位");
        }

        // 判断两次密码输入是否一致
        if (!password.equals(confirmPassword)) {
            return JSONResult.errorMsg("两次密码必须输入一致");
        }

        Users user = userService.createUser(userBO);
        user = setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return JSONResult.ok();
    }


    /**
     * 用户注册
     *
     * @return
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    public JSONResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名密码不能为空");
        }
        try {
            password = MD5Utils.getMD5Str(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Users users = userService.queryUserFromLogin(username, password);
        if (users == null) {
            return JSONResult.errorMsg("用户名或密码错误");
        }
        users = setNullProperty(users);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(users),  true);
        return JSONResult.ok(users);
    }

    private Users setNullProperty(Users users) {
        users.setPassword(null);
        users.setBirthday(null);
        users.setUpdatedTime(null);
        users.setCreatedTime(null);
        users.setEmail(null);
        users.setMobile(null);
        users.setRealname(null);
        return users;
    }

    /**
     * 用户退出
     *
     * @return
     */
    @PostMapping("logout")
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    public JSONResult logout(@RequestParam String userId, HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");
        return JSONResult.ok();
    }
}
