package com.education.shun.view;

import com.education.shun.Interface.WindowMole;
import com.education.shun.mold.*;
import com.education.shun.util.AlgorithmUtil;
import com.education.shun.util.ImageUtil;
import com.education.shun.util.NameUtil;
import com.education.shun.view.parent.WindowJFramePublish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @program: ParkingSystem
 * @description: 游戏窗体
 * @author: qishun zhou
 * @create: 2021-04-05 03:21
 **/

public class Function extends WindowJFramePublish implements WindowMole, ActionListener {

    ////左上:-140, -580   小车:5, 170
    ////上3道:-510, -115    小车:690, 30
    ////上4道:-510, -115    小车:800, 30
    ////右下:-1300, -1320   小车:960, 335
    ////上2道:-510, -115    小车:540, 30  该位置小车有些碰墙了
    //左下:-140, -580   小车:5, 320
    //上1道:-510, -115    小车:440, 30
    //右上:-1300, -1320   小车:960, 230
    private LeadCar leadCar;
    private ParkingScene parking;
    private MinMaps minMaps;
    private Wall wall = new Wall();

    public static int ranNum;
    public static long startTime;
    public static long endTime;
    public static int[] parkArr = AlgorithmUtil.randomArr();    //随机车辆
    private static List<ParkCar> parkList = new ArrayList<>();  //已停车辆集合

    private JButton btReturn;

//    private LodingUtil loding = new LodingUtil();

    public Function() {
        name = NameUtil.WINDOW_FUNCTION;
        this.randomCreate();
        super.view();
        super.ImageCaching();   //图像双缓存方法调用
        this.createParkCar();     //创建已停车辆
        this.view();
    }

    @Override
    public void view() {

        /*btReturn = new JButton("返回");
        btReturn.setBounds(super.getX()+400, super.getY()+400, 100, 50);
        btReturn.setBackground(new Color(192, 192, 192));
        btReturn.setFont(new Font("楷体", Font.PLAIN, 20));
        //按钮点击事件
        btReturn.addActionListener(this);

        super.addElement(btReturn);
        super.upLayeredPane(btReturn);*/

        addKeyListener(new KeyMonitor());
        addMouseListener(new MouseClick());
//        new Thread(this).start();
    }

    //随机生成小车出生地
    public void randomCreate() {
        //生成随机数
        ranNum = new Random().nextInt(3 - 1 + 1) + 1;
//        ranNum = 1;
        if (ranNum == 1) {
            leadCar = new LeadCar(5, 320);
            parking = new ParkingScene(-140, -580);
        } else if (ranNum == 2) {
            leadCar = new LeadCar(440, 30);
            parking = new ParkingScene(-510, -115);
        } else if (ranNum == 3) {
            leadCar = new LeadCar(960, 230);
            parking = new ParkingScene(-1300, -1320);
        }
        minMaps = new MinMaps(800, 450);
    }

    //创建已停车辆
    public void createParkCar() {
        for (int i = 0; i < parkArr.length; i++) {
            if (parkArr[i] == 6) {
                parkList.add(new ParkCar(345, 1220));
            } else if (parkArr[i] == 7) {
                parkList.add(new ParkCar(345, 1305));
            } else if (parkArr[i] == 8) {
                parkList.add(new ParkCar(345, 1400));
            } else if (parkArr[i] == 9) {
                parkList.add(new ParkCar(345, 1475));
            } else if (parkArr[i] == 10) {
                parkList.add(new ParkCar(345, 1550));
            } else if (parkArr[i] == 11) {
                parkList.add(new ParkCar(345, 1645));
            } else if (parkArr[i] == 12) {
                parkList.add(new ParkCar(2090, 900));
            } else if (parkArr[i] == 13) {
                parkList.add(new ParkCar(1770, 900));
            } else if (parkArr[i] == 14) {
                parkList.add(new ParkCar(2090, 800));
            } else if (parkArr[i] == 15) {
                parkList.add(new ParkCar(1770, 800));
            } else if (parkArr[i] == 16) {
                parkList.add(new ParkCar(2090, 715));
            } else if (parkArr[i] == 17) {
                parkList.add(new ParkCar(1770, 715));
            } else if (parkArr[i] == 18) {
                parkList.add(new ParkCar(2090, 630));
            } else if (parkArr[i] == 19) {
                parkList.add(new ParkCar(1770, 630));
            } else if (parkArr[i] == 20) {
                parkList.add(new ParkCar(2090, 535));
            } else if (parkArr[i] == 21) {
                parkList.add(new ParkCar(1770, 535));
            } else if (parkArr[i] == 22) {
                parkList.add(new ParkCar(2090, 445));
            } else if (parkArr[i] == 23) {
                parkList.add(new ParkCar(1770, 445));
            } else if (parkArr[i] == 24) {
                parkList.add(new ParkCar(2090, 365));
            } else if (parkArr[i] == 25) {
                parkList.add(new ParkCar(1770, 365));
            } else if (parkArr[i] == 26) {
                parkList.add(new ParkCar(2090, 280));
            } else if (parkArr[i] == 27) {
                parkList.add(new ParkCar(1770, 280));
            }
        }
    }

    /**
     * 绘制界面
     */
    @Override
    public void paint(Graphics g) {
        parking.draw(g);
        leadCar.draw(g);
        minMaps.draw(g);
//        wall.draw(g);
        if (parkList != null) {
            for (int i = 0; i < parkList.size(); i++) {
                parkList.get(i).draw(g);
            }
        }
        drawParkButton(g);  //绘制停车按钮
        MinMaps.bestPark(g);//绘制最佳车位
        /*int message = 3;
        int messagePark = 3;
        if (LeadCar.carX == 13 && LeadCar.carY == 320) {
            message = JOptionPane.showConfirmDialog(null,"确定停车？？？","提示",JOptionPane.YES_NO_OPTION);
//            message = JOptionPane.showConfirmDialog(null,"确定停车？？？");
        }
        if (message == 1) {
            super.ImageCaching();
        } else if(message == 0) {
            super.sleepThread(5000);
            JOptionPane.showMessageDialog(null, "正在停车...", "提示",JOptionPane.INFORMATION_MESSAGE);
        }*/
    }

    /**
     * 停车按钮
     * @param g
     */
    public void drawParkButton(Graphics g) {
        g.setFont(new Font("楷体", Font.BOLD, 50));
        g.setColor(new Color(204, 255, 0));
        g.drawString("停车", 510, 660);
    }

    //处理鼠标点击事件
    private class MouseClick extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getX() >= 508 && e.getX() <= 612 && e.getY() >= 616 && e.getY() <= 665) {
                int message = JOptionPane.showConfirmDialog(null, "确定停车？？？", "系统提示:", JOptionPane.YES_NO_OPTION);
                int reMessage = 1;
                if (message == 0) {
                    while (reMessage == 1) {
                        startTime = System.currentTimeMillis();
                        JOptionPane.showMessageDialog(null, "正在停车...", "系统提示:",JOptionPane.INFORMATION_MESSAGE);
                        reMessage = JOptionPane.showConfirmDialog(null, "重启车辆？？？", "系统提示:", JOptionPane.YES_NO_OPTION);
                    }
                }
                endTime = System.currentTimeMillis();
                System.out.println(endTime - startTime);
            }
        }
    }

    //添加键盘监听器，处理键盘按下事件
    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            leadCar.keyPressed(e);//委托给leadCar
            parking.keyPressed(e);//委托给parking
            minMaps.keyPressed(e);//委托给minMaps
            if (parkList != null) {
                for (int i = 0; i < parkList.size(); i++) {
                    parkList.get(i).keyPressed(e);//委托给parkCar
                }
            }
        }
        /*@Override
        public void keyReleased(KeyEvent e) {
            leadCar.keyReleased(e);//委托给leadCar
            parking.keyReleased(e);//委托给parking
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btReturn) {
            this.dispose();
            new Menu();
        }
    }

}

