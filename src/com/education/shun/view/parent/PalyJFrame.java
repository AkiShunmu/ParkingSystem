package com.education.shun.view.parent;

import com.education.shun.Interface.CaseJFrameMole;
import com.education.shun.Interface.JFrameMold;
import com.education.shun.view.FunctionJFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: ParkingSystem
 * @description: 运行时窗体父类
 * @author: qishun zhou
 * @create: 2021-04-10 16:00
 **/

public class PalyJFrame extends JFrame implements JFrameMold {

    private BufferedImage parkingIcon;

    public void view() {
        try {
            parkingIcon = ImageIO.read(new File("src/image/菜单图标.png"));
        } catch (IOException e) {
            System.out.println("图片获取失败...");
            e.printStackTrace();
        }

        this.setTitle("停车场系统");
        this.setVisible(true);
        this.setSize(1080,720);
        this.setResizable(false);     //设置窗口是否可调整
        this.setLocationRelativeTo(null);  //设置窗口在屏幕上居中
        this.setLayout(null);       //不采取任何布局
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (parkingIcon != null) {
            this.setIconImage(parkingIcon);
        }
    }

    @Override
    public CaseJFrameMole publicView(CaseJFrameMole param) {
        if (param.getClass().getName().equals("FunctionJFrame")) {
            return new FunctionJFrame();
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
