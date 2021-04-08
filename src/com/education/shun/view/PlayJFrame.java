package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: ParkingSystem
 * @description: 游戏窗体
 * @author: qishun zhou
 * @create: 2021-04-05 03:21
 **/

public class PlayJFrame extends PublicJFrame implements IJFrame, ActionListener {

    private JButton btReturn;

    @Override
    public void view() {

        super.publicView();

        JLabel jLabel = new JLabel("游戏界面");
        jLabel.setFont(new Font("宋体", Font.BOLD, 25));
        jLabel.setForeground(Color.red);
        jLabel.setBounds(150, 100, 200, 50);

        btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(Color.orange);
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        btReturn.addActionListener(this);

        super.add(jLabel);
        super.add(btReturn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btReturn) {
            this.dispose();
            new MenuJFrame().view();
        }
    }

}
