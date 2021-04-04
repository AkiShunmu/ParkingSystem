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

    private BufferedImage parkingIcon;
    private ImageIcon bgIamge;
//    BufferedImage bgIamge;
//    File dir = new File("src/image/菜单背景.jpg");

    public void publicView() {
        try {
            parkingIcon = ImageIO.read(new File("src/image/菜单图标.png"));
//            bgIamge = new ImageIcon(dir.toString());
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
        JLabel bglabel = new JLabel();
        JPanel contentPane = new JPanel();
        getBackgroundPicture(bglabel, contentPane);
        this.getLayeredPane().add(bglabel, new Integer(Integer.MIN_VALUE));

        /*JLabel jLabel = new JLabel();
        jLabel.setIcon(bgIamge);
        jLabel.setBounds(0, 0, bgIamge.getIconWidth(), bgIamge.getIconHeight());
        JPanel jPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("src/image/菜单背景.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        jPanel.setLayout(null);
        jPanel.setOpaque(false);

        //添加背景容器
        this.add(jPanel);*/

    }

    /*public void paint(Graphics g) {
        g.drawImage(bgIamge, 0, 0, null);
    }*/

    public void getBackgroundPicture(JLabel bglabel, JPanel contentPane){
        File dir = new File("src/image/菜单背景.jpg");
        ImageIcon background=new ImageIcon(dir.toString());

        bglabel.setIcon(background);//将图片设置到Jlabel中

        bglabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());//设图片显示的区域
        contentPane.setOpaque(false);//设置面板为透明，在gbLabel之上的JPanel都要设置为透明
    }

}