package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: ParkingSystem
 * @description: 注册界面
 * @author: qishun zhou
 * @create: 2021-03-31 22:46
 **/

public class RegisterJFrame extends PublicJFrame implements IJFrame,ActionListener {

    private JLabel jlUserName,jlPassword,jlIsPassword,jlEmail;
    private JTextField jtUserName,jtEmail;
    private JPasswordField jpPassword,jpIsPassword;
    private JButton btReturn,btRegister;

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
        jlIsPassword = new JLabel("确认密码:");
        jlIsPassword.setFont(new Font("宋体", Font.BOLD, 25));
        jlIsPassword.setForeground(Color.red);
        jlIsPassword.setBounds(150, 300, 120, 50);
        jlEmail = new JLabel("邮箱:");
        jlEmail.setFont(new Font("宋体", Font.BOLD, 25));
        jlEmail.setForeground(Color.red);
        jlEmail.setBounds(150, 400, 100, 50);

        //输入框样式设置
        jtUserName = new JTextField(10);
        jtUserName.setBounds(280, 105, 200, 40);
        jtUserName.setFont(new Font("宋体", Font.BOLD, 20));
        jtUserName.setColumns(15);
        jtEmail = new JTextField(10);
        jtEmail.setBounds(280, 405, 200, 40);
        jtEmail.setFont(new Font("宋体", Font.BOLD, 20));
        jtEmail.setColumns(15);
        jpPassword = new JPasswordField(10);
        jpPassword.setBounds(280, 205, 200, 40);
        jpPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpPassword.setColumns(15);
        jpIsPassword = new JPasswordField(10);
        jpIsPassword.setBounds(280, 305, 200, 40);
        jpIsPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpIsPassword.setColumns(15);

        //按钮样式设置
        btRegister = new JButton("注册");
        btRegister.setBounds(370, 505, 150, 70);
        btRegister.setFont(new Font("微软雅黑", Font.BOLD, 20));
        btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(new Color(87487487));
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        btRegister.addActionListener(this);
        btReturn.addActionListener(this);

        //添加元素
        super.add(jlUserName);
        super.add(jlPassword);
        super.add(jlIsPassword);
        super.add(jlEmail);
        super.add(jtUserName);
        super.add(jpPassword);
        super.add(jpIsPassword);
        super.add(jtEmail);
        super.add(btRegister);
        super.add(btReturn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btReturn) {
            this.dispose();
            new MenuJFrame().view();
        }
        if (e.getSource() == btRegister) {
            System.out.println("注册成功");
        }
    }
}
