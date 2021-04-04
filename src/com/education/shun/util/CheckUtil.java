package com.education.shun.util;

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
    public void isNull(String username, String password, String validate, JFrame jFrame) {
        if (username.isEmpty()) {// 判断用户名是否为空
            JOptionPane.showMessageDialog(jFrame, "用户名不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (new String(password).isEmpty()) {// 判断密码是否为空
            JOptionPane.showMessageDialog(jFrame, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (validate.isEmpty()) {// 判断验证码是否为空
            JOptionPane.showMessageDialog(jFrame, "验证码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

    /**
     * 合理性校验
     * @param username  用户名
     * @param password  密码
     * @param validate  验证码
     */
    public void isRational(String username, String password, String validate) {
        /*if (!DBHelper.exists(username)) {// 如果用户名不存在则进行提示
            JOptionPane.showMessageDialog(this, "用户名不存在！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!DBHelper.check(username, password)) {// 如果密码错误则进行提示
            JOptionPane.showMessageDialog(this, "密码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!validate.equals(randomText)) {// 如果校验码不匹配则进行提示
            JOptionPane.showMessageDialog(this, "验证码错误！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }*/
    }

}
