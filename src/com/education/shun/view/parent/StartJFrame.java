package com.education.shun.view.parent;

import com.education.shun.Interface.CaseJFrameMole;
import com.education.shun.Interface.JFrameMold;
import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.view.LoginJFrame;
import com.education.shun.view.MenuJFrame;
import com.education.shun.view.RegisterJFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: ParkingSystem
 * @description: 主界面父类
 * @author: qishun zhou
 * @create: 2021-03-31 23:10
 **/

public class StartJFrame extends JFrame implements JFrameMold {

    //创建一个容器
    private Container container;
    //创建背景面板。
    private GameUtil bgPanel;
    //创建图片对象
    private Image image;

    private BufferedImage parkingIcon;

    public void view() {
        parkingIcon = (BufferedImage) ImageUtil.images.get("menu_icon");

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
        this.setLayout(null);       //不采取任何布局
        image = ImageUtil.images.get("menu_bg");
        container = this.getContentPane();
        bgPanel = new GameUtil(image);
        bgPanel.setBounds(0, 0, ImageUtil.WINDOW_WIDTH, ImageUtil.WINDOW_HEIGHT);
        container.add(bgPanel);
    }

    public CaseJFrameMole publicView(CaseJFrameMole param) {
        if (param.getClass().getName().equals("MenuJFrame")) {
            return new MenuJFrame();
        }
        if (param.getClass().getName().equals("LoginJFrame")) {
            return new LoginJFrame();
        }
        if (param.getClass().getName().equals("RegisterJFrame")) {
            return new RegisterJFrame();
        }
        return null;
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

}