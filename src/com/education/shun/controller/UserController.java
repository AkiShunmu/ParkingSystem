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

    public void userInsert() {
        /*boolean bl = userService.userInsert("1002", "abc", "abc", "2", "118@qq.com");
        System.out.println("bl = " + bl);*/
    }

    public void setSaveUser(Integer saveUser, String userName) {
        userService.setSaveUser(saveUser, userName);
    }

    public List getSaveUser() {
        return userService.getSaveUser();
    }

    //单元测试01
    @Test
    public void test01() {
        UserController userController = new UserController();
//        userController.userFind("123");
//        userController.userFindAll();
//        userController.userInsert();
        userController.setSaveUser(1, "123");
        userController.getSaveUser();
    }

}
