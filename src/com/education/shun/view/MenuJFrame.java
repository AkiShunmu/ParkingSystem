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

    private JButton btLogin = new JButton("登录");
    private JButton btExplain = new JButton("说明");
    private JButton btQuit = new JButton("退出");
    //        JButton bt_Play = new JButton("开始");

    @Override
    public void view() {

        JPanel jpBgImage = new JPanel();
        JPanel jpButton = new JPanel();
        JPanel jpLogin = new JPanel();

        super.publicView();

        //按钮容器格式
        /*jp_Button.setSize(150,720);
        jp_Button.setLayout(new GridLayout(3,1,20,20));
        jp_Button.setLayout(null);*/

        //登录按钮样式
        btLogin.setBounds(super.getX(), 100, 150,70);
        btLogin.setBackground(new Color(999999999));
        btLogin.setFont(new Font("楷体", Font.PLAIN, 30));
        //bt_Login.setContentAreaFilled(true);    //按钮透明设置失败
        //注册按钮样式
        btExplain.setBounds(super.getX(), 250, 150,70);
        btExplain.setBackground(new Color(888888888));
        btExplain.setFont(new Font("楷体", Font.PLAIN, 30));
        //退出按钮样式
        btQuit.setBounds(super.getX(), 400, 150,70);
        btQuit.setBackground(new Color(123123123));
        btQuit.setFont(new Font("楷体", Font.PLAIN, 30));


        //添加按钮
        super.add(btLogin);
        super.add(btExplain);
        super.add(btQuit);
        //按钮点击事件
        btLogin.addActionListener(this);
        btExplain.addActionListener(this);
        btQuit.addActionListener(this);

    }

    //按钮点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //登录事件
        if (e.getSource() == btLogin) {
            this.dispose();
            new LoginJFrame().view();
        }
        //说明事件
        if (e.getSource() == btExplain) {
            System.out.println("说明");
            /*this.dispose();
            new RegisterJFrame().view();*/
        }
        //退出
        if (e.getSource() == btQuit) {
            System.exit(0);
        }
    }

}
