package top.wycfight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import top.n3r.idworker.Sid;
import top.wycfight.enums.Sex;
import top.wycfight.mapper.UsersMapper;
import top.wycfight.pojo.Users;
import top.wycfight.pojo.bo.UserBO;
import top.wycfight.service.UserService;
import top.wycfight.utils.DateUtil;
import top.wycfight.utils.MD5Utils;

import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: UserService实现类
 * @create: 2020-02-28 17:28
 * @modify By:
 **/
@Service
public class UserServiceImpl implements UserService {

    private final String USER_FACE = "http://47.103.9.247:8090/upload/2020/1/sweet-d99b2ba2e33542edbdc6b979f58cd562.jpg";


    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users != null;
    }

    @Override
    public Users createUser(UserBO userBO) {
        Users users = new Users();
        String id = sid.nextShort();
        users.setId(id);
        users.setUsername(userBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.setBirthday(DateUtil.stringToDate("1900-01-01"));
        users.setNickname(userBO.getUsername());
        users.setFace(USER_FACE);
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        usersMapper.insert(users);
        return users;
    }


    @Override
    public Users queryUserFromLogin(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);
        Users users = usersMapper.selectOneByExample(example);
        return users;
    }
}
