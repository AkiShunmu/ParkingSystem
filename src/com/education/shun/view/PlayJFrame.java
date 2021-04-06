package com.education.shun.view;

import com.education.shun.Interface.IJFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 游戏窗体
 * @author: qishun zhou
 * @create: 2021-04-05 03:21
 **/

public class PlayJFrame extends PublicJFrame implements IJFrame {

    @Override
    public void view() {

        JLabel jLabel = new JLabel("游戏界面");
        jLabel.setFont(new Font("宋体", Font.BOLD, 25));
        jLabel.setForeground(Color.red);
        jLabel.setBounds(150, 100, 200, 50);

        super.publicView();

        super.add(jLabel);

    }

}
