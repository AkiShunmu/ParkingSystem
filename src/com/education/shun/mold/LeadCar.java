package com.education.shun.mold;

import com.education.shun.Interface.CarMold;
import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;

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

public class LeadCar extends ModelObject implements CarMold {

    //小车图片(未旋转)
    private static final BufferedImage IMG_CAR = (BufferedImage) ImageUtil.images.get("car04");

//    private int speed;//移动速度
//    private int length;//长度
//    private int num;//
//    public static List<Point> bodyPoints = new LinkedList<>();
//    public int score = 0;//分数
//    public static
    private static int carX;
    private static int carY;
    public static Rectangle reCar;
    private static int carWidth;
    private static int carHeight;
    private static BufferedImage newImgSnakeHead;//旋转后的图片

    public LeadCar(int x, int y) {
        name = NameUtil.MOLD_LEAD_CAR;
        this.x = x;
        this.y = y;
        this.speed = 5;
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
     * 移动
     */
    @Override
    public void move() {
        if (up)
            y -= speed;
        else if (down)
            y += speed;
        else if (left)
            x -= speed;
        else if (right)
            x += speed;
    }
    /**
     * 绘制
     */
    public void draw(Graphics g) {
        g.drawImage(newImgSnakeHead, x, y, null);//绘制蛇头
        reCar = new Rectangle(carX, carY, carWidth, carHeight);
//        outOfBounds();//处理出界问题
//        eatBody();//处理是否吃到身体问题
//        bodyPoints.add(new Point(x, y));//保存轨迹
//        if (bodyPoints.size() == (this.length+1) * num) {//当保存的轨迹点的个数为蛇的长度+1的num倍时
//            bodyPoints.remove(0);//移除第一个
//        }
//        drawBody(g);//绘制蛇身
//        move();//移动
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
     * 绘制蛇身
     * @param g
     */
    /*public void drawBody(Graphics g) {
        int length = bodyPoints.size() - 1-num;//前num个存储的是蛇头的当前轨迹坐标
        for (int i = length; i >= num; i -= num) {//从尾部添加
            Point p = bodyPoints.get(i);
            g.drawImage(img, p.x, p.y, null);
        }
    }*/
}
