package com.education.shun.util;

import com.education.shun.controller.UserController;
import com.education.shun.entity.User;

import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 保存用户工具类
 * @author: qishun zhou
 * @create: 2021-04-06 16:06
 **/

public class SaveUserUtil {

    private static UserController userController = new UserController();
    private static final Integer ON_SAVE = 1;
    private static final Integer OFF_SAVE = 0;

    public static List getSaveUser() {
        return userController.getSaveUser();
    }

    public static List<User> getAllSaveUser() {
        return userController.getAllSaveUser();
    }

    public static void onSaveUser(String userName) {
        userController.setSaveUser(ON_SAVE, userName);
    }

    public static void offSaveUser(String userName) {
        userController.setSaveUser(OFF_SAVE, userName);
    }

}
