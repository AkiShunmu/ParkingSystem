package com.education.shun.view;

import com.education.shun.Interface.IJFrame;
import com.education.shun.controller.UserController;
import com.education.shun.util.CheckUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
        jtUserName.setBounds(280, 105, 300, 40);
        jtUserName.setFont(new Font("宋体", Font.BOLD, 20));
        jtUserName.setColumns(15);
        jtUserName.setToolTipText("----请输入用户名(5~16位数字、下划线或字母)");
        jtUserName.setText("  5~16位数字、下划线或字母");
        jtUserName.setForeground(new Color(204,204,204));
        //设置焦点监听
        jtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jtUserName.getText().equals("  5~16位数字、下划线或字母")){
                    jtUserName.setText("");
                    jtUserName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jtUserName.getText().length()<1){
                    jtUserName.setText("  5~16位数字、下划线或字母");
                    jtUserName.setForeground(new Color(204,204,204));
                }
            }
        });
        jpPassword = new JPasswordField(10);
        jpPassword.setBounds(280, 205, 300, 40);
        jpPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpPassword.setColumns(15);
        jpPassword.setToolTipText("----请输入密码(6~16位的字母加数字的组合)");
        jpPassword.setEchoChar('\0');
        jpPassword.setText("  6~16位的字母加数字的组合");
        jpPassword.setForeground(new Color(204,204,204));
        //设置焦点监听
        jpPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jpPassword.getText().equals("  6~16位的字母加数字的组合")){
                    jpPassword.setText("");
                    jpPassword.setForeground(Color.BLACK);
                    jpPassword.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jpPassword.getText().length()<1){
                    jpPassword.setText("  6~16位的字母加数字的组合");
                    jpPassword.setForeground(new Color(204,204,204));
                    jpPassword.setEchoChar('\0');
                }
            }
        });
        jpIsPassword = new JPasswordField(10);
        jpIsPassword.setBounds(280, 305, 300, 40);
        jpIsPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpIsPassword.setColumns(15);
        jpIsPassword.setToolTipText("----请输入与上面一致的密码");
        jpIsPassword.setText("  再次输入密码");
        jpIsPassword.setForeground(new Color(204,204,204));
        jpIsPassword.setEchoChar('\0');
        //设置焦点监听
        jpIsPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jpIsPassword.getText().equals("  再次输入密码")){
                    jpIsPassword.setText("");
                    jpIsPassword.setForeground(Color.BLACK);
                    jpIsPassword.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jpIsPassword.getText().length()<1){
                    jpIsPassword.setText("  再次输入密码");
                    jpIsPassword.setForeground(new Color(204,204,204));
                    jpIsPassword.setEchoChar('\0');
                }
            }
        });
        jtEmail = new JTextField(10);
        jtEmail.setBounds(280, 405, 300, 40);
        jtEmail.setFont(new Font("宋体", Font.BOLD, 20));
        jtEmail.setColumns(15);
        jtEmail.setToolTipText("----请输入邮箱地址");
        jtEmail.setText("  邮箱地址");
        jtEmail.setForeground(new Color(204,204,204));
        //设置焦点监听
        jtEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jtEmail.getText().equals("  邮箱地址")){
                    jtEmail.setText("");
                    jtEmail.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jtEmail.getText().length()<1){
                    jtEmail.setText("  邮箱地址");
                    jtEmail.setForeground(new Color(204,204,204));
                }
            }
        });

        //按钮样式设置
        btRegister = new JButton("注册");
        btRegister.setBounds(370, 505, 120, 50);
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
            //合法性校验
            if (CheckUtil.isRegisterRational(jtUserName.getText(), jpPassword.getText(), jpIsPassword.getText(), jtEmail.getText())) {
                //注册用户
                if (CheckUtil.isRegisterSuccess(jtUserName.getText(), jpPassword.getText(), jtEmail.getText())) {
                    this.dispose();
                    new MenuJFrame().view();
                }
            }
        }
    }
}
