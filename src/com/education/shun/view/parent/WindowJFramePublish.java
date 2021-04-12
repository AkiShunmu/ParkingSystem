package com.education.shun.view.parent;

import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: ParkingSystem
 * @description: 窗口
 * @author: qishun zhou
 * @create: 2021-04-12 21:18
 **/

public abstract class WindowJFramePublish extends JFrame {
    //窗口名
    public String name;

    public void view() {
        BufferedImage parkingIcon;  //窗口图标

        this.setTitle("停车场系统");
        this.setVisible(true);
        this.setSize(1080,720);
        this.setResizable(false);     //设置窗口是否可调整
        this.setLocationRelativeTo(null);  //设置窗口在屏幕上居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);       //不采取任何布局

        parkingIcon = (BufferedImage) ImageUtil.images.get("menu_icon");
        this.setIconImage(parkingIcon);
    }

    public void bgImage() {
        //创建容器
        Container container;
        //创建背景面板。
        GameUtil bgPanel;
        //创建图片对象
        Image image;

        image = ImageUtil.images.get("menu_bg");
        container = this.getContentPane();
        bgPanel = new GameUtil(image);
        bgPanel.setBounds(0, 0, ImageUtil.WINDOW_WIDTH, ImageUtil.WINDOW_HEIGHT);
        container.add(bgPanel);
    }

    public void addElement(Component... param) {
        for (Component component : param) {
            this.add(component);
        }
    }

    public void upLayeredPane(Component... param) {
        for (Component component : param) {
            this.getLayeredPane().add(component, Integer.MAX_VALUE);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
