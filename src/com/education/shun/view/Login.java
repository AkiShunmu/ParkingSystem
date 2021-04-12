package com.education.shun.view;

import com.education.shun.Interface.WindowMole;
import com.education.shun.entity.User;
import com.education.shun.util.CaptchaCodeUtil;
import com.education.shun.util.CheckUtil;
import com.education.shun.util.ColourUtil;
import com.education.shun.util.SaveUserUtil;
import com.education.shun.view.parent.WindowJFramePublish;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 登录窗口
 * @author: qishun zhou
 * @create: 2021-03-31 21:56
 **/

public class Login extends WindowJFramePublish implements WindowMole,ActionListener {

    private JPanel jpLogin;
    private JLabel jlUserName,jlPassword,jlCodeText,jlCode,jlRTips;
    private JTextField jtUserName,jtCode;
    private JPasswordField jpPassword;
    private JButton btReturn,btLogin,btRegister,btCode;
    private JCheckBox jcPassword;

    private CaptchaCodeUtil codeUtil = new CaptchaCodeUtil();
    private BufferedImage bfCode;
    private Icon icon;
    private String strCode;

    public Login() {
        name = "登录窗口";
        super.view();
        this.view();
    }

    @Override
    public void view() {
        super.bgImage();

        //字体样式设置
        jpLogin = new ColourUtil("登录");
        jpLogin.setBounds(10, 1, 200, 70);
        jlUserName = new JLabel("用户名:");
        jlUserName.setFont(new Font("宋体", Font.BOLD, 25));
        jlUserName.setForeground(Color.cyan);
        jlUserName.setBounds(150, 100, 100, 50);
        jlPassword = new JLabel("密码:");
        jlPassword.setFont(new Font("宋体", Font.BOLD, 25));
        jlPassword.setForeground(Color.cyan);
        jlPassword.setBounds(150, 200, 100, 50);
        jlCodeText = new JLabel("验证码:");
        jlCodeText.setFont(new Font("宋体", Font.BOLD, 25));
        jlCodeText.setForeground(Color.cyan);
        jlCodeText.setBounds(150, 300, 100, 50);
        jlRTips = new JLabel("若没有账号，请点击注册...");
        jlRTips.setFont(new Font("宋体", Font.BOLD, 15));
        jlRTips.setForeground(Color.red);
        jlRTips.setBounds(470, 480, 250, 20);

        //输入框样式设置
        jtUserName = new JTextField(10);
        jtUserName.setBounds(270, 105, 200, 40);
        jtUserName.setFont(new Font("宋体", Font.BOLD, 20));
        jtUserName.setColumns(15);
        jtUserName.setToolTipText("----请输入用户名(账号)");
        jtUserName.setText("  请输入用户名");
        jtUserName.setForeground(new Color(204,204,204));
        //设置焦点监听
        jtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jtUserName.getText().equals("  请输入用户名")){
                    jtUserName.setText("");
                    jtUserName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jtUserName.getText().length()<1){
                    jtUserName.setText("  请输入用户名");
                    jtUserName.setForeground(new Color(204,204,204));
                }
            }
        });
        jtCode = new JTextField(10);
        jtCode.setBounds(270, 305, 200, 40);
        jtCode.setFont(new Font("宋体", Font.BOLD, 20));
        jtCode.setColumns(15);
        jtCode.setToolTipText("----请输入4位数的验证码");
        jtCode.setText("  请输入验证码");
        jtCode.setForeground(new Color(204,204,204));
        //设置焦点监听
        jtCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jtCode.getText().equals("  请输入验证码")){
                    jtCode.setText("");
                    jtCode.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jtCode.getText().length()<1){
                    jtCode.setText("  请输入验证码");
                    jtCode.setForeground(new Color(204,204,204));
                }
            }
        });
        jpPassword = new JPasswordField(10);
        jpPassword.setBounds(270, 205, 200, 40);
        jpPassword.setFont(new Font("宋体", Font.BOLD, 20));
        jpPassword.setColumns(15);
        jpPassword.setEchoChar('\0');
        jpPassword.setText("  请输入密码");
        jpPassword.setForeground(new Color(204,204,204));
        jpPassword.setToolTipText("----请输入用户密码");
        //设置焦点监听
        jpPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
                if(jpPassword.getText().equals("  请输入密码")){
                    jpPassword.setText("");
                    jpPassword.setForeground(Color.BLACK);
                    jpPassword.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
                if(jpPassword.getText().length()<1){
                    jpPassword.setText("  请输入密码");
                    jpPassword.setForeground(new Color(204,204,204));
                    jpPassword.setEchoChar('\0');
                }
            }
        });

        //按钮样式设置
        btLogin = new JButton("开始");
        btLogin.setFont(new Font("微软雅黑", Font.BOLD, 20));
        btLogin.setForeground(Color.black);
        btLogin.setBounds(270, 425, 120, 50);
        btRegister = new JButton("注册");
        btRegister.setFont(new Font("微软雅黑", Font.BOLD, 20));
        btRegister.setForeground(Color.black);
        btRegister.setBounds(470, 425, 120, 50);
        btCode = new JButton("更换");
        btCode.setFont(new Font("楷体", Font.BOLD, 15));
        btCode.setForeground(Color.blue);
        btCode.setBounds(600, 320, 70, 20);
        //返回按钮
        btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(new Color(192, 192, 192));
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btCode.addActionListener(this);
        btReturn.addActionListener(this);
        onCheckBox();

        //验证码
        bfCode = codeUtil.getImage();
        try {
            CaptchaCodeUtil.output(bfCode, new FileOutputStream("src/image/验证码图片.jpg"));
            icon = new ImageIcon(ImageIO.read(new File("src/image/验证码图片.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jlCode = new JLabel(null, icon, JLabel.CENTER);
        jlCode.setBounds(470, 275, 150,100);
        strCode = codeUtil.getText();

        //复选按钮
        jcPassword = new JCheckBox("保存账号", false);
        jcPassword.setFont(new Font("楷体", Font.BOLD, 15));
        jcPassword.setBounds(270, 370, 100,20);
        if (!jcPassword.isSelected()) {
            offCheckBox();
        }
        //获取复选框状态
        jcPassword.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected() == true) {
                    //保证只保存一个用户
                    onCheckBox();
                } else {
                    offCheckBox();
                }
            }
        });

        //添加元素
        super.addElement(jpLogin, jlUserName, jlPassword, jlCodeText, jlCode,
                jlRTips, jtUserName, jpPassword, jtCode, btLogin, btRegister,
                btCode, btReturn, jcPassword);

        //将元素置于最上层
        super.upLayeredPane(jpLogin, jlUserName, jlPassword, jlCodeText, jlCode,
                jlRTips, jtUserName, jpPassword, jtCode, btLogin, btRegister,
                btCode, btReturn, jcPassword);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogin) {
            //合法性校验
            if (CheckUtil.isLoginRational(jtUserName.getText(), jpPassword.getText(), strCode, jtCode.getText())) {
                this.dispose();
                new Function();
            }
        }
        if (e.getSource() == btRegister) {
            this.dispose();
            new Register();
        }
        if (e.getSource() == btCode) {
            //刷新验证码
            bfCode = codeUtil.getImage();
            try {
                CaptchaCodeUtil.output(bfCode, new FileOutputStream("src/image/验证码图片.jpg"));
                icon = new ImageIcon(ImageIO.read(new File("src/image/验证码图片.jpg")));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            jlCode.setIcon(icon);
            strCode = codeUtil.getText();
        }
        if (e.getSource() == btReturn) {
            offCheckBox();
            this.dispose();
            new Menu();
        }
    }

    //选中保存密码
    public void onCheckBox() {
        SaveUserUtil.onSaveUser(jtUserName.getText());
        if (SaveUserUtil.getSaveUser() != null) {
            if (SaveUserUtil.getAllSaveUser().size() > 1) {
                List<User> list = SaveUserUtil.getAllSaveUser();
                for (User user : list) {
                    if (!user.getUserName().equals(jtUserName.getText())) {
                        SaveUserUtil.offSaveUser(user.getUserName());
                    }
                }
            }
            jtUserName.setForeground(Color.black);
            jpPassword.setForeground(Color.black);
            jpPassword.setEchoChar('*');
            jtUserName.setText(SaveUserUtil.getSaveUser().get(0).toString());
            jpPassword.setText(SaveUserUtil.getSaveUser().get(1).toString());
        }
    }

    //非选中不保存密码
    public void offCheckBox() {
        SaveUserUtil.offSaveUser(jtUserName.getText());
    }

}
