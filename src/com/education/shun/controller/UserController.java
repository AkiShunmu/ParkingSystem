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
    public void userFind() {
        User user = userService.userFind("123");
        System.out.println("user = " + user);
    }

    public void userFindAll() {
        List<User> userList = userService.userFindAll();
        System.out.println("userList = " + userList);
    }

    public void userInsert() {
        boolean bl = userService.userInsert("1002", "abc", "abc", "2", "118@qq.com");
        System.out.println("bl = " + bl);
    }

    //单元测试01
    @Test
    public void test01() {
        UserController userController = new UserController();
//        userController.userFind();
//        userController.userFindAll();
        userController.userInsert();
    }

}
