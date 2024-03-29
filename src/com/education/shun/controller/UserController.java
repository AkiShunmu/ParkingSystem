package com.education.shun.controller;

import com.education.shun.Service.IUserService;
import com.education.shun.Service.Impl.UserServiceImpl;
import com.education.shun.dao.UserMapper;
import com.education.shun.entity.User;
import org.junit.Test;

import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 用户信息控制类
 * @author: qishun zhou
 * @create: 2021-04-03 15:52
 **/

public class UserController {

    public UserServiceImpl userService = new UserServiceImpl();

    //查找
    public User userFind(String userName) {
        return userService.userFind(userName);
    }

    public List<User> userFindAll() {
        return userService.userFindAll();
    }

    public boolean userInsert(String id, String userName, String userPassword, String email, Integer saveUser) {
        return userService.userInsert(id, userName, userPassword, email, saveUser);
    }

    public void setSaveUser(Integer saveUser, String userName) {
        userService.setSaveUser(saveUser, userName);
    }

    public List getSaveUser() {
        return userService.getSaveUser();
    }

    public List<User> getAllSaveUser() {
        return userService.getAllSaveUser();
    }

    //单元测试01
    @Test
    public void test01() {
        UserController userController = new UserController();
//        userController.userFind("123");
//        userController.userFindAll();
//        userController.userInsert();
        userController.setSaveUser(0, "123");
        userController.setSaveUser(0, "abc");
//        userController.getSaveUser();
//        System.out.println(userController.getAllSaveUser());
    }

}
