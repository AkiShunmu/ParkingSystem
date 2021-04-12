package com.education.shun;

import com.education.shun.util.NameUtil;
import com.education.shun.view.parent.PlayFactory;
import com.education.shun.view.parent.StartFactory;
import com.education.shun.view.parent.WindowJFrame;
import com.education.shun.view.parent.WindowJFramePublish;

public class ApplicationMain {

    public static void main(String[] args) {

        //开始工厂
        StartFactory startFactory = new StartFactory();
        //运行工厂
        PlayFactory playFactory = new PlayFactory();

        //窗口生产商
        WindowJFrame windowJFrame = new WindowJFrame(startFactory);
        //需要创建的窗口类型
//        WindowJFramePublish publish = windowJFrame.createStartWindow(NameUtil.WINDOW_MENU);
        windowJFrame = new WindowJFrame(playFactory);
        WindowJFramePublish publish = windowJFrame.createPlayWindow(NameUtil.WINDOW_FUNCTION);

    }
}
