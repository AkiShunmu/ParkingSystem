package com.education.shun.util;

import javax.swing.*;
import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 生成图片
 * @author: qishun zhou
 * @create: 2021-04-08 18:27
 **/

public class ImageUtil extends JPanel {

    Image image;

    public ImageUtil(Image im)
    {
        this.image = im;
        this.setOpaque(true);
    }
    //Draw the back ground.
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);

    }

}
