package com.education.shun.mold;

import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
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
    boolean up, down, left, right;//初始态向上

    public ParkingScene(int x, int y) {
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
                if (up && y > -1200) {
                    y -= speed;
                } else if (down && y < -100) {
                    y += speed;
                } else if (left && x > -1290) {
                    x -= speed;
                } else if (right && x < -150) {
                    x += speed;
                }
                break;
            case KeyEvent.VK_UP:
                if (!down && y < -100) {// 不能向初始方向的反方向移动
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                    y += speed;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up && y > -1200) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                    y -= speed;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right && x < -150) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                    x += speed;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!left && x > -1290) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                    x -= speed;
                }
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG_PARKING, x, y, null);
    }
}
