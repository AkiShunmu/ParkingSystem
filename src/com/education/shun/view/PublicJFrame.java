package com.education.shun.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: ParkingSystem
 * @description: 窗口公共方法
 * @author: qishun zhou
 * @create: 2021-03-31 23:10
 **/

public class PublicJFrame extends JFrame {

    BufferedImage parkingIcon;
//    ImageIcon bgIamge;
    BufferedImage bgIamge;

    public void publicView() {
        try {
            parkingIcon = ImageIO.read(new File("src/image/菜单图标.png"));
            bgIamge = ImageIO.read(new File("src/image/菜单背景.jpg"));
//            bgIamge = new BackgroundPanel((new ImageIcon("src/image/菜单背景.jpg")).getImage());
        } catch (IOException e) {
            System.out.println("图片获取失败...");
            e.printStackTrace();
        }

        this.setTitle("停车场系统");
        this.setVisible(true);
        this.setSize(1080,720);
        this.setResizable(false);     //设置窗口是否可调整
        this.setLocationRelativeTo(null);  //设置窗口在屏幕上居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (parkingIcon != null) {
            this.setIconImage(parkingIcon);
        }
        //窗口布局设置
        this.setLayout(null);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //添加背景容器
//        this.add(bgIamge);

    }

    public void paint(Graphics g) {
        g.drawImage(bgIamge, 0, 0, null);
    }

}