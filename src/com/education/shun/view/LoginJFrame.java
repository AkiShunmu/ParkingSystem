package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.swing.*;
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

    JButton bt_Return = new JButton("返回");

    @Override
    public void view() {

        super.publicView();

        //按钮样式设置
        bt_Return.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        bt_Return.setBackground(new Color(874874));
        bt_Return.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        bt_Return.addActionListener(this);
        //在窗口中添加按钮
        super.add(bt_Return);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_Return) {
            this.dispose();
            new MenuJFrame().view();
        }
    }

}
