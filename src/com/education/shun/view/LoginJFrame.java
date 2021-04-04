package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: ParkingSystem
 * @description: 登录窗口
 * @author: qishun zhou
 * @create: 2021-03-31 21:56
 **/

public class LoginJFrame extends PublicJFrame implements IJFrame,ActionListener {

    private JLabel jlUserName,jlPassword,jlCode;
    private JTextField jtUserName,jtCode;
    private JPasswordField jpPassword;
    private JButton btLogin,btRegister;
    private JCheckBox jcPassword;
    private JButton btReturn;

    @Override
    public void view() {

        super.publicView();

        //字体样式设置
        jlUserName = new JLabel("用户名:");
        jlUserName.setFont(new Font("宋体", Font.BOLD, 25));
        jlUserName.setForeground(Color.red);
        jlUserName.setBounds(150, 100, 100, 50);
        jlPassword = new JLabel("密码:");
        jlPassword.setFont(new Font("宋体", Font.BOLD, 25));
        jlPassword.setForeground(Color.red);
        jlPassword.setBounds(150, 200, 100, 50);
        jlCode = new JLabel("验证码:");
        jlCode.setFont(new Font("宋体", Font.BOLD, 25));
        jlCode.setForeground(Color.red);
        jlCode.setBounds(150, 300, 100, 50);

        //输入框样式设置
        jtUserName = new JTextField(10);
        jtUserName.setBounds(270, 105, 200, 40);
        jtUserName.setFont(new Font("宋体", Font.BOLD, 20));
        jtUserName.setColumns(15);
        jtCode = new JTextField(10);
        jtCode.setBounds(270, 205, 200, 40);
        jtCode.setFont(new Font("宋体", Font.BOLD, 20));
        jtCode.setColumns(15);
        jpPassword = new JPasswordField(10);
        jpPassword.setBounds(270, 305, 200, 40);
        jpPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpPassword.setColumns(15);

        //按钮样式设置
        btLogin = new JButton("登录");
        btLogin.setFont(new Font("微软雅黑", Font.BOLD, 20));
        btLogin.setForeground(Color.black);
        btLogin.setBounds(270, 405, 120, 50);
        btRegister = new JButton("注册");
        btRegister.setFont(new Font("微软雅黑", Font.BOLD, 20));
        btRegister.setForeground(Color.black);
        btRegister.setBounds(470, 405, 120, 50);
        //返回按钮
        btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(new Color(87487487));
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));

        //按钮点击事件
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btReturn.addActionListener(this);

        //复选按钮
        jcPassword = new JCheckBox("保存账号", true);
        jcPassword.setFont(new Font("楷体", Font.BOLD, 15));
        jcPassword.setBounds(270, 370, 100,20);
        //获取复选框状态
        jcPassword.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected() == true) {
                    System.out.println("被选中");
                } else {
                    System.out.println("未被选中");
                }
            }
        });

        //添加元素
        super.add(jlUserName);
        super.add(jlPassword);
        super.add(jlCode);
        super.add(jtUserName);
        super.add(jpPassword);
        super.add(jtCode);
        super.add(btLogin);
        super.add(btRegister);
        super.add(btReturn);
        super.add(jcPassword);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogin) {
            System.out.println("开始游戏");
        }
        if (e.getSource() == btRegister) {
            this.dispose();
            new RegisterJFrame().view();
        }
        if (e.getSource() == btReturn) {
            this.dispose();
            new MenuJFrame().view();
        }
    }

}
