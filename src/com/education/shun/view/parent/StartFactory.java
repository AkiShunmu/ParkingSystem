package com.education.shun.view.parent;

import com.education.shun.Interface.WindowFactoryMold;
import com.education.shun.util.NameUtil;
import com.education.shun.view.Login;
import com.education.shun.view.Menu;
import com.education.shun.view.Register;

/**
 * @program: ParkingSystem
 * @description: 开始工厂
 * @author: qishun zhou
 * @create: 2021-04-12 21:35
 **/

public class StartFactory implements WindowFactoryMold {

    //创建不同类型的窗口
    @Override
    public WindowJFramePublish createWindow(String type) {
        WindowJFramePublish window = null;
        if (NameUtil.WINDOW_MENU.equals(type)) {
            window = new Menu();
        } else if (NameUtil.WINDOW_LOGIN.equals(type)) {
            window = new Login();
        } else if (NameUtil.WINDOW_REGISTER.equals(type)) {
            window = new Register();
        }
        return window;
    }

}
