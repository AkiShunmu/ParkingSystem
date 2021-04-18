package com.education.shun.mold;

import com.education.shun.util.AlgorithmUtil;
import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;
import com.education.shun.view.Function;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * @program: ParkingSystem
 * @description: 小地图
 * @author: qishun zhou
 * @create: 2021-04-14 23:33
 **/

public class MinMaps extends ModelObject {

    private static final BufferedImage IMG_MINMAPS = (BufferedImage) ImageUtil.images.get("pk_bg_min");
    private static final BufferedImage IMG_MINMAPS_HEAD = (BufferedImage) ImageUtil.images.get("pk_bg_head");

    public static int leadX;
    public static int leadY;

    public MinMaps(int x, int y) {
        name = NameUtil.MOLD_MIN_MAPS;
        this.x = x;
        this.y = y;
//        leadX = LeadCar.carX;
//        leadY = LeadCar.carY;
        if (Function.ranNum == 1) {
            leadX = 813;
            leadY = 537;
        } else if (Function.ranNum == 2) {
            leadX = 891;
            leadY = 461;
        } else {
            leadX = 1021;
            leadY = 603;
        }
        this.speed = 2;
    }

    /**
     * 绘制最佳车位
     * @param g
     */
    public static void bestPark(Graphics g) {
        //贪心算法获取最佳位置
        int bestNum = AlgorithmUtil.inGreedy(Function.ranNum, Function.parkArr);
        g.setColor(Color.RED);
        for (int i = 0; i < Function.parkArr.length; i++) {
            if (bestNum == 6) {
                g.drawRect(831, 573, 20, 9);
            } else if (bestNum == 7) {
                g.drawRect(831, 583, 20, 9);
            } else if (bestNum == 8) {
                g.drawRect(831, 592, 20, 9);
            } else if (bestNum == 9) {
                g.drawRect(831, 600, 20, 9);
            } else if (bestNum == 10) {
                g.drawRect(831, 608, 20, 9);
            } else if (bestNum == 11) {
                g.drawRect(831, 616, 20, 9);
            } else if (bestNum == 12) {
                g.drawRect(1005, 540, 20, 9);
            } else if (bestNum == 13) {
                g.drawRect(974, 540, 20, 9);
            } else if (bestNum == 14) {
                g.drawRect(1005, 531, 20, 9);
            } else if (bestNum == 15) {
                g.drawRect(974, 531, 20, 9);
            } else if (bestNum == 16) {
                g.drawRect(1005, 522, 20, 9);
            } else if (bestNum == 17) {
                g.drawRect(974, 522, 20, 9);
            } else if (bestNum == 18) {
                g.drawRect(1005, 513, 20, 9);
            } else if (bestNum == 19) {
                g.drawRect(974, 513, 20, 9);
            } else if (bestNum == 20) {
                g.drawRect(1005, 506, 20, 9);
            } else if (bestNum == 21) {
                g.drawRect(974, 506, 20, 9);
            } else if (bestNum == 22) {
                g.drawRect(1005, 498, 20, 9);
            } else if (bestNum == 23) {
                g.drawRect(974, 498, 20, 9);
            } else if (bestNum == 24) {
                g.drawRect(1005, 490, 20, 9);
            } else if (bestNum == 25) {
                g.drawRect(974, 490, 20, 9);
            } else if (bestNum == 26) {
                g.drawRect(1005, 480, 20, 9);
            } else if (bestNum == 27) {
                g.drawRect(974, 480, 20, 9);
            }
        }
    }

    /**
     * 接收键盘按下事件
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:     //设置“空格”倒车
                if (up && Wall.isTouch && leadY < 611) {
                    leadY += speed;
                } else if (down && Wall.isTouch) {
                    leadY -= speed;
                } else if (left && Wall.isTouch) {
                    leadX += speed;
                } else if (right && Wall.isTouch) {
                    leadX -= speed;
                }
                break;
            case KeyEvent.VK_UP:
                if (!down) {// 不能向初始方向的反方向移动
                    up = true;
                    down = false;
                    left = false;
                    right = false;
//                    newImageHead = IMG_MINMAPS_HEAD;//旋转图片
                    if (Wall.isTouch) leadY = leadY - speed - 1;
//                    System.out.println("leadX = " + leadX);
//                    System.out.println("leadY = " + leadY);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!up) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
//                    newImageHead = (BufferedImage) GameUtil.rotateImage(IMG_MINMAPS_HEAD, -180);
                    if (Wall.isTouch && leadY < 611) leadY = leadY + speed + 1;
//                    System.out.println("leadX = " + leadX);
//                    System.out.println("leadY = " + leadY);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!right) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
//                    newImageHead = (BufferedImage) GameUtil.rotateImage(IMG_MINMAPS_HEAD, -90);
                    if (Wall.isTouch) leadX -= speed;
//                    System.out.println("leadX = " + leadX);
//                    System.out.println("leadY = " + leadY);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!left) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
//                    newImageHead = (BufferedImage) GameUtil.rotateImage(IMG_MINMAPS_HEAD, 90);
                    if (Wall.isTouch) leadX += speed;
//                    System.out.println("leadX = " + leadX);
//                    System.out.println("leadY = " + leadY);
                }
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG_MINMAPS, x, y, null);
        if (leadX > 809 && leadX < 1027 && leadY > 457) {
            g.drawImage(IMG_MINMAPS_HEAD, leadX, leadY, null);
        }
    }
}
