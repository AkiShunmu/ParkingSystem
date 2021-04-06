package com.education.shun.util;

import com.education.shun.controller.UserController;
import com.education.shun.entity.User;

import javax.swing.*;

/**
 * @program: ParkingSystem
 * @description: 输入校验
 * @author: qishun zhou
 * @create: 2021-04-02 13:35
 **/

public class CheckUtil {

    /**
     * 非空校验
     * @param username  用户名
     * @param password  密码
     * @param validate  验证码
     */
    public static boolean isNull(String username, String password, String validate) {
        // 判断用户名是否为空
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断密码是否为空
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断密码是否为空
        if (validate.isEmpty()) {// 判断验证码是否为空
            JOptionPane.showMessageDialog(null, "验证码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 登录合法性校验
     * @param username  用户名
     * @param password  密码
     * @param validate  系统验证码
     * @param infoCode  键入验证码
     */
    public static boolean isRational(String username, String password, String validate, String infoCode) {
        User user = new UserController().userFind(username);
        // 如果用户名不存在则进行提示
        if (user == null || !user.getUserName().equals(username)) {
            JOptionPane.showMessageDialog(null, "用户名不存在！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 如果密码错误则进行提示
        if (!user.getUserPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "密码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 如果校验码不匹配则进行提示
        if (!validate.equalsIgnoreCase(infoCode)) {
            JOptionPane.showMessageDialog(null, "验证码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
