package com.education.shun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: ParkingSystem
 * @description: 停车费用实体类
 * @author: qishun zhou
 * @create: 2021-04-19 10:55
 **/

@Data
@AllArgsConstructor
public class ParkFee {

    /**
     * 停车编号
     */
    private String parkId;

    /**
     * 用户名
     */
    private String userId;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 停车时间
     */
    private int parkTime;

    /**
     * 停车费用
     */
    private int fee;

}
