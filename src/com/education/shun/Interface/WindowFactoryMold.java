package com.education.shun.Interface;

import com.education.shun.view.parent.WindowJFramePublish;

/**
 * @program: ParkingSystem
 * @description: 窗体工厂
 * @author: qishun zhou
 * @create: 2021-03-31 23:14
 **/

public interface WindowFactoryMold {

    WindowJFramePublish createWindow(String type);

}
