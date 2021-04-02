package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: ParkingSystem
 * @description: 主窗口显示
 * @author: qishun zhou
 * @create: 2021-03-31 16:37
 **/

public class MenuJFrame extends PublicJFrame implements IJFrame,ActionListener {

    JButton bt_Login = new JButton("登录");
    JButton bt_Register = new JButton("注册");
    JButton bt_Quit = new JButton("退出");
    //        JButton bt_Play = new JButton("开始");

    @Override
    public void view() {

        JPanel jp_BgImage = new JPanel();
        JPanel jp_Button = new JPanel();
        JPanel jp_Login = new JPanel();

        super.publicView();

        //按钮容器格式
        /*jp_Button.setSize(150,720);
        jp_Button.setLayout(new GridLayout(3,1,20,20));
        jp_Button.setLayout(null);*/

        //登录按钮样式
        bt_Login.setBounds(super.getX(), 100, 150,70);
        bt_Login.setBackground(new Color(999999999));
        bt_Login.setFont(new Font("楷体", Font.PLAIN, 30));
        //bt_Login.setContentAreaFilled(true);    //按钮透明设置失败
        //注册按钮样式
        bt_Register.setBounds(super.getX(), 250, 150,70);
        bt_Register.setBackground(new Color(888888888));
        bt_Register.setFont(new Font("楷体", Font.PLAIN, 30));
        //退出按钮样式
        bt_Quit.setBounds(super.getX(), 400, 150,70);
        bt_Quit.setBackground(new Color(123123123));
        bt_Quit.setFont(new Font("楷体", Font.PLAIN, 30));


        //添加按钮
        super.add(bt_Login);
        super.add(bt_Register);
        super.add(bt_Quit);
        //按钮点击事件
        bt_Login.addActionListener(this);
        bt_Register.addActionListener(this);
        bt_Quit.addActionListener(this);

    }

    //按钮点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //登录事件
        if (e.getSource() == bt_Login) {
            this.dispose();
            new LoginJFrame().view();
        }
        //注册事件
        if (e.getSource() == bt_Register) {
            this.dispose();
            new RegisterJFrame().view();
        }
        //退出
        if (e.getSource() == bt_Quit) {
            System.exit(0);
        }
    }

}
