package com.education.shun.view.parent;

import com.education.shun.Interface.WindowFactoryMold;
import com.education.shun.util.NameUtil;
import com.education.shun.view.Function;

/**
 * @program: ParkingSystem
 * @description: 运行工厂
 * @author: qishun zhou
 * @create: 2021-04-12 21:36
 **/

public class PlayFactory implements WindowFactoryMold {

    //创建不同类型的窗口
    @Override
    public WindowJFramePublish createWindow(String type) {
        WindowJFramePublish window = null;
        if (NameUtil.WINDOW_FUNCTION.equals(type)) {
            window = new Function();
        }
        return window;
    }

}
