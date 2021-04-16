package com.education.shun.mold;

import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * @program: ParkingSystem
 * @description: 停车场
 * @author: qishun zhou
 * @create: 2021-04-12 14:55
 **/

public class ParkingScene extends ModelObject {

    private static final BufferedImage IMG_PARKING = (BufferedImage) ImageUtil.images.get("pk_bg");
//    private static BufferedImage newImgParking;//移动后的背景图片
    public static int parkingX;
    public static int parkingY;

    public ParkingScene(int x, int y) {
        name = NameUtil.MOLD_PARKING_SCENE;
        this.x = x;
        this.y = y;
        this.speed = 10;
    }

    /**
     * 接收键盘按下事件
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:     //设置“空格”倒车
                if (up && y > -1200 && Wall.isTouch) {
                    y -= speed;
                } else if (down && y < -100 && Wall.isTouch) {
                    y += speed;
                } else if (left && x > -1290 && Wall.isTouch) {
                    x -= speed;
                } else if (right && x < -150 && Wall.isTouch) {
                    x += speed;
                }
                break;
            case KeyEvent.VK_UP:
                if (!down && y < -100) {// 不能向初始方向的反方向移动
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                    if (Wall.isTouch) y += speed;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up && y > -1200) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                    if (Wall.isTouch) y -= speed;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right && x < -150) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                    if (Wall.isTouch) x += speed;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!left && x > -1290) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                    if (Wall.isTouch) x -= speed;
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

    @Override
    public void draw(Graphics g) {
        parkingX = x;
        parkingY = y;
        g.drawImage(IMG_PARKING, x, y, null);
    }
}
