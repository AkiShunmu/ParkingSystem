package com.education.shun.util;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * @program: ParkingSystem
 * @description: 验证码生成工具类
 * @author: qishun zhou
 * @create: 2021-04-05 17:38
 **/

public class CaptchaCodeUtil {

    private int width = 70;
    private int h = 35;
    private Random random = new Random();
    private String[] fontNames = {"宋体","华文楷体","黑体","华文隶书","微软雅黑","楷体_GB2312"};
    private String codes = "123456789abcdefghjkmnpqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXYZ";
    private Color bgColor = new Color(255,255,255);
    private String text;

    private Color randomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red,green,blue);
    }

    private Font randomFont() {
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(fontName,style,size);
    }

    private void drawLine(BufferedImage image) {
        int num = 3;
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        for(int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(h);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F));//设置线条的粗细
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, h);
        return image;
    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * width / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, h-5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText() {
        return text;
    }

    public static void output(BufferedImage image,OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

}
