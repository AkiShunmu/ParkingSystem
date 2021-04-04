package com.education.shun.util;

import javax.swing.*;
import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 生成验证码
 * @author: qishun zhou
 * @create: 2021-04-02 13:25
 **/

public class CaptcharUtil extends JLabel {

    private static final long serialVersionUID = -963570191302793615L;
    private String text;// 用于保存生成验证图片的字符串

    private Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };// 定义画笔颜色数组

    public CaptcharUtil(String text) {
        this.text = text;
        setPreferredSize(new Dimension(60, 36));// 设置标签的大小
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);// 调用父类的构造方法
        g.setFont(new Font("微软雅黑", Font.PLAIN, 16));// 设置字体
        for (int i = 0; i < text.length(); i++) {
            g.setColor(colors[(int)(Math.random() * (99999999 - 111111111 + 1) + 111111111)]);  //随机颜色
            g.drawString("" + text.charAt(i), 5 + i * 13, 25);// 绘制字符串
        }
    }
}
