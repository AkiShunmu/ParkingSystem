package com.education.shun.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ParkingSystem
 * @description:    获取图片
 * @author: qishun zhou
 * @create: 2021-04-10 21:30
 **/

public class ImageUtil {

    public static Map<String, Image> images = new HashMap<>();

    public static final int WINDOW_WIDTH = 1080;
    public static final int WINDOW_HEIGHT = 720;

    private static final String IMG_PRE = "src/image/";     //图片路径前缀

    static{
        images.put("menu_icon", GameUtil.getImage(IMG_PRE+"菜单图标.png"));
        images.put("menu_bg", GameUtil.getImage(IMG_PRE+"菜单背景.jpg"));
        images.put("code", GameUtil.getImage(IMG_PRE+"验证码图片.jpg"));
        images.put("car01", GameUtil.getImage(IMG_PRE+"汽车01.png"));
        images.put("car02", GameUtil.getImage(IMG_PRE+"汽车02.png"));
        images.put("car03", GameUtil.getImage(IMG_PRE+"汽车03.png"));
        images.put("car04", GameUtil.getImage(IMG_PRE+"汽车04.png"));
        images.put("car05", GameUtil.getImage(IMG_PRE+"汽车05.png"));
        images.put("car06", GameUtil.getImage(IMG_PRE+"汽车06.png"));
        images.put("car07", GameUtil.getImage(IMG_PRE+"汽车07.png"));
        images.put("car08", GameUtil.getImage(IMG_PRE+"汽车08.png"));
        images.put("pk_bg", GameUtil.getImage(IMG_PRE+"停车场图片.jpg"));
        images.put("pk_bg_min", GameUtil.getImage(IMG_PRE+"小地图.jpg"));
        images.put("pk_bg_head", GameUtil.getImage(IMG_PRE+"小地图头像.png"));
        images.put("wall", GameUtil.getImage(IMG_PRE+"墙壁.png"));
    }

}
