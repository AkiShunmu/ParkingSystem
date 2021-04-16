package com.education.shun.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: ParkingSystem
 * @description: 贪心算法
 * @author: qishun zhou
 * @create: 2021-04-14 21:24
 **/

public class AlgorithmUtil {

    public static void main(String[] args) {
        int[] park = {6,7,8,9,0,11,12,13,14,0,16,17,0,0,0,0,0,0,0,0,0,0};
        new AlgorithmUtil().inGreedy(1, park);
    }

    public int inGreedy(int isInto, int[] park) {
        int dot = 27;       //点数
//        edge = 26;      //边数
//        start = 1;    //开始点数

        int value[][] = new int[dot+1][dot+1];      //表示a到b的权重
        int dis[] = new int[dot+1];               //存储的最短路径
        int a;
        int b;
        int length;     //表示a到b的距离

        //权重点数
        for (int i = 1; i <= dot; i++) {
            dis[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= dot; j++) {
                if (i == j) value[i][j] = 0;    //i == j 表示当前节点
                value[i][j] = -1;
            }
        }
        if (isInto == 1) {
            value[1][2] = 400;
            value[2][1] = 400;
            dis[2] = 400;
        } else if (isInto == 2) {
            value[1][3] = 800;
            value[3][1] = 800;
            dis[3] = 800;
        } else if (isInto == 3) {
            value[1][4] = 300;
            value[4][1] = 300;
            dis[4] = 300;
        }
        value[2][3] = 400;
        value[3][2] = 400;
        value[3][4] = 1800;
        value[4][3] = 1800;
        value[4][5] = 600;
        value[5][4] = 600;
        value[2][4] = 2200;
        value[4][2] = 2200;
        value[2][5] = 2800;
        value[5][2] = 2800;
        value[3][5] = 2400;
        value[5][3] = 2400;

        b = 6;
        length = 300;
        for (int i = 0; i < 12; i++) {
            if (i < 6) {
                value[2][b] = length;
                if (i == 5) continue;
                b++;
                length += 100;
            } else {
                value[b][2] = length;
                b--;
                length -= 100;
            }
        }
        b = 12;
        length = 100;
        for (int i = 0; i < 32; i++) {
            if (i < 16) {
                value[5][b] = length;
                if (i == 15) continue;
                b++;
                length += 50;
            } else {
                value[b][5] = length;
                b--;
                length -= 50;
            }
        }
        /*for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (value[i][j] != -1 && value[i][j] != 0) {
                    System.out.println(i + "到" + j + "距离为" + value[i][j]);
                }
            }
            System.out.println();
        }*/

        int lately = 0;     //最近距离的车位
        int minNum = Integer.MAX_VALUE;
        int[] searchArr = search(1, dis, value, dot);
        List<Integer> nullPark = new ArrayList<>();
        //找出全部空车位的序号
        for (int i = 6; i < 28; i++) {
            if (park[i-6] == 0) {
                nullPark.add(i);
            }
        }
        //找出距离最短的空车位
        for (int i = 0; i < nullPark.size(); i++) {
            if (searchArr[nullPark.get(i)] < minNum) {
                minNum = searchArr[nullPark.get(i)];
                lately = nullPark.get(i);
            }
        }
        System.out.println("lately = " + lately);
        return lately;
    }

    private static int[] search(int x, int dis[], int value[][], int n) {
        boolean mark[] = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            mark[i] = false;
        }
        mark[x] = true;     //表示当前节点已经加过了
        dis[x] = 0;         //自己走自己
        int count = 1;      //表示加了几个点
        while (count <= n) {
            int loc = 0;    //表示贪心策略要加的点
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!mark[i] && dis[i] < min) {
                    min = dis[i];
                    loc = i;
                }
            }
            if (loc == 0) break;    //表示当前没有点相加
            mark[loc] = true;
            count++;

            for (int i = 1; i <= n; i++) {
                if (!mark[i] && value[loc][i] != -1 && (dis[loc] + value[loc][i] < dis[i])) {
                    dis[i] = dis[loc] + value[loc][i];
                }
            }
        }
        /*System.out.println("以" + x + "为起点的最短路径");
        for (int i = 1; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE)
                System.out.println(i + "最短为" + dis[i]);
            else System.out.println(i + "没有路");
        }*/
        return dis;
    }
}
