package com.education.shun.view;

import com.education.shun.Interface.CaseJFrameMole;
import com.education.shun.mold.LeadCar;
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

    private LeadCar leadCar = new LeadCar(100, 100);

    private JButton btReturn;

//    private LodingUtil loding = new LodingUtil();

    public static void main(String[] args) {
        new FunctionJFrame().test();
    }

    public void test() {
        JFrame jFrame = new JFrame("小车测试");
        jFrame.setSize(1080, 720);//设置窗体大小
        jFrame.setBackground(Color.BLACK);//设置背景
        jFrame.setLocationRelativeTo(null);//居中
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

//        JLabel jLabel = new JLabel();
//        jLabel.setIcon((Icon) LeadCar.IMG_CAR);
//        jFrame.add(jLabel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leadCar.keyPressed(e);//委托给mysnake
            }
        });

        new Thread(new FunctionJFrame()).start();
    }

    /**
     * 绘制界面
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageUtil.images.get("pk_bg"), 0, 0, null);
        leadCar.draw(g);
    }

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

        //添加键盘监听器，处理键盘按下事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leadCar.keyPressed(e);//委托给leadCar
            }
        });

        new Thread(this).start();

    }
    /**
     * 防止图片闪烁，使用双重缓存
     *
     * @param g
     */
    /*Image backImg = null;

    @Override
    public void update(Graphics g) {
        if (backImg == null) {
            backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.BLACK);
        backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        backg.setColor(c);
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }*/
    @Override
    public void run() {
        while (true) {
//            LodingUtil loding = new LodingUtil();
//            loding.setLoding();
//            super.addElement(loding);
//            super.upLayeredPane(loding);
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
