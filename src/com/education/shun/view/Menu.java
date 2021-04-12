package com.education.shun.view;

import com.education.shun.Interface.WindowMole;
import com.education.shun.view.parent.WindowJFramePublish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: ParkingSystem
 * @description: 主窗口显示
 * @author: qishun zhou
 * @create: 2021-03-31 16:37
 **/

public class Menu extends WindowJFramePublish implements WindowMole,ActionListener {

    private JButton btLogin = new JButton("登录");
    private JButton btExplain = new JButton("说明");
    private JButton btQuit = new JButton("退出");

    public Menu() {
        name = "主界面窗口";
        super.view();
        this.view();
    }

    @Override
    public void view() {
        super.bgImage();

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
        super.addElement(btLogin, btExplain, btQuit);

        //按钮点击事件
        btLogin.addActionListener(this);
        btExplain.addActionListener(this);
        btQuit.addActionListener(this);

        //将元素置于最上层
        super.upLayeredPane(btLogin, btExplain, btQuit);
        //再次调用父类方法刷新背景
        super.view();

    }

    //按钮点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //登录事件
        if (e.getSource() == btLogin) {
            this.dispose();
            new Login();
        }
        //说明事件
        if (e.getSource() == btExplain) {
            System.out.println("说明");
            this.dispose();
            new Function();
            /*this.dispose();
            new RegisterJFrame().view();*/
        }
        //退出
        if (e.getSource() == btQuit) {
            System.exit(0);
        }
    }

}