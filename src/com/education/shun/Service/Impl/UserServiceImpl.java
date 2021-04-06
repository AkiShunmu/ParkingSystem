package com.education.shun.Service.Impl;

import com.education.shun.Service.IUserService;
import com.education.shun.dao.UserMapper;
import com.education.shun.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: ParkingSystem
 * @description: 用户信息业务实现
 * @author: qishun zhou
 * @create: 2021-04-03 15:54
 **/


public class UserServiceImpl implements IUserService {

    private UserMapper userMapper = new UserMapper();

    @Override
    public User userFind(String userName) {
        return userMapper.userFind(userName);
    }

    @Override
    public List<User> userFindAll() {
        return userMapper.userFindAll();
    }

    @Override
    public boolean userInsert(String id, String userName, String userPassword, String email, Integer saveUser ,String loginCont) {
        /*Map<String, String> param = new HashMap();
        param.put("id", id);*/
        return userMapper.userInsert(id, userName, userPassword, email, saveUser ,loginCont);
    }

    @Override
    public void setSaveUser(Integer saveUser, String userName) {
        userMapper.setSaveUser(saveUser, userName);
    }

    @Override
    public List getSaveUser() {
        if (userMapper.getSaveUser() != null) {
            List list = new ArrayList();
            list.add(userMapper.getSaveUser().getUserName());
            list.add(userMapper.getSaveUser().getUserPassword());
            return list;
        }
        return null;
    }
}
