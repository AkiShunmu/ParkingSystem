package com.education.shun.mold;

import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: ParkingSystem
 * @description: 小地图
 * @author: qishun zhou
 * @create: 2021-04-14 23:33
 **/

public class MinMaps extends ModelObject {

    private static final BufferedImage IMG_MINMAPS = (BufferedImage) ImageUtil.images.get("pk_bg_min");

    public MinMaps(int x, int y) {
        name = NameUtil.MOLD_MIN_MAPS;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(IMG_MINMAPS, x, y, null);
    }
}
