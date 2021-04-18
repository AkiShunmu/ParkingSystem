package com.education.shun.mold;

import com.education.shun.Interface.CarMold;
import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;
import com.education.shun.view.parent.WindowJFramePublish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 主角小车
 * @author: qishun zhou
 * @create: 2021-04-10 21:15
 **/

public class LeadCar extends ModelObject {

    //小车图片(未旋转)
    private static final BufferedImage IMG_CAR = (BufferedImage) ImageUtil.images.get("car04");

    public static int carX;
    public static int carY;
    public static Rectangle reCar;
    private static int carWidth;
    private static int carHeight;
    private static BufferedImage newImgSnakeHead;//旋转后的图片

    public LeadCar(int x, int y) {
        name = NameUtil.MOLD_LEAD_CAR;
        this.x = x;
        this.y = y;
        this.speed = 8;
        this.width = IMG_CAR.getWidth();
        this.height = IMG_CAR.getHeight();
        carWidth = IMG_CAR.getWidth();
        carHeight = IMG_CAR.getHeight();
        newImgSnakeHead = IMG_CAR;
//        this.img = ImageUtil.images.get("snake_body");
//        this.width = img.getWidth(null);
//        this.height = img.getHeight(null);
//        this.length = 1;
//        this.num = width / speed;
    }

    /**
     * 接收键盘按下事件
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:     //设置“空格”倒车
                if (up && Wall.isTouch) {
                    y += speed;
                } else if (down && Wall.isTouch) {
                    y -= speed;
                } else if (left && Wall.isTouch) {
                    x += speed;
                } else if (right && Wall.isTouch) {
                    x -= speed;
                }
                break;
            case KeyEvent.VK_UP:
                if (!down) {// 不能向初始方向的反方向移动
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                    newImgSnakeHead = IMG_CAR;//旋转图片
                    if (Wall.isTouch) y -= speed;
//                    System.out.println("x = " + x);
//                    System.out.println("y = " + y);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_CAR, -180);
                    if (Wall.isTouch) y += speed;
//                    System.out.println("x = " + x);
//                    System.out.println("y = " + y);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_CAR, -90);
                    if (Wall.isTouch) x -= speed;
//                    System.out.println("x = " + x);
//                    System.out.println("y = " + y);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!left) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_CAR, 90);
                    if (Wall.isTouch) x += speed;
//                    System.out.println("x = " + x);
//                    System.out.println("y = " + y);
                }
                break;
        }
    }

    /**
     * 接收键盘抬起事件
     * @param e
     */
    /*public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP
        || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT
        || e.getKeyCode() == KeyEvent.VK_RIGHT) && !Wall.isTouch) {
            Wall.isTouch = true;
        }
    }*/

    /**
     * 绘制
     */
    public void draw(Graphics g) {
        carX = x;
        carY = y;
        g.drawImage(newImgSnakeHead, x, y, null);//绘制蛇头
    }

    /**
     * 处理是否碰撞问题
     */
    public static boolean isTouch(){
        Rectangle reCar = new Rectangle(carX, carY, carWidth, carHeight);
//        Rectangle reWall = new Wall().rectangle;
//        if (reCar.intersects(reWall)) {
//            return false;
//        }
//        System.out.println(newImgSnakeHead.getSource());  //返回图像的像素对象
        return true;
    }

    /**
     * 判断小车是否停靠
     */
    public void isPark() {
        if (carX >= 210 && carX <= 195 && carY >= 650 && carY <= 630) {
            System.out.println("停靠6号位");
        }
    }

}
