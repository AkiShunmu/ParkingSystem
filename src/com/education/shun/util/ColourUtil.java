package com.education.shun.util;

import javax.swing.*;
import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 渐变颜色工具类
 * @author: qishun zhou
 * @create: 2021-04-10 00:12
 **/

public class ColourUtil extends JPanel {

    private String value;

    public ColourUtil(String value) {
        this.value = value;
    }

    public void paint(Graphics g) { // 重写paint()方法
        Graphics2D g2 = (Graphics2D) g;// 转换为Graphics2D类型
        int x = 10; // 文本位置的横坐标
        int y = 45; // 文本位置的纵坐标
        Font font = new Font("楷体", Font.BOLD, 50); // 创建字体对象
        g2.setFont(font); // 设置字体
        // 创建循环渐变的GraphientPaint对象
        GradientPaint paint = new GradientPaint(20, 20, Color.ORANGE, 100,120, Color.MAGENTA, true);
        g2.setPaint(paint);// 设置渐变
        g2.drawString(value, x, y); // 绘制文本
    }

}
