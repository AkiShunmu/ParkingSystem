package com.education.shun.view;

import com.education.shun.Interface.CaseJFrameMole;
import com.education.shun.mold.LeadCar;
import com.education.shun.mold.MyThread;
import com.education.shun.mold.ParkingScene;
import com.education.shun.util.ImageUtil;
import com.education.shun.view.parent.PalyJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

/**
 * @program: ParkingSystem
 * @description: 游戏窗体
 * @author: qishun zhou
 * @create: 2021-04-05 03:21
 **/

public class FunctionJFrame extends PalyJFrame implements CaseJFrameMole, ActionListener, Runnable {

    //左上:-140, -580   小车:5, 170
    //左下:-140, -720   小车:5, 170
    //上1道:-510, -115    小车:440, 30
    //上2道:-510, -115    小车:540, 30
    //上3道:-510, -115    小车:690, 30
    //上4道:-510, -115    小车:800, 30
    //右上:-1300, -1320   小车:960, 230
    //右下:-1300, -1320   小车:960, 335
    private LeadCar leadCar = new LeadCar(5, 170);
    private ParkingScene parking = new ParkingScene(-140, -580);

    private JButton btReturn;

//    private LodingUtil loding = new LodingUtil();

    @Override
    public void view() {

        super.view();

        btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(new Color(192, 192, 192));
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        btReturn.addActionListener(this);

        super.addElement(btReturn);
        super.upLayeredPane(btReturn);

//        super.playGame();
        //添加键盘监听器，处理键盘按下事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leadCar.keyPressed(e);//委托给leadCar
                parking.keyPressed(e);//委托给parking
            }
        });

        new Thread(this).start();
    }
    /**
     * 绘制界面
     */
    @Override
    public void paint(Graphics g) {
        parking.draw(g);
        leadCar.draw(g);
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btReturn) {
            this.dispose();
            new MenuJFrame().view();
        }
    }
}
