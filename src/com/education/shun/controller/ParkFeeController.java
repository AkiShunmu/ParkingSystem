package com.education.shun.controller;

import com.education.shun.Service.Impl.ParkFeeServiceImpl;
import com.education.shun.entity.ParkFee;
import org.junit.Test;

import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 费用信息控制层
 * @author: qishun zhou
 * @create: 2021-04-19 11:07
 **/

public class ParkFeeController {

    private ParkFeeServiceImpl parkFeeService = new ParkFeeServiceImpl();

    public List<ParkFee> plateFind(String plate) {
        return parkFeeService.plateFind(plate);
    }

    public List<ParkFee> userFeeFind(String userId) {
        return parkFeeService.userFeeFind(userId);
    }

    public boolean feeInsert(String parkId, String userId, String plate, Integer parkTime, Integer fee) {
        return parkFeeService.feeInsert(parkId, userId, plate, parkTime, fee);
    }

    @Test
    public void test01() {
        ParkFeeController parkController = new ParkFeeController();
//        System.out.println(parkController.userFeeFind("123"));
        parkController.feeInsert("test01", "123", "1212", 15, 2);
    }

}
