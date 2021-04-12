package com.education.shun.mold;

import com.education.shun.Interface.CarMold;

import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 汽车
 * @author: qishun zhou
 * @create: 2021-04-10 21:18
 **/

public abstract class ModelObject {

    int x;//横坐标
    int y;//纵坐标
    Image img;//图片
    int width;//图片宽度
    int height;//图片高度
    int speed;//移动速度

    public abstract void draw(Graphics g);

    /**
     * 获取图片对应的矩形
     *
     * @return
     */
    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
}
