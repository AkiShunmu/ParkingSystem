package com.education.shun.view.parent;

import com.education.shun.util.GameUtil;
import com.education.shun.util.ImageUtil;

import java.awt.*;

/**
 * @program: ParkingSystem
 * @description: 创建工厂所给的具体产品
 * @author: qishun zhou
 * @create: 2021-04-12 21:56
 **/

public class WindowJFrame {

    PlayFactory playFactory;
    StartFactory startFactory;

    public WindowJFrame(PlayFactory playFactory) {
        this.playFactory = playFactory;
    }

    public WindowJFrame(StartFactory startFactory) {
        this.startFactory = startFactory;
    }

    //创建开始窗口的子类
    public WindowJFramePublish createStartWindow(String type) {
        WindowJFramePublish publish = null;
        publish = startFactory.createWindow(type);
        return publish;
    }

    //创建运行窗口的子类
    public WindowJFramePublish createPlayWindow(String type) {
        WindowJFramePublish publish = null;
        publish = playFactory.createWindow(type);
        return publish;
    }

}
