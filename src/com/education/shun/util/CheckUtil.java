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
     * 登录合法性校验
     * @param userName  用户名
     * @param password  密码
     * @param validate  系统验证码
     * @param infoCode  键入验证码
     */
    public static boolean isLoginRational(String userName, String password, String validate, String infoCode) {
        User user = new UserController().userFind(userName);
        // 判断用户名是否为空
        if (userName.isEmpty() || userName.equals("  请输入用户名")) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断密码是否为空
        if (password.isEmpty() || password.equals("  请输入密码")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断验证码是否为空
        if (infoCode.isEmpty() || infoCode.equals("  请输入验证码")) {
            JOptionPane.showMessageDialog(null, "验证码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            // 如果校验码不匹配则进行提示
            if (!validate.equalsIgnoreCase(infoCode)) {
                JOptionPane.showMessageDialog(null, "验证码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        // 如果用户名不存在则进行提示
        if (user == null || !user.getUserName().equals(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不存在！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 如果密码错误则进行提示
        if (!user.getUserPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "密码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 注册合法性校验
     * @param userName  用户名
     * @param password  密码
     * @param isPassword  确认密码
     * @param email  邮箱
     */
    public static boolean isRegisterRational(String userName, String password, String isPassword, String email) {
        // 判断用户名是否为空
        if (userName.isEmpty() || userName.equals("  5~16位数字、下划线或字母")) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 校验用户名是否合法
        if (!userName.matches("\\w{5,16}")) {
            JOptionPane.showMessageDialog(null, "请输入合法的用户名！(5~16位数字、下划线或字母)",
                    "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断密码是否为空
        if (password.isEmpty() || password.equals("  6~16位的字母加数字的组合")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 校验密码是否合法
        if (!password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")) {
            JOptionPane.showMessageDialog(null, "请输入合法的密码！(6~16位的字母加数字的组合)",
                    "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断确认密码是否为空
        if (isPassword.isEmpty() || isPassword.equals("  再次输入密码")) {
            JOptionPane.showMessageDialog(null, "确认密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 校验两次输入的密码是否相同
        if (!password.equals(isPassword)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不同！",
                    "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 判断邮箱是否为空
        if (email.isEmpty() || email.equals("  邮箱地址")) {
            JOptionPane.showMessageDialog(null, "邮箱不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 校验电子邮箱是否合法
        if (!email.matches("\\w+@\\w+.+\\w")) {
            JOptionPane.showMessageDialog(null, "请输入合法的电子邮箱！",
                    "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // 校验用户名是否存在
        if (new UserController().userFind(userName) != null) {
            JOptionPane.showMessageDialog(null, "用户名已经存在！ ",
                    "警告信息", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isRegisterSuccess(String userName, String password, String email) {
        //数据库添加用户
        UserController userController = new UserController();
        String userId = 1001 + userController.userFindAll().size() + "";
        if (userController.userInsert(userId, userName, password, email, 0)) {
            JOptionPane.showMessageDialog(null, "注册成功! ");
            return true;
        }
        return false;
    }

}
