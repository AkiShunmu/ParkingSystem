package com.education.shun.mold;

import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @program: ParkingSystem
 * @description: 停好车辆
 * @author: qishun zhou
 * @create: 2021-04-16 21:54
 **/

public class ParkCar extends ModelObject {

    private BufferedImage IMG_CAR;

    private static int ranNum;
    public static int packX;
    public static int packY;

    public ParkCar(int x, int y) {
        name = NameUtil.MOLD_PARK_CAR;
        this.x = x;
        this.y = y;
        this.speed = 15;
        if (x == 2090) {
            rightCar();
        } else {
            leftCar();
        }
    }

    @Override
    public void draw(Graphics g) {
        packX = ParkingScene.parkingX + x;
        packY = ParkingScene.parkingY + y;
        g.drawImage(IMG_CAR,  packX, packY, null);
    }

    /**
     * 创建左侧汽车
     */
    private void leftCar() {
        ranNum = new Random().nextInt(7 - 1 + 1) + 1;
        String carName = "car0" + ranNum;
        //向右旋转90度
        IMG_CAR = (BufferedImage) GameUtil.rotateImage((BufferedImage)ImageUtil.images.get(carName), 90);
    }

    /**
     * 创建右侧汽车
     */
    private void rightCar() {
        ranNum = new Random().nextInt(7 - 1 + 1) + 1;
        String carName = "car0" + ranNum;
        //向右旋转-90度
        IMG_CAR = (BufferedImage) GameUtil.rotateImage((BufferedImage)ImageUtil.images.get(carName), -90);
    }

    /**
     * 接收键盘按下事件
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:     //设置“空格”倒车
                if (up && Wall.isTouch) {
                    packY -= speed;
                } else if (down && Wall.isTouch) {
                    packY += speed;
                } else if (left && Wall.isTouch) {
                    packX -= speed;
                } else if (right && Wall.isTouch) {
                    packX += speed;
                }
//                System.out.println(packX + ", " + packY);
                break;
            case KeyEvent.VK_UP:
                if (!down) {// 不能向初始方向的反方向移动
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                    if (Wall.isTouch) packY += speed;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                    if (Wall.isTouch) packY -= speed;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                    if (Wall.isTouch) packX += speed;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!left) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                    if (Wall.isTouch) packX -= speed;
//                    System.out.println("x = " + x);
//                    System.out.println("y = " + y);
                }
                break;
        }
    }
}
